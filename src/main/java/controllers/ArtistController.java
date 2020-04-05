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

    public ArtistController(Database database) {
        this.connection = database.getConnection();
        try {
            this.statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void create(String name, String country) {
        try {
            String command = String.format("insert into artists(name,country) values ('%s','%s')", name, country);
            statement.executeUpdate(command);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

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
