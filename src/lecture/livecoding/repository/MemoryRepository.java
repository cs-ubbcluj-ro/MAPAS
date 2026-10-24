package lecture.livecoding.repository;

import lecture.livecoding.domain.Shape;

public class MemoryRepository<E extends Shape> extends AbstractRepository<E> {
    @Override
    public void store(E element) throws RepositoryException {
        if (findById(element.getId()) != null) {
            throw new RepositoryException("Duplicate element id=" + element.getId());
        }
        this.data.add(element);
    }

    @Override
    public void delete(int elementId) throws RepositoryException {
        E elemToDelete = findById(elementId);

        if (elemToDelete == null) {
            throw new RepositoryException("Element cannot be found, id=" + elementId);
        }
        this.data.remove(elemToDelete);
    }

    @Override
    public E findById(int elementId) {
        for (E elem : this.data) {
            if (elementId == elem.getId()) {
                return elem;
            }
        }
        return null;
    }
}
