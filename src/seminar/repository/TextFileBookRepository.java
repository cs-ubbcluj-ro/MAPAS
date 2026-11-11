package seminar.repository;

import seminar.domain.Book;
import seminar.domain.LibraryObject;

import java.io.*;

public class TextFileBookRepository extends LibraryObjectRepository {

    private final String fileName;


    public TextFileBookRepository(String fileName) {
        this.fileName = fileName;
        loadBooks();
    }

    @Override
    public void store(LibraryObject book) throws RepositoryException {
        if (!(book instanceof Book)) {
            throw new IllegalArgumentException("Not a book");
        }

        super.store(book);
        saveBooks();
    }


    private void saveBooks() throws RepositoryException {
        try (var bw = new BufferedWriter(new FileWriter(this.fileName))) {
            for (var lo : data) {
                Book book = (Book) lo;
                bw.write(book.getId() + "," + book.getTitle() + "\r\n");
            }
        } catch (IOException e) {
            throw new RepositoryException("Eroare la salvarea cartilor", e);
        }

    }

    private void loadBooks() {
        try (var br = new BufferedReader(new FileReader(this.fileName))) {

            String line = br.readLine();
            while (line != null) {
                var tokens = line.split(",");
                this.data.add(new Book(Integer.parseInt(tokens[0]), tokens[1]));

                line = br.readLine();
            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}
