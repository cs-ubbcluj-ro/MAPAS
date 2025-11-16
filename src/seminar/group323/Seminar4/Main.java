package seminar.group323.Seminar4;

import seminar.group323.Seminar4.domain.Album;
import seminar.group323.Seminar4.domain.Music;
import seminar.group323.Seminar4.repository.Repository;
import seminar.group323.Seminar4.service.AlbumService;
import seminar.group323.Seminar4.service.MusicService;
import seminar.group323.Seminar4.ui.ConsoleUI;
import seminar.group323.Seminar4.repository.*;
import seminar.group323.Seminar4.service.Settings;

import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        // Folosim Singleton-ul Settings pentru a citi setările
        Settings settings = Settings.getInstance();
        String repoType = settings.getRepositoryType();
        
        System.out.println("Repository type: " + repoType);

        // Construim repo-urile pe baza setărilor
        Repository<Album> albumRepo = switch (repoType) {
            case "memory" -> new InMemoryRepository<>();
            case "binary" -> new BinaryFileRepository<>(Path.of(settings.getAlbumsPath()));
            case "text" -> new TextFileRepository<>(Path.of(settings.getAlbumsPath()), new AlbumFactory());
            case "sql" -> new SqlRepository<>(settings.getDatabasePath(), "albums", new AlbumFactory());
            default -> throw new IllegalArgumentException("Tip repo necunoscut: " + repoType);
        };

        Repository<Music> musicRepo = switch (repoType) {
            case "memory" -> new InMemoryRepository<>();
            case "binary" -> new BinaryFileRepository<>(Path.of(settings.getMusicPath()));
            case "text" -> new TextFileRepository<>(Path.of(settings.getMusicPath()), new MusicFactory());
            case "sql" -> new SqlRepository<>(settings.getDatabasePath(), "music", new MusicFactory());
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
        
        // Conexiunile SQLite se inchid automat cu JVM
        // Daca e nevoie explicit, se poate adauga shutdown hook
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Aplicația se închide...");
        }));
    }
}
