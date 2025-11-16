package seminar.group323.Seminar4.repository;

import seminar.group323.Seminar4.domain.Entity;
import seminar.group323.Seminar4.exceptions.RepositoryException;
import seminar.group323.Seminar4.repository.InMemoryRepository;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;

public class BinaryFileRepository<T extends Entity> extends InMemoryRepository<T> {

    private final Path path;

    public BinaryFileRepository(Path path) {
        this.path = path;
        load();
    }

    private void load() {
        if (!Files.exists(path)) return; // fișierul va fi creat la prima salvare
        try (ObjectInputStream in = new ObjectInputStream(Files.newInputStream(path))) {
            var list = (ArrayList<T>) in.readObject();
            super.clear();
            for (T e : list) super.addElement(e);
        } catch (IOException | ClassNotFoundException e) {
            throw new RepositoryException("Eroare la încărcare binară din: " + path, e);
        }
    }

    private void persist() {
        try {
            // asigură directorul
            if (path.getParent() != null) Files.createDirectories(path.getParent());
            try (ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(
                    path, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING))) {
                out.writeObject(super.getAll()); // scriem întreaga listă
            }
        } catch (IOException e) {
            throw new RepositoryException("Eroare la salvare binară în: " + path, e);
        }
    }

    // suprascriem toate operațiile ca să persiste automat
    @Override
    public void addElement(T element) {
        super.addElement(element);
        persist();
    }

    @Override
    public void updateElement(T newElement) {
        super.updateElement(newElement);
        persist();
    }

    @Override
    public void deleteElement(Integer id) {
        super.deleteElement(id);
        persist();
    }

    @Override
    public void deleteElement(T element) {
        super.deleteElement(element);
        persist();
    }

    @Override
    public void clear() {
        super.clear();
        persist();
    }
}
