package seminar.group322.seminar2.repository;

import seminar.group322.seminar2.domain.Person;
import seminar.group322.seminar2.domain.RepositoryException;

import java.io.*;
import java.util.ArrayList;

public class BinaryFileRepository<E extends Person> extends Repository<E> {

    protected String fileName;

    public BinaryFileRepository(String fileName) {
        this.fileName = fileName;
        try {
            loadFile();
        } catch (IOException e) {
            // Fisierul nu a fost gasit => incepem repo de la 0
        } catch (ClassNotFoundException e) {
            // Asta e o problema :(
            throw new RuntimeException(e);
        }
    }

    @Override
    public void add(E p) throws RepositoryException {
        super.add(p);
        // saveFile nu se apeleaza daca super.add() a aruncat o exceptie
        try {
            saveFile();
        } catch (IOException ioex) {
            throw new RepositoryException(ioex);
        }
    }

    private void saveFile() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));
        oos.writeObject(dataList);
        oos.close();
    }

    private void loadFile() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("employees.bin"));
        this.dataList = (ArrayList) ois.readObject();
        ois.close();
    }

}
