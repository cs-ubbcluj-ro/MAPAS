package lecture.livecoding.repository;

import lecture.livecoding.domain.Shape;

public abstract class AbstractFileRepository<E extends Shape> extends MemoryRepository<E> {

    /**
     * Clasa asta implementeaza sablonul de proiectare Template
     * <p>
     * Template - implementarea unui algoritm in care unul sau mai multi pasi sunt configurabili si implementati prin
     * subclase
     * <p>
     * https://refactoring.guru/design-patterns/template-method
     */

    protected String fileName;

    public AbstractFileRepository(String fileName) {
        this.fileName = fileName;
        try {
            readFile();
        } catch (RepositoryException e) {
            // FIXME Replace with something robust
            throw new RuntimeException(e);
        }
    }


    @Override
    public void store(E element) throws RepositoryException {
        super.store(element);
        writeFile();
    }

    @Override
    public void delete(int elementId) throws RepositoryException {
        super.delete(elementId);
        writeFile();
    }

    // 1. Nu stim in ce format vom citi/scrie fisierul
    // 2. Metodele sunt protected pentru a putea fi suprascrise in clasele derivate
    protected abstract void readFile() throws RepositoryException;

    protected abstract void writeFile() throws RepositoryException;
}
