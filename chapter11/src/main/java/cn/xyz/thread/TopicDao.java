package cn.xyz.thread;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TopicDao {
    private static ThreadLocal<Connection> connectionThreadLocal = new ThreadLocal<Connection>();
    public static Connection getConnection(){
        if (connectionThreadLocal.get() == null){
            Connection connection = ConnectionManage.getConnection();
            connectionThreadLocal.set(connection);
            return connection;
        }else {
            return connectionThreadLocal.get();
        }
    }

    public void addTopic() throws SQLException {
        Statement statement = getConnection().createStatement();
    }
}
