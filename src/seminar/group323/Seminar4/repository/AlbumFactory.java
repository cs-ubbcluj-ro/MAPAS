package seminar.group323.Seminar4.repository;

import seminar.group323.Seminar4.domain.Album;
import seminar.group323.Seminar4.exceptions.RepositoryException;
import seminar.group323.Seminar4.repository.Factory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

public class AlbumFactory implements Factory<Album> {
    private static final String DELIM = ";";

    @Override
    public Album fromTokens(String[] t) {
        try {
            // format: id;title;price;artist
            if (t == null || t.length < 4) {
                throw new RepositoryException("Linie invalidă pentru Album: " + Arrays.toString(t));
            }
            int id = Integer.parseInt(t[0].trim());
            String title = t[1].trim();
            double price = Double.parseDouble(t[2].trim());
            String artist = t[3].trim();

            return new Album(id, title, price, artist);
        } catch (NumberFormatException e) {
            throw new RepositoryException("Format numeric invalid în linie: " + Arrays.toString(t), e);
        }
    }

    @Override
    public String toLine(Album a) {
        // format: id;title;price;artist
        return a.getId() + DELIM
                + safe(a.getName()) + DELIM
                + a.getPrice() + DELIM
                + safe(a.getArtist());
    }

    @Override
    public Album fromResultSet(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String title = rs.getString("title");
        double price = rs.getDouble("price");
        String artist = rs.getString("artist");
        return new Album(id, title, price, artist);
    }

    private String safe(String s) {
        return s == null ? "" : s.replace("\n", " ").trim();
    }
}
