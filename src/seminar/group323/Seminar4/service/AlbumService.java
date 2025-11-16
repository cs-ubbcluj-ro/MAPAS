package seminar.group323.Seminar4.service;

import seminar.group323.Seminar4.domain.Album;
import seminar.group323.Seminar4.domain.Music;
import seminar.group323.Seminar4.repository.Repository;
import seminar.group323.Seminar4.exceptions.ObjectNotFoundException;
import seminar.group323.Seminar4.exceptions.ValidationException;

import java.util.ArrayList;

public class AlbumService {
    private final Repository<Album> repo;

    public AlbumService(Repository<Album> repo) {
        this.repo = repo;
    }

    public void addAlbum(Album album) {
        if (album.getName() == null || album.getName().isBlank()) {
            throw new ValidationException("Titlul albumului nu poate fi gol.");
            // Ar trebui aruncate excepții pentru toate operațiile
        }
        repo.addElement(album);
    }

    public Album getAlbum(int id) {
        Album a = repo.getById(id);
        if (a == null) throw new ObjectNotFoundException(id);
        return a;
    }

    public void deleteAlbum(int id) {
        repo.deleteElement(id);
    }

    public void updateAlbum(Album album) {
        repo.updateElement(album);
    }

    public ArrayList<Album> getAllAlbums() {
        return repo.getAll();
    }

    public void addTrackToAlbum(int albumId, Music track) {
        Album album = getAlbum(albumId);
        if (track.getName() == null || track.getName().isBlank()) {
            throw new ValidationException("Numele piesei nu poate fi gol.");
        }
        album.addTrack(track);
        repo.updateElement(album);     // foarte important pentru repo-uri pe fișier/binar
    }

    public int countAlbums() {
        return repo.size();
    }
}
