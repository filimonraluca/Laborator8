package databaseManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    Connection connection = null;

    /**
     * In constructorul clasei Database am creat conexiunea catre baza de date folosind DriverManager si metoda getConnection
     * ,metoda care incearca sa stabileasca o conexiune la baza de date cu url-ul specificat in numele utilizatorului dba
     * cu parola sql.
     */
    public Database() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/MusicAlbum?useSSL=false", "dba" , "sql");
            System.out.println("databaseManager.Database connection successful!\n");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection()
    {
        return connection;
    }


}
