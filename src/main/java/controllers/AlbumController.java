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
    /**
     * In aceasta metoda am formatat stringul command cu rol de query. Prin acest query dorim sa inseram in tabela
     * albums un album nou. Pentru a executa queryul este necesara metoda executeUpdate deoarece in query
     * incercam sa facem o inserare.
     * @param name
     * @param artistId
     * @param releaseYear
     */
    public void create(String name, int artistId, int releaseYear) {
        try {
            String command = String.format("insert into albums(name,artist_id,release_year) values ('%s','%d',%d)", name, artistId, releaseYear);
            statement.executeUpdate(command);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * In aceasta metoda am formatat stringul command cu rol de query. In acest query dorim sa selectam din tabela
     * randurile unde id-ul artistului corespunde cu cel dat ca paramentru.
     * Pentru a executa queryul este necesara metoda executeQuery deoarece in query incercam sa facem un select.
     * ExecuteQuery returneaza un obiect de tipul ResultSet pentru care vom apela metoda next().
     * Metoda next muta cursorul de la pozitia curenta la prima linie, daca metoda returneaza false inseamna ca aceasta este goala
     * adica prin executia query-ului nu s-a selectat nicio linie deci artistul nu are niciun album in baza de date.
     * @param artistId
     */

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
