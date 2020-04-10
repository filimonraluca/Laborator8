package dataInOopFormat;

import com.github.javafaker.Faker;

/**
 * Clasa Artist reprezinta un artist pe care dorim sa il inseram in baza de date. Are atributele name si country care
 * se regasesc si in baza de date.
 */
public class Artist {
    String name;
    String country;

    /**
     * Constructorul apeleaza metoda createArtistWithRandomData() pentru a atribui valori random artistului
     */
    public Artist() {
        createArtistWithRandomData();
    }


    /**
     * Metoda createArtistWithRandomData foloseste libraria Faker pentru a genera date.
     */
    public void createArtistWithRandomData(){
        Faker faker = new Faker();
        this.name = faker.artist().name();
        this.country = faker.country().name();
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
