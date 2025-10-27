package lecture.livecoding;

import java.util.Collection;

// E este Shape sau orice clasa derivata (tranzitiv) din Shape
public interface IRepository<E extends Shape> extends Iterable<E> {
    void store(E element) throws RepositoryException;

    // Returnam true daca un element a fost sters
    boolean delete(E element);

    E find(int elementId);

    // Peste tot unde e posibil, lucram cu interfetele cele mai generale care sunt
    // accesibile
    Collection<E> getAll();
}
