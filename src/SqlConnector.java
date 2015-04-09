/**
 * Created by neil on 15/3/31.
 */

import java.sql.*;

public class SqlConnector {
    static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
    static final String DB_URL = "jdbc:oracle:thin:@ora.csc.ncsu.edu:1521:orcl";

    static final String USER = "pkatyay";
    static final String PASS = "200062351";

    private Connection conn = null;
    private Statement stmt = null;

    public SqlConnector(){
        try {
            Class.forName(JDBC_DRIVER);
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
