package seminar.group323.Seminar3.repository;

import seminar.group323.Seminar3.domain.Entity;

import java.util.ArrayList;

public interface Repository<T extends Entity> {
    void addElement(T element);

    boolean isIn(int id);

    void deleteElement(Integer id);

    void deleteElement(T element);

    ArrayList<T> getElements();

    T getById(int id);

    void updateElement(T newElement);

    int size();

    ArrayList<T> getAll();

    void clear();

    ArrayList<T> findByName(String name);

    boolean exists(int id);
}
