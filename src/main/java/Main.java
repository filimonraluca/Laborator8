import java.sql.*;

import controllers.ChartController;
import databaseManager.Database;
import dataInOopFormat.Album;
import dataInOopFormat.Artist;
import dataInOopFormat.Chart;
import controllers.ArtistController;
import controllers.AlbumController;

import javax.xml.crypto.Data;

public class Main {
    public static void main(String[] args) throws SQLException {
        Database database = new Database();
        ArtistController artistController = new ArtistController(database);
        AlbumController albumController = new AlbumController(database);
        ChartController chartController = new ChartController(database);
        int numberOfCharts = (int) (Math.random() * 4) + 1;
        for (int i = 1 ; i<=numberOfCharts ; i++) {
            Chart chart = new Chart();
            int numberOfAlbums = (int) (Math.random() * 10) + 3;
            for (int j = 1; j <= numberOfAlbums; j++) {
                Artist artist = new Artist();
                Album album = new Album(artist);
                artistController.create(artist);
                albumController.create(album);
                chart.addToChart(album);
            }
            System.out.println(chart);
            chartController.create(chart);
            System.out.printf("----- Chart nr. %d ------\n ", i);
            chart.displayChart();
        }
        database.closeConnection();
    }

}
