package controllers;

import com.sun.scenario.effect.impl.sw.java.JSWBlend_SRC_OUTPeer;
import databaseManager.Database;
import org.w3c.dom.ls.LSOutput;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ArtistController {
    Connection connection;
    Statement statement;

    /**
     * In constructor am preluat obiectul de tip Connectiom din database.
     * Dupa ce am preluat connetion din obiectul de tip Database il putem folosi pentru a initializa
     * atributul de tip Statment al clasei necesar pentru a executa query-uri in baza de date
     * @param database un obiect de tip Database de la care vom prelua obiectul connection
     */
    public ArtistController(Database database) {
        this.connection = database.getConnection();
        try {
            this.statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * In aceasta metoda am formatat stringul command cu rol de query. Prin acest query dorim sa inseram in tabela
     * astists un artist nou. Pentru a executa queryul este necesara metoda executeUpdate deoarece in query
     * incercam sa realizam o inserare.
     * @param name
     * @param country
     */
    public void create(String name, String country) {
        try {
            String command = String.format("insert into artists(name,country) values ('%s','%s')", name, country);
            statement.executeUpdate(command);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * In aceasta metoda am formatat stringul command cu rol de query. Prin acest query dorim sa selectam din tabela
     * randurile unde numele corespunde cu cel dat ca paramentru.
     * Pentru a executa queryul este necesara metoda executeQuery deoarece in query incercam sa facem un select.
     * ExecuteQuery returneaza un obiect de tipul ResultSet pentru care vom apela metoda next().
     * Metoda next muta cursorul de la pozitia curenta la prima linie, daca metoda returneaza false inseamna ca aceasta este goala
     * adica prin executia query-ului nu s-a selectat nicio linie deci artistul nu se afla in baza de date.
     * @param name
     */
    public void findByName(String name) {
        String command = String.format("select * from artists where name = '%s'", name);
        try {
            ResultSet rs = statement.executeQuery(command);
            if (rs.next() != false) {
                System.out.printf("Artistul %s se afla in baza de date\n", name);
            } else {
                System.out.printf("Artistul %s NU se afla in baza de date\n", name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
