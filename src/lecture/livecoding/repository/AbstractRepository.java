package lecture.livecoding.repository;

import lecture.livecoding.domain.Shape;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class AbstractRepository<E extends Shape> implements IRepository<E> {
    protected ArrayList<E> data = new ArrayList<>();

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public Iterator<E> iterator() {
        // Facem o copie a data, pentru ca iteratorul sa nu aiba acces la datele din repository
        ArrayList<E> iterableCopy = new ArrayList<>(data);
        return iterableCopy.iterator();
    }
}
