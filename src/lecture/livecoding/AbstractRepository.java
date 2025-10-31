package lecture.livecoding;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractRepository<E extends Shape> implements IRepository<E> {

    //    protected IList<E> data = new SimpleLinkedList<>();
    protected List<E> data = new ArrayList<>();

    @Override
    public Iterator<E> iterator() {
        return data.iterator();
    }
}
