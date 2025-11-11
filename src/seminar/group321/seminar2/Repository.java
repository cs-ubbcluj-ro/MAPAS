package seminar.group321.seminar2;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Repository<E> implements Iterable<E> {
    protected Set<E> data = new HashSet<>();

    public void add(E element) throws BookstoreException {
        // FIXME Check for duplicate id's !!!!
        if (data.add(element) == false) {
            throw new DuplicateIDException("Duplicate book Id!");
        }
    }

    public E find(int id) {
        return null;
    }

    public Collection<E> getAll() {
        // aici avem un exemplu de "covariant return"
        // in general, "good programming practice" ne spune sa returnam cele mai generate tipuri posibile

        // FIXME Colectia this.data este un "live reference", adica multimea poate fi modificata in afara clasei!
        // TODO Solutia este ca aici sa cream o copie
        return this.data;
    }

    @Override
    public String toString() {
        return "Repository{" +
                "data=" + data +
                '}';
    }

    @Override
    public Iterator<E> iterator() {
        /*
        Cand iterez peste repository, de fapt iteram peste multimea this.data

        Ce inseamna sa iteram o colectie? -> Parcurgem fiecare element al colectiei exact o data.
         */
        return this.data.iterator();
    }
}
