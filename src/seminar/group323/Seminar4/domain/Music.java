package seminar.group323.Seminar4.domain;

import java.io.Serial;

public class Music extends Product {
    @Serial
    private static final long serialVersionUID = 1L;
    private String genre;

    public Music(int id, String name, double price, String genre) {
        super(id, name, price);
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void play() {
        System.out.println("Music is playing: " + getName() + " " + getGenre());
    }

    @Override
    public String toString() {
        return "Music{" + '\'' + "name: " + getName() + '\'' + "price: " + getPrice() + '\'' +
                "genre='" + getGenre() + '\'' +
                '}';
    }
}
