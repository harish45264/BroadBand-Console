package util;
import java.sql.*;
import userview.*;

public class DBManager {
    BandView v = new BandView();
    public static final String user = "root";
    public static final String url = "jdbc:mysql://localhost:3306/alan";
    public static final String password = "Harishragini#45";
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(url, user, password);
    }
}