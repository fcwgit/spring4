package cn.xyz.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTemplateTest {
    public static void main(String[] args) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/sampledb");
        dataSource.setUsername("root");
        dataSource.setPassword("gsd88888");

        //JdbcTemplate jdbcTemplate = new JdbcTemplate();
        //jdbcTemplate.setDataSource(dataSource);
        //
        //String sql = "CREATE TABLE t_user(user_id int primary key,user_name varchar(60))";
        //
        //jdbcTemplate.execute(sql);

        Connection connection = null;
        Statement statement = null;
        try {
            String sql = "CREATE TABLE t_user(user_id int primary key,user_name varchar(60))";
           connection  = dataSource.getConnection();
           statement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

            ResultSet resultSet = statement.getGeneratedKeys();
            while (resultSet.next()){
                int key = resultSet.getInt(1);
                System.out.println(key);
            }

           connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if (connection != null){
                    connection.close();
                }
            }catch (Exception e){

            }
        }
    }
}
