package crud.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBcon {
    public static Connection getConnection() throws SQLException {
        String Driver = "com.mysql.cj.jdbc.Driver";
        String url ="jdbc:mysql://localhost:3306/green";
        String user = "root";
        String password = "850818";
        Connection conn = DriverManager.getConnection(url, user, password);
        return conn;
    }
}
