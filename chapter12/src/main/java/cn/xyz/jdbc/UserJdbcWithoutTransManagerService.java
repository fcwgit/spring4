package cn.xyz.jdbc;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserJdbcWithoutTransManagerService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addScore(String userName,int toAdd){
        String sql = "UPDATE t_user u SET u.score=u.score + ? where user_name = ?";
        jdbcTemplate.update(sql,toAdd,userName);
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("cn/xyz/jdbc/withouttx/hiberWithoutTx.xml");
        UserJdbcWithoutTransManagerService service = (UserJdbcWithoutTransManagerService)context.getBean("userJdbcWithoutTransManagerService");
        JdbcTemplate jdbcTemplate = (JdbcTemplate)context.getBean("jdbcTemplate");
        BasicDataSource basicDataSource = (BasicDataSource)jdbcTemplate.getDataSource();
        System.out.println("autoCommit:" + basicDataSource.getDefaultAutoCommit());
        jdbcTemplate.execute("INSERT INTO t_user(user_name,password,score,last_logon_time)VALUES('tom','123456',10,"+System.currentTimeMillis()+")");
        service.addScore("tom",20);
        int score = jdbcTemplate.queryForObject("SELECT score FROM t_user WHERE user_name='tom'",Integer.class);
        System.out.println("score:" + score);
        jdbcTemplate.execute("DELETE FROM t_user WHERE user_name='tom'");
    }
}































