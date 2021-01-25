package thuongnguyen.it78.daos;

import java.sql.*;

public class ConnectDB {
    public static Connection getConnection(){
        String driver = "com.mysql.jdbc.Driver";
        String DB_username = "root";
        String DB_password = "";
        String DB_URL = "jdbc:mysql://127.0.0.1:3306/shoes";
        Connection connect = null;

        try {
            Class.forName(driver);
            connect = DriverManager.getConnection(DB_URL, DB_username, DB_password);
            return connect;
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Exception " + e);
            return null;
        }
    }

}
