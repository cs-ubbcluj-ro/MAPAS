package seminar.group323.Seminar2;

import seminar.group323.Seminar2.domain.Album;
import seminar.group323.Seminar2.domain.Music;
import seminar.group323.Seminar2.repository.Repository;
import seminar.group323.Seminar2.service.AlbumService;
import seminar.group323.Seminar2.service.MusicService;
import seminar.group323.Seminar2.ui.ConsoleUI;

public class Main {

    public static void main(String[] args) {
        Repository<Album> albumRepo = new Repository<>();
        Repository<Music> musicRepo = new Repository<>();

        AlbumService albumService = new AlbumService(albumRepo);
        MusicService musicService = new MusicService(musicRepo);

        Music track1 = new Music(1, "La Multi Ani", 2.0, "Traditional");
        Music track2 = new Music(2, "Ode to Joy", 3.5, "Classical");
        Music track3 = new Music(3, "Fur Elise", 4.0, "Classical");
        Music track4 = new Music(4, "Canon in D", 4.5, "Classical");
        Music track5 = new Music(5, "Silent Night", 3.0, "Christmas");

        musicService.addMusic(track1);
        musicService.addMusic(track2);
        musicService.addMusic(track3);
        musicService.addMusic(track4);
        musicService.addMusic(track5);

        Album album1 = new Album(1, "Traditionale", 15.0, "Various Artists");
        Album album2 = new Album(2, "Clasic Favorites", 25.0, "Beethoven & Co");
        Album album3 = new Album(3, "Sarbatori", 20.0, "Various Artists");

        album1.addTrack(track1);
        album2.addTrack(track2);
        album2.addTrack(track3);
        album2.addTrack(track4);
        album3.addTrack(track5);
        album3.addTrack(track1);

        albumService.addAlbum(album1);
        albumService.addAlbum(album2);
        albumService.addAlbum(album3);

        ConsoleUI ui = new ConsoleUI(albumService, musicService);
        ui.start();
    }
}
