package seminar.group323.Seminar4.service;

import seminar.group323.Seminar4.domain.Music;
import seminar.group323.Seminar4.repository.Repository;

import java.util.ArrayList;

public class MusicService {
    private final Repository<Music> repo;

    public MusicService(Repository<Music> repo) {
        this.repo = repo;
    }

    public void addMusic(Music m) {
        repo.addElement(m);
    }

    public Music getMusic(int id) {
        return repo.getById(id);
    }

    public void deleteMusic(int id) {
        repo.deleteElement(id);
    }

    public void updateMusic(Music m) {
        repo.updateElement(m);
    }

    public ArrayList<Music> getAllMusic() {
        return repo.getAll();
    }

    public int countMusic() {
        return repo.size();
    }

    @Override
    public String toString() {
        return "MusicService{" +
                "repo=" + repo +
                '}';
    }
}
