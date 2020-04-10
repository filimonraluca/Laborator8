package dataInOopFormat;
import com.github.javafaker.Faker;

/**
 * Clasa Album reprezinta un album pe care dorim sa il inseram in baza de date. Atributul name este numele albumului, iar
 * releaseYear anul in care a fost publicat. De asemenea are si un atribut de tipul Artist care reprezinta artistul ce a lansat
 * albumul.
 */
public class Album {
    String name;
    Artist artist;
    int releaseYear;

    /**
     * Constructorul primeste ca parametru artistul care lanseaza albumul
     * si apeleaza metoda createAlbumWithRandomData() pentru a atribui valori random pentru nume si anul lansarii
     */
    public Album(Artist artist) {
        this.artist = artist;
        createAlbumWithRandomData();
    }

    /**
     * Metoda createArtistWithRandomData foloseste libraria Faker pentru a genera date.
     */
    public void createAlbumWithRandomData() {
        Faker faker = new Faker();
        this.name = faker.name().firstName();
        this.releaseYear = (int) (Math.random() * 40) + 1980;
    }

    public String getName() {
        return name;
    }

    public Artist getArtist() {
        return artist;
    }

    public int getReleaseYear() {
        return releaseYear;
    }


    @Override
    public String toString() {
        return "Album{" +
                "name='" + name + '\'' +
                ", artist=" + artist +
                ", releaseYear=" + releaseYear +
                '}';
    }
}
