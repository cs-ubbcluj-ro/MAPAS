package seminar.group323.Seminar2.ui;

import seminar.group323.Seminar2.domain.Album;
import seminar.group323.Seminar2.domain.Music;
import seminar.group323.Seminar2.service.AlbumService;
import seminar.group323.Seminar2.service.MusicService;

import java.util.Scanner;

public class ConsoleUI {

    private final AlbumService albumService;
    private final MusicService musicService;
    private final Scanner scanner;

    public ConsoleUI(AlbumService albumService, MusicService musicService) {
        this.albumService = albumService;
        this.musicService = musicService;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        boolean running = true;

        while (running) {
            printMenu();
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1 -> addAlbum();
                case 2 -> addMusic();
                case 3 -> deleteAlbum();
                case 4 -> deleteMusic();
                case 5 -> listAlbums();
                case 6 -> listMusic();
                case 7 -> searchAlbum();
                case 8 -> searchMusic();
                case 9 -> updateAlbum();
                case 10 -> addTrackToAlbum();
                case 11 -> clearAlbums();
                case 0 -> {
                    running = false;
                    System.out.println("Iesire");
                }
                default -> System.out.println("Optiune invalida");
            }
        }
    }

    private void printMenu() {
        System.out.println("1. Adauga album");
        System.out.println("2. Adauga melodie");
        System.out.println("3. Sterge album dupa ID");
        System.out.println("4. Sterge melodie dupa ID");
        System.out.println("5. Afiseaza toate albumele");
        System.out.println("6. Afiseaza toate melodiile");
        System.out.println("7. Cauta album dupa ID");
        System.out.println("8. Cauta melodie dupa ID");
        System.out.println("9. Actualizeaza album");
        System.out.println("10. Adauga melodie la album");
        System.out.println("11. Curata toate albumele");
        System.out.println("0. Iesire");
        System.out.print("Alege optiunea: ");
    }

    private void addAlbum() {
        System.out.print("ID album: "); int id = scanner.nextInt(); scanner.nextLine();
        System.out.print("Nume album: "); String name = scanner.nextLine();
        System.out.print("Pret: "); double price = scanner.nextDouble(); scanner.nextLine();
        System.out.print("Artist: "); String artist = scanner.nextLine();
        albumService.addAlbum(new Album(id, name, price, artist));
        System.out.println("Album adaugat");
    }

    private void addMusic() {
        System.out.print("ID melodie: "); int id = scanner.nextInt(); scanner.nextLine();
        System.out.print("Nume melodie: "); String name = scanner.nextLine();
        System.out.print("Pret: "); double price = scanner.nextDouble(); scanner.nextLine();
        System.out.print("Gen: "); String genre = scanner.nextLine();
        musicService.addMusic(new Music(id, name, price, genre));
        System.out.println("Melodie adaugata");
    }

    private void deleteAlbum() {
        System.out.print("ID album de sters: "); int id = scanner.nextInt();
        albumService.deleteAlbum(id);
        System.out.println("Album sters (daca exista).");
    }

    private void deleteMusic() {
        System.out.print("ID melodie de sters: "); int id = scanner.nextInt();
        musicService.deleteMusic(id);
        System.out.println("Melodie stearsa (daca exista).");
    }

    private void listAlbums() {
        System.out.println(albumService.getAllAlbums());
    }

    private void listMusic() {
        System.out.println(musicService.getAllMusic());
    }

    private void searchAlbum() {
        System.out.print("ID album: "); int id = scanner.nextInt();
        System.out.println(albumService.getAlbum(id));
    }

    private void searchMusic() {
        System.out.print("ID melodie: "); int id = scanner.nextInt();
        System.out.println(musicService.getMusic(id));
    }

    private void updateAlbum() {
        System.out.print("ID album de actualizat: "); int id = scanner.nextInt(); scanner.nextLine();
        Album existing = albumService.getAlbum(id);
        if (existing == null) { System.out.println("Album inexistent"); return; }
        System.out.print("Nume nou: "); String name = scanner.nextLine();
        System.out.print("Pret nou: "); double price = scanner.nextDouble(); scanner.nextLine();
        System.out.print("Artist nou: "); String artist = scanner.nextLine();
        albumService.updateAlbum(new Album(id, name, price, artist));
        System.out.println("Album actualizat");
    }

    private void addTrackToAlbum() {
        System.out.print("ID album: "); int albumId = scanner.nextInt();
        System.out.print("ID melodie: "); int musicId = scanner.nextInt();
        Music track = musicService.getMusic(musicId);
        if (track != null) {
            albumService.addTrackToAlbum(albumId, track);
            System.out.println("Melodie adaugata la album");
        } else {
            System.out.println("Melodie inexistenta");
        }
    }

    private void clearAlbums() {
        albumService.getAllAlbums().clear();
        System.out.println("Toate albumele au fost sterse.");
    }
}
