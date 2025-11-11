package seminar.group321.seminar2;

import java.io.*;

public class BinaryFileRepository<E> extends Repository<E> {
    private String fileName;

    public BinaryFileRepository(String fileName) {
        this.fileName = fileName;
        try {
            loadFile();
        } catch (FileNotFoundException e) {
            System.out.println("Initializam un repository nou");
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void add(E element) throws BookstoreException {
        super.add(element);
        try {
            saveFile();
        } catch (IOException e) {
            throw new BookstoreException(e, "Eroare la savarea fisierului");
        }
    }

    private void loadFile() throws IOException, ClassNotFoundException {
        try (var is = new FileInputStream(fileName); var ois = new ObjectInputStream(is)) {
            this.data = (java.util.Set<E>) ois.readObject();
        }
    }

    private void saveFile() throws IOException {
        try (var os = new FileOutputStream(fileName); var oos = new ObjectOutputStream(os)) {
            oos.writeObject(this.data);
        }
    }
}
