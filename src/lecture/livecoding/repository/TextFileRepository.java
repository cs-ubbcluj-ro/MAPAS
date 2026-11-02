package lecture.livecoding.repository;


import lecture.livecoding.domain.Shape;
import lecture.livecoding.util.ShapeConverter;

import java.io.*;

public class TextFileRepository<E extends Shape> extends AbstractFileRepository<E> {

    protected ShapeConverter<E> converter;

    public TextFileRepository(String fileName, ShapeConverter<E> converter) {
        super(fileName);
        this.converter = converter;

        try {
            readFile();
        } catch (RepositoryException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void readFile() throws RepositoryException {

        try {

            try (var reader = new BufferedReader((new FileReader(this.fileName)))) {
                var line = reader.readLine();
                while (line != null) {
                    this.data.add(converter.stringToObject(line));
                    line = reader.readLine();
                }

            }

        } catch (FileNotFoundException e) {
            // FIXME Replace with a logging message
            System.out.println("Pornim cu un repository nou...");
        } catch (IOException e) {
            throw new RepositoryException("Eroare la citirea fisierului - " + this.fileName, e);
        }

    }

    @Override
    protected void writeFile() throws RepositoryException {
        /*
        Avem 2 optiuni:
            (1) Clasa separata pentru fiecare entitate
                    SquareTextFileRepository, CircleTextFileRepository
            (2) Interfata de converter intre obiect <--> String
                    Cate o clasa pentru fiecare entitate
         */

        try {
            try (var writer = new BufferedWriter(new FileWriter(this.fileName))) {
                for (var shape : this.data) {
                    writer.write(converter.objectToString(shape) + "\r\n");
                }
            }
        } catch (IOException e) {
            throw new RepositoryException("Eroare la scrierea fisierului - " + this.fileName, e);
        }
    }
}
