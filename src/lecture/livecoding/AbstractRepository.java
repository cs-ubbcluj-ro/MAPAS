package lecture.livecoding;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractRepository<E extends Shape> implements IRepository<E> {

    protected IList<E> data = new SimpleLinkedList<>();

    @Override
    public Iterator<E> iterator() {
        List<E> aux = new ArrayList<>();
        for (int i = 0; i <= data.size(); i++) {
            aux.add(data.get(i));
        }
        return aux.iterator();
    }
}
