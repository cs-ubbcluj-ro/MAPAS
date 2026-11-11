package seminar.repository;

import seminar.domain.Author;
import seminar.domain.Book;
import seminar.domain.LibraryObject;

import java.io.*;

public class AuthorTextFileRepository extends LibraryObjectRepository {

    private String fileName;
    private TextFileBookRepository bookRepo;

    public AuthorTextFileRepository(String fileName, TextFileBookRepository bookRepo) {
        this.fileName = fileName;
        this.bookRepo = bookRepo;
        loadAuthors();
    }

    @Override
    public void store(LibraryObject author) throws RepositoryException {
        if (!(author instanceof Author)) {
            throw new IllegalArgumentException("Not an author");
        }

        super.store(author);
        saveAuthors();
    }


    private void saveAuthors() throws RepositoryException {
        try (var bw = new BufferedWriter(new FileWriter(this.fileName))) {
            for (var lo : data) {
                Author author = (Author) lo;

                StringBuilder sb = new StringBuilder();
                sb.append(author.getId()).append(",").append(author.getName());
                sb.append(",");

                for (var b : author.getBooks()) {
                    sb.append(b.getId());
                    sb.append(",");
                }


                bw.write(sb.toString() + "\r\n");
            }
        } catch (IOException e) {
            throw new RepositoryException("Eroare la salvarea autorilor", e);
        }
    }

    private void loadAuthors() {

        try (var br = new BufferedReader(new FileReader(this.fileName))) {

            String line = br.readLine();
            while (line != null) {
                var tokens = line.split(",");

                var authorID = Integer.parseInt(tokens[0]);
                var authorName = tokens[1];

                var author = new Author(authorID, authorName);

                for (int i = 2; i < tokens.length; i++) {
                    var bookId = Integer.parseInt(tokens[i]);
                    author.addAuthoredBook((Book) bookRepo.find(bookId));
                }

                data.add(author);
                line = br.readLine();
            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }


}
