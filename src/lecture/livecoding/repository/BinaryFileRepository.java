package lecture.livecoding.repository;

import lecture.livecoding.domain.Shape;

import java.io.*;

public class BinaryFileRepository<E extends Shape> extends AbstractFileRepository<E> {

    public BinaryFileRepository(String fileName) {
        super(fileName);
        try {
            readFile();
        } catch (RepositoryException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void readFile() throws RepositoryException {

        try {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
                this.data = (java.util.ArrayList<E>) ois.readObject();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Initializam un repository nou");
        } catch (IOException | ClassNotFoundException e) {
            throw new RepositoryFileException("Eroare la citirea fisierului " + this.fileName, e);
        }
    }

    @Override
    protected void writeFile() throws RepositoryException {

//        ObjectOutputStream oos = null;
//        try {
//            oos = new ObjectOutputStream(new FileOutputStream(fileName));
//            oos.writeObject(this.data);
//        } catch (IOException e) {
//            throw new RepositoryFileException("Eroarea la scrierea fisierului " + this.fileName, e);
//        } finally {
//            try {
//                oos.close();
//            } catch (IOException e) {
//                throw new RepositoryFileException("Eroarea la scrierea fisierului " + this.fileName, e);
//            }
//        }

        try {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
                oos.writeObject(this.data);
            }
        } catch (IOException e) {
            throw new RepositoryFileException("Eroarea la scrierea fisierului " + this.fileName, e);
        }

    }
}
