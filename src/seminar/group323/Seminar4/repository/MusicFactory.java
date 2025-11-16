package seminar.group323.Seminar4.repository;

import seminar.group323.Seminar4.domain.Music;
import seminar.group323.Seminar4.repository.Factory;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MusicFactory implements Factory<Music> {
    @Override
    public Music fromTokens(String[] t) {
        if (t.length < 4) throw new RuntimeException("Linie invalidă pentru Music");
        int id = Integer.parseInt(t[0]);
        String name = t[1];
        double price = Double.parseDouble(t[2]);
        String genre = t[3];
        return new Music(id, name, price, genre);
    }

    @Override
    public String toLine(Music m) {
        return m.getId() + ";" + m.getName() + ";" + m.getPrice() + ";" + m.getGenre();
    }

    @Override
    public Music fromResultSet(ResultSet rs) throws SQLException {
        System.out.println("ResultSet rs: " + rs);
        int id = rs.getInt("id");
        String name = rs.getString("name");
        double price = rs.getDouble("price");
        String genre = rs.getString("genre");
        return new Music(id, name, price, genre);
    }
}
