package lecture.livecoding;

import java.io.FileNotFoundException;

public abstract class AbstractFileRepository<E extends Shape> extends MemoryRepository<E> {

    protected String fileName;

    protected ShapeConverter<E> converter;

    public AbstractFileRepository(String fileName) {
        super();
        this.fileName = fileName;
//        try {
//            readFile();
//        } catch (RepositoryException e) {
//            // We rethrow this
//            throw new RuntimeException(e);
//        }
    }

    @Override
    public void store(E element) throws RepositoryException {
        super.store(element);
        writeFile();
    }

    @Override
    public boolean delete(E element) {
        boolean result = super.delete(element);
        if (result) {
            // The element was deleted, so we update the file
            try {
                writeFile();
            } catch (RepositoryException e) {
                throw new RuntimeException(e);
            }
        }
        return result;
    }

    // We throw RepositoryException because we can't know the exact exceptions types thrown by all the
    // subclasses (text file / binary file / SQL / noSQL !!??)
    protected abstract void readFile() throws RepositoryException;

    protected abstract void writeFile() throws RepositoryException;

}
