package cn.xyz.jdbc;

import cn.xyz.domain.Post;
import jdk.internal.util.xml.impl.Input;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.AbstractLobCreatingPreparedStatementCallback;
import org.springframework.jdbc.core.support.AbstractLobStreamingResultSetExtractor;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.jdbc.support.lob.LobCreator;
import org.springframework.jdbc.support.lob.LobHandler;
import org.springframework.stereotype.Repository;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PostDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private LobHandler lobHandler;

    public void getNativeConn(){
        Connection connection = null;
        try {
            connection = DataSourceUtils.getConnection(jdbcTemplate.getDataSource());
            connection = jdbcTemplate.getNativeJdbcExtractor().getNativeConnection(connection);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (connection != null){
                    connection.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public void addPost(Post post){
        String sql = "INSERT INTO t_post(post_id,user_id,post_text,post_attach)VALUES(?,?,?,?)";
        jdbcTemplate.execute(sql, new AbstractLobCreatingPreparedStatementCallback(this.lobHandler) {
            @Override
            protected void setValues(PreparedStatement ps, LobCreator lobCreator) throws SQLException, DataAccessException {
                ps.setInt(1,1);
                ps.setInt(2,post.getUserId());
                lobCreator.setClobAsString(ps,3,post.getPostText());
                lobCreator.setBlobAsBytes(ps,4,post.getPostAttach());
            }
        });
    }

    public List getAttach(int userId){
        String sql = "SELECT post_id,post_attach FROM t_post where user_id=? and post_attach is not null";
        return jdbcTemplate.query(sql, new Object[]{userId}, new RowMapper<Post>() {
            @Override
            public Post mapRow(ResultSet rs, int rowNum) throws SQLException {
                int postId = rs.getInt(1);
                byte[] attach = lobHandler.getBlobAsBytes(rs,2);
                Post post = new Post();
                post.setPostId(postId);
                post.setPostAttach(attach);
                return post;
            }
        });
    }

    public void getAttach2(int postId, OutputStream outputStream){
        String sql = "SELECT post_attach FROM t_post WHERE post_id=?";
        jdbcTemplate.query(sql, new Object[]{postId}, new AbstractLobStreamingResultSetExtractor<Object>() {
            @Override
            protected void handleNoRowFound() throws DataAccessException {
                System.out.println("Not found result !");
            }

            @Override
            protected void streamData(ResultSet rs) throws SQLException, IOException, DataAccessException {
                InputStream inputStream = lobHandler.getBlobAsBinaryStream(rs,1);
                if (inputStream != null){
                    FileCopyUtils.copy(inputStream,outputStream);
                }
            }
        });
    }
}
