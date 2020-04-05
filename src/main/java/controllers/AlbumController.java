package controllers;

import databaseManager.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AlbumController {
    Connection connection;
    Statement statement;

    public AlbumController(Database database) {
        this.connection = database.getConnection();
        try {
            this.statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void create(String name, int artistId, int releaseYear) {
        try {
            String command = String.format("insert into albums(name,artist_id,release_year) values ('%s','%d',%d)", name, artistId, releaseYear);
            statement.executeUpdate(command);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void findByArtist(int artistId) {
        String command = String.format("select * from albums where artist_id = '%d'", artistId);
        try {
            ResultSet rs = statement.executeQuery(command);
            if (rs.next() != false) {
                System.out.printf("Artistul cu id-ul %d are album in DB\n", artistId);
            } else {
                System.out.printf("Artistul cu id-ul %d nu are niciun album in DB\n", artistId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
