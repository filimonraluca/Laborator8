package controllers;

import dataInOopFormat.Chart;
import databaseManager.Database;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ChartController {
    Connection connection;
    Statement statement;

    /**
     * In constructor am preluat obiectul de tip Connectiom din database.
     * Dupa ce am preluat connetion din obiectul de tip Database il putem folosi pentru a initializa
     * atributul de tip Statment al clasei necesar pentru a executa query-uri in baza de date
     *
     * @param database un obiect de tip Database de la care vom prelua obiectul connection
     */
    public ChartController(Database database) {
        this.connection = database.getConnection();
        try {
            this.statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * In aceasta metoda dorim sa inseram in baza de date chartul primit ca parametru in format JSON. Initial cream obiectul
     * de tip JSONArray care contine iteme de tip JSONObject cu urmatoarea structura {"id":1, "album_id": ..}. Pentru a crea acest
     * obiect parcurgem toate albumele din chart-ul primit ca parametru si aflam id-ul acestora printr-o interogare in baza de date.
     * Dupa ce am aflat id-ul cream itemul de tip JSONObject cu formatul prezentat mai sus si il adaugam in JSONArray. Dupa ce am parcurs
     * toate albumele inseram in tabela charts JSONArray-ul folosind obiectul statment si metoda executeUpdate.
     * @param chart
     */
    public void create(Chart chart) {
        JSONArray jsonArray = new JSONArray();
        try {
            for (int i = 0; i < chart.getAlbums().size(); i++) {
                String getIdCommand = String.format("select id from albums where name = '%s'", chart.getAlbums().get(i).getName());
                ResultSet rs = null;
                rs = statement.executeQuery(getIdCommand);
                int id = 0;
                while (rs.next()) {
                    id = rs.getInt("id");
                }
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("id", i+1);
                jsonObject.put("album_id", id);
                jsonArray.add(jsonObject);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(jsonArray.toString());
        String command = String.format("insert into charts(chart) values('%s')", jsonArray.toString());
        try {
            statement.executeUpdate(command);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
