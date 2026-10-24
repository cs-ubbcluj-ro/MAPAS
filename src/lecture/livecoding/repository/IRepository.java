package lecture.livecoding.repository;

import lecture.livecoding.domain.Shape;

public interface IRepository<E extends Shape> extends Iterable<E> {

    void store(E element) throws RepositoryException;

    void delete(int elementId) throws RepositoryException;

    E findById(int elementId);

    int size();
}
