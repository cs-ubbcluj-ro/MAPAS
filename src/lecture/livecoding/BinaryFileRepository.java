package lecture.livecoding;

import java.io.*;
import java.util.ArrayList;

public class BinaryFileRepository<E extends Shape> extends AbstractFileRepository<E> {
    public BinaryFileRepository(String fileName) {
        super(fileName);
    }

    @Override
    protected void readFile() throws RepositoryException {

        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(fileName));
            this.data = (ArrayList) ois.readObject();
            ois.close();
        } catch (FileNotFoundException e) {
            // If we can't find the input file, we initialize one.
            // Do nothing
        } catch (IOException e) {
            throw new RepositoryException(e);
        } catch (ClassNotFoundException e) {
            throw new RepositoryException(e);
        }
    }

    @Override
    protected void writeFile() throws RepositoryException {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(fileName));
            oos.writeObject(this.data);
            oos.close();
        } catch (IOException e) {
            throw new RepositoryException(e);
        }
    }
}
