package seminar.group323.Seminar4.domain;

import java.io.Serial;
import java.util.ArrayList;

public class Album extends Product {
    @Serial
    private static final long serialVersionUID = 1L;
    private ArrayList<Music> track;
        private String artist;

        public Album(int id,String name, double price, String artist) {
            super(id, name, price);
            track = new ArrayList<>();
            this.artist = artist;

    }

    public ArrayList<Music> getTrack() {
        return track;
    }
    public void setTrack(ArrayList<Music> track) {
            this.track = track;
    }
    public String getArtist() {
            return artist;
    }
    public void setArtist(String artist) {
            this.artist = artist;
    }

    public void addTrack(Music music){
        track.add(music);
    }

    ArrayList<Music> getTracks()
    {
        return track;
    }


    @Override
    public String toString() {
        return "Album{" +
                "track=" + track +
                ", artist='" + artist + '\'' +
                '}';
    }
}
