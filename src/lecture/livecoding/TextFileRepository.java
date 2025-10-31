package lecture.livecoding;

public class TextFileRepository<E extends Shape> extends AbstractFileRepository<E> {

    public TextFileRepository(String fileName) {
        super(fileName);
    }

    @Override
    protected void readFile() throws RepositoryException {
        // TODO to implement
    }

    @Override
    protected void writeFile() throws RepositoryException {
        // TODO to implement
    }
}
