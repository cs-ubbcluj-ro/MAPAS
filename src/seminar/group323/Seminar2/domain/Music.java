package seminar.group323.Seminar2.domain;

public class Music extends Product{
    private String genre;

    public Music(int id, String name, double price, String genre) {
        super(id, name, price);
        this.genre = genre;
    }

    String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public void play(){
        System.out.println("Music is playing: "+ getName() + " " + getGenre());
    }
    @Override
    public String toString() {
        return "Music{" +
                "genre='" + genre + '\'' +
                '}';
    }
}
