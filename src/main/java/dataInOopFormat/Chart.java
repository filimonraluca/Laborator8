package dataInOopFormat;

import java.util.ArrayList;
import java.util.List;

/**
 * Clasa chart contine o lista de albume intr-o anumita ordine.
 */
public class Chart {
    List<Album> albums = new ArrayList<>();

    public void addToChart(Album album) {
        albums.add(album);
    }

    public List<Album> getAlbums() {
        return albums;
    }

    /**
     * Metoda displayChart() afiseaza albumele in ardinea in care se afla in clasament.
     */
    public void displayChart() {
        for (int i = 0; i < albums.size(); i++) {
            Album currentAlbum = albums.get(i);
            System.out.printf("Nr. %d the album '%s' by %s\n", i + 1, currentAlbum.getName(), currentAlbum.getArtist().getName());
        }
    }

    @Override
    public String toString() {
        return "Chart{" +
                "albums=" + albums +
                '}';
    }
}
