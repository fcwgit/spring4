package cn.xyz.jdbc;

import cn.xyz.domain.Forum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ForumDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void initDb(){
        String sql = "CREATE TABLE t_user(user_id int primary key,user_name varchar(60))";
        jdbcTemplate.execute(sql);
    }

    public void addForum(Forum forum){
        String sql = "INSERT INTO t_forum(forum_name,forum_desc)VALUES(?,?)";
        Object[] params = new Object[]{forum.getForumName(),forum.getForumDesc()};

        //jdbcTemplate.update(sql,params);

        //jdbcTemplate.update(sql,params,new int[]{Types.VARBINARY,Types.VARBINARY});

        jdbcTemplate.update(sql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1,forum.getForumName());
                ps.setString(2,forum.getForumDesc());
            }
        });

    }

    public void addForum2(Forum forum){
        String sql = "INSERT INTO t_forum(forum_name,forum_desc)VALUES(?,?)";
        Object[] params = new Object[]{forum.getForumName(),forum.getForumDesc()};

        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement statement = con.prepareStatement(sql);
                statement.setString(1,forum.getForumName());
                statement.setString(2,forum.getForumDesc());
                return statement;
            }
        });
    }

    public void addForum3(Forum forum){
        String sql = "INSERT INTO t_forum(forum_name,forum_desc)VALUES(?,?)";
        Object[] params = new Object[]{forum.getForumName(),forum.getForumDesc()};
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement statement = con.prepareStatement(sql,new String[]{"forum_id"});
                statement.setString(1,forum.getForumName());
                statement.setString(2,forum.getForumDesc());
                return statement;
            }
        },keyHolder);

        System.out.println(keyHolder.getKey());
    }

    public Forum getForum(int forumId){
        String sql = "SELECT forum_name,forum_desc FROM t_forum WHERE forum_id=?";
        Forum forum = new Forum();
        jdbcTemplate.query(sql, new Object[]{forumId}, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet rs) throws SQLException {
                forum.setForumId(forumId);
                forum.setForumName(rs.getString("forum_name"));
                forum.setForumDesc(rs.getString("forum_desc"));
            }
        });
        return forum;
    }

    public List<Forum> getForums(){
        String sql = "SELECT forum_id,forum_name,forum_desc FROM t_forum ";
        List<Forum> forumList = new ArrayList<Forum>();
        jdbcTemplate.query(sql, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet rs) throws SQLException {
                Forum forum = new Forum();
                forum.setForumId(rs.getInt("forum_id"));
                forum.setForumName(rs.getString("forum_name"));
                forum.setForumDesc(rs.getString("forum_desc"));

                forumList.add(forum);
            }
        });
        return forumList;
    }
    
    public List<Forum> getForums2(){
        String sql = "SELECT forum_id,forum_name,forum_desc FROM t_forum ";
        return jdbcTemplate.query(sql, new RowMapper<Forum>() {
            @Override
            public Forum mapRow(ResultSet rs, int rowNum) throws SQLException {
                Forum forum = new Forum();
                forum.setForumId(rs.getInt("forum_id"));
                forum.setForumName(rs.getString("forum_name"));
                forum.setForumDesc(rs.getString("forum_desc"));
                return forum;
            }
        });
    }

    public int getUserTopicNum(int userId){
        String sql = "{call P_GET_TOPIC(?,?)";
        Integer num = jdbcTemplate.execute(sql, new CallableStatementCallback<Integer>() {
            @Override
            public Integer doInCallableStatement(CallableStatement cs) throws SQLException, DataAccessException {
                cs.setInt(1,userId);
                cs.registerOutParameter(2,Types.INTEGER);
                cs.execute();
                return cs.getInt(2);
            }
        });
        return num;
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        ForumDao forumDao = (ForumDao)context.getBean("forumDao");
        //forumDao.initDb();

        //Forum forum = new Forum();
        //forum.setForumName("john");
        //forum.setForumDesc("zookeeper");
        //
        //forumDao.addForum3(forum);

        //Forum forum = forumDao.getForum(4);
        //System.out.println(forum);

        //List<Forum> forumList = forumDao.getForums2();
        //System.out.println(forumList);
        int num = forumDao.getUserTopicNum(1);
        System.out.println(num);
    }


}
