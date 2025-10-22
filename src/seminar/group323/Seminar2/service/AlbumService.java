package seminar.group323.Seminar2.service;

import seminar.group323.Seminar2.domain.Album;
import seminar.group323.Seminar2.domain.Music;
import seminar.group323.Seminar2.repository.Repository;

import java.util.ArrayList;

public class AlbumService {
    private final Repository<Album> repo;

    public AlbumService(Repository<Album> repo) {
        this.repo = repo;
    }

    public void addAlbum(Album album) {
        repo.addElement(album);
    }

    public Album getAlbum(int id) {
        return repo.getById(id);
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
        Album album = repo.getById(albumId);
        if (album != null) {
            album.addTrack(track);
        } else {
            System.out.println("Album cu ID " + albumId + " nu exista!");
        }
    }

    public int countAlbums() {
        return repo.size();
    }

    @Override
    public String toString() {
        return "AlbumService{" +
                "repo=" + repo +
                '}';
    }
}
