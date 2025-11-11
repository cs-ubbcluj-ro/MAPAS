package seminar.group321.seminar2;

import java.io.*;

public class AuthorTextFileRepository extends Repository<Author> {
    /*
    Datele se incarca la initializare (constructor)
    Datele se salveaza la fiecare modificare (add/delete etc.)
     */

    private String fileName;

    public AuthorTextFileRepository(String fileName) {
        this.fileName = fileName;
        try {
            loadFile();
        } catch (FileNotFoundException e) {
            System.out.println("Pornim un repository nou");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void add(Author element) throws BookstoreException {
        super.add(element);
        try {
            saveFile();
        } catch (IOException ex) {
            throw new BookstoreException(ex, "Eroarea la salvare fisierului");
        }
    }

    private void loadFile() throws IOException {
        // var in Java <=> auto in C++
        try (var fr = new FileReader(fileName); var br = new BufferedReader(fr)) {
            var line = br.readLine();
            while (line != null) {
                var tokens = line.split(",");
                this.data.add(new Author(Integer.parseInt(tokens[0]), tokens[1]));
                line = br.readLine();
            }
        }
    }

    private void saveFile() throws IOException {
        // 1.
//        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
//        for (Author auth : this.data) {
//            bw.write(auth.getId() + "|" + auth.getName() + "\r\n");
//        }
//        bw.close();

        // 2. try-with-resources
        // resursele declarate in blocul try(...) sunt inchise (se apeleaza close() )
        // indiferent de modul in care se iese din blocul { ... }
        // Resursele (BufferedWriter, FileWriter) trebuie sa implementeze una din
        // interfetele Closeable sau Autocloseable
        try (FileWriter fw = new FileWriter(fileName); BufferedWriter bw = new BufferedWriter(fw)) {
            for (Author auth : this.data) {
                bw.write(auth.getId() + "," + auth.getName() + "\r\n");
            }
        }
    }
}
