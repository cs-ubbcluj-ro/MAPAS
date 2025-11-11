package lecture.livecoding;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class MemoryRepository<E extends Shape> extends AbstractRepository<E> {
    @Override
    public void store(E element) throws RepositoryException {
        // FIXME De adaugat verificarea pentru id-uri duplicate
        this.data.add(element);
    }

    @Override
    public boolean delete(E element) {
        return false;
    }

    @Override
    public E find(int elementId) {
        return null;
    }

    @Override
    public Collection<E> getAll() {
        return new ArrayList<>(data);
    }
}
