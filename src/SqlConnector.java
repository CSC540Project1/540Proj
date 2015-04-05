/**
 * Created by neil on 15/3/31.
 */

import java.sql.*;

public class SqlConnector {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/test";

    static final String USER = "test";
    static final String PASS = "1234";

    Connection conn = null;
    Statement stmt = null;

    public SqlConnector(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connection getConn(){
        return conn;
    }

    public Statement getStmt() {
        return stmt;
    }
}
