package thuongnguyen.it78.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class DBConnection {
    public static ConnectionPool pool;

    public static Connection createConnection() throws ClassNotFoundException, SQLException, SQLException {
        Connection con = null;
        if (pool == null) {
            pool = BasicConnectionPool.create("jdbc:mysql://localhost:3306/LTW?useUnicode=true&amp;characterEncoding=utf8", "root", "passion");
        }
        con = pool.getConnection();
        System.out.println("Size of connection pool: "+ pool.getNumCon());
        System.out.println("Size of used connection: "+ pool.getUsesCon());
        return con;
    }
}
