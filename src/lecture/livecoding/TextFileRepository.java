package lecture.livecoding;

import java.io.*;

public class TextFileRepository<E extends Shape> extends AbstractFileRepository<E> {


    public TextFileRepository(String fileName, ShapeConverter<E> converter) {
        super(fileName);
        this.converter = converter;
        try {
            readFile();
        } catch (RepositoryException e) {
            // We rethrow this
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void readFile() throws RepositoryException {
        // try-with-resources - apeleaza close pe resursele din try( ... ),
        // indiferent de ce exceptii sunt aruncate.

        try (var br = new BufferedReader(new FileReader(fileName))) {
            String line = br.readLine();
            while (line != null) {
                this.data.add(converter.toObject(line));
                line = br.readLine();
            }
        } catch (FileNotFoundException e) {
            // in cazul in care fisierul nu exista, inseamna ca e un repo nou-nout
            System.out.println("Repository nou");
        } catch (IOException e) {
            // re-aruncam exceptia, mentionand cauza actuala a ei
            throw new RepositoryException(e);
        }

       /*
        var br = new BufferedReader(new FileReader(fileName));
        String line = br.readLine();
        while (line != null) {
            this.data.add(converter.toObject(line));
        }
        br.close();
        */
    }

    @Override
    protected void writeFile() throws RepositoryException {
        try (var bw = new BufferedWriter(new FileWriter(fileName))) {
            for (var shape : this.data) {
                bw.write(converter.toString(shape) + "\r\n");
            }
        } catch (IOException e) {
            // re-aruncam exceptia, mentionand cauza actuala a ei
            throw new RepositoryException(e);
        }
    }
}
