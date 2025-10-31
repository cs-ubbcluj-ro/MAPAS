package seminar.group322.seminar2.repository;

import seminar.group322.seminar2.domain.Person;
import seminar.group322.seminar2.domain.RepositoryException;

import java.util.ArrayList;
import java.util.Iterator;

public class Repository<E extends Person> implements Iterable<E> {
    protected ArrayList<E> dataList = new ArrayList<>();

    public void add(E p) throws RepositoryException {
        if (p == null) {
            // Eroarea asta nu ar trebui sa apara in timpul executiei programului
            throw new NullPointerException();
        }

        if (find(p.getId()) != null) {
            throw new RepositoryException("Person already exists!");
        }

        this.dataList.add(p);
    }


    public E find(int id) {
        for (E p : dataList) {
            if (id == p.getId()) {
                return p;
            }
        }
        return null; // valoarea implicita pentru un Person
    }

    @Override
    public String toString() {
        return "Repository{" +
                "dataList=" + dataList +
                '}';
    }

    @Override
    public Iterator<E> iterator() {
        // FIXME Ar trebui returnat un iterator catre o copie a listei
        return dataList.iterator();
    }
}
