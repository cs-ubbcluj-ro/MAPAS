package seminar.group323.Seminar3.repository;

import seminar.group323.Seminar3.domain.Music;

public class MusicFactory implements Factory<Music> {
    @Override
    public Music fromTokens(String[] t) {
        if (t.length < 3) throw new RuntimeException("Linie invalidă pentru Music");
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
}
