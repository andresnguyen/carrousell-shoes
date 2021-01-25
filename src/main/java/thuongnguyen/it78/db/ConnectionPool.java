package thuongnguyen.it78.db;

import java.sql.*;

public interface ConnectionPool {
    Connection getConnection() throws SQLException, ClassNotFoundException;
    void releaseConnection(Connection connection);
    String getUrl();
    String getUser();
    String getPassword();
    int getSize();
    int getUsesCon();
    int getNumCon();
}