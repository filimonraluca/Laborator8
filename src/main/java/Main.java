import java.sql.*;
import databaseManager.Database;
import controllers.ArtistController;
import controllers.AlbumController;

import javax.xml.crypto.Data;

public class Main {
    public static void main(String[] args) {
        Database database = new Database();
        ArtistController artistController = new ArtistController(database);
        AlbumController albumController = new AlbumController(database);

        artistController.create("Michael Jackson", "United States");
        artistController.create("Beyonce", "United States");
        artistController.create("Shakira", "Colombia");
        artistController.create("Killa Fonic", "Romania");
        artistController.create("Smiley", "Romania");


        albumController.create("Dangerous",1, 1991);
        albumController.create("Lemonade",2, 2016);
        albumController.create("Lama Crima",4, 2017);

        artistController.findByName("Michael Jackson");
        artistController.findByName("Nane");

        albumController.findByArtist(1);
        albumController.findByArtist(5);

    }

}
