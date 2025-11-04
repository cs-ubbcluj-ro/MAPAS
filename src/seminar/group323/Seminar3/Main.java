package seminar.group323.Seminar3;

import seminar.group323.Seminar3.domain.Album;
import seminar.group323.Seminar3.domain.Music;
import seminar.group323.Seminar3.repository.Repository;
import seminar.group323.Seminar3.service.AlbumService;
import seminar.group323.Seminar3.service.MusicService;
import seminar.group323.Seminar3.ui.ConsoleUI;
import seminar.group323.Seminar3.repository.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        // Citim setările
        Properties props = new Properties();
        try {
            Path cfg = Path.of("src/seminar/group323/Seminar3/settings.properties");
//            System.out.println("WD " + Path.of("").toAbsolutePath()); // working dir

            if (Files.exists(cfg)) {
                try (var in = Files.newInputStream(cfg)) {
                    props.load(in);
                }
            }
        } catch (Exception e) {
            System.out.println("Nu am putut citi settings.properties: " + e.getMessage());
            // continuăm cu valori implicite (memory)
        }

        String repoType = props.getProperty("Repository", "memory").toLowerCase();
        System.out.println(repoType);
        Path albumsPath = Path.of(props.getProperty("Albums", "src/seminar/group323/Seminar3/data/albums.bin"));
        Path musicPath = Path.of(props.getProperty("Music", "src/seminar/group323/Seminar3/data/music.bin"));
        Path albumsTxt = Path.of(props.getProperty("Albums", "src/seminar/group323/Seminar3/data/albums.txt"));
        Path musicTxt = Path.of(props.getProperty("Music", "src/seminar/group323/Seminar3/data/music.txt"));


        // Construim repo-urile pe baza setărilor
        Repository<Album> albumRepo = switch (repoType) {
            case "memory" -> new InMemoryRepository<>();
            case "binary" -> new BinaryFileRepository<>(albumsPath);
            case "text" -> new TextFileRepository<>(albumsTxt, new AlbumFactory());

            default -> throw new IllegalArgumentException("Tip repo necunoscut: " + repoType);
        };

        Repository<Music> musicRepo = switch (repoType) {
            case "memory" -> new InMemoryRepository<>();
            case "binary" -> new BinaryFileRepository<>(musicPath);
            case "text" -> new TextFileRepository<>(musicTxt, new MusicFactory());

            default -> throw new IllegalArgumentException("Tip repo necunoscut: " + repoType);
        };

        // Service depinde de interfață, nu de implementare
        AlbumService albumService = new AlbumService(albumRepo);
        MusicService musicService = new MusicService(musicRepo);

        if (albumRepo.size() == 0) {
            Music track1 = new Music(1, "La Multi Ani", 2.0, "Traditional");
            musicService.addMusic(track1);
            Album album1 = new Album(1, "Traditionale", 15.0, "Various Artists");
            albumService.addAlbum(album1);

        }

        ConsoleUI ui = new ConsoleUI(albumService, musicService);
        ui.start();
    }
}
