package lecture.livecoding;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class MemoryRepository<E extends Shape> extends AbstractRepository<E> {
    @Override
    public void store(E element) throws RepositoryException {
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
        List<E> aux = new ArrayList<>();
        for (int i = 0; i <= data.size(); i++) {
            aux.add(data.get(i));
        }

        return aux;
    }


}
