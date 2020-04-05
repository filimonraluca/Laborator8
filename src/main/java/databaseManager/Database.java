package databaseManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    static Connection connection = null;

    public Database() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/MusicAlbum", "dba" , "sql");
            System.out.println("databaseManager.Database connection successful!\n");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection()
    {
        return connection;
    }
}
