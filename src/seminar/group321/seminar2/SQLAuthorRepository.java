package seminar.group321.seminar2;

import lecture.livecoding.RepositoryException;
import lecture.livecoding.Square;
import org.sqlite.SQLiteDataSource;

import java.sql.*;

public class SQLAuthorRepository extends Repository<Author> {
    /*
    De obicei, fiecare entitate (ex. autor, carte etc.) este salvata in propriul tabel SQL

    De ce avem nevoie ca sa lucram cu baza de date SQL in Java?
    Cerinte initiale:
        1. Un driver JDBC pentru tipul de baza de date folosit (ex. SQLite, Microsoft SQL Server)
            programul <--> JDBC <--> baza de date
        2. De activat pluginul "Database Tools and SQL" in sectiunea de Plugins

    Cand scriem codul:
        1. Este nevoie de un string de conexiune cu baza de date (de unde stie driverul JDBC la care baza de
        date sa se conecteze?) -- JDBC_URL
        2. Trebuie sa ne conectam la baza de date indicata de stirng-ul de conexiune (JDBC ar trebui sa ne
        furnizeze un obiect Java) -- Connection conn
        3. Odata ce avem obiectul conexiune, se pot trimite comenzi catre baza de date.
            -- Cream tabelele bazei de date, daca ele nu exista deja

     */

    private static final String JDBC_URL =
            "jdbc:sqlite:src/seminar/group321/authors.db";

    private Connection conn = null;

    public SQLAuthorRepository() {
        openConnection();
        createSchema();
        // citim autorii din baza de date
        loadData();
    }

    private void loadData() {
        try (PreparedStatement statement = conn.prepareStatement("SELECT * from autori");
             ResultSet rs = statement.executeQuery();) {
            while (rs.next()) {
                Author author = new Author(rs.getInt("id"), rs.getString("nume"));
//                super.add(author);
                data.add(author);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void add(Author author) throws BookstoreException {
        // apelam metoda din clasa de baza
        super.add(author);
        // salvam in baza de date -- exemplu de PreparedStatement
        try (PreparedStatement statement = conn.prepareStatement("INSERT INTO autori VALUES (?, ?)")) {
            statement.setInt(1, author.getId());
            statement.setString(2, author.getName());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void openConnection() {
        try {
            // Clasa de mai jos face parte din driver-ul JDBC asociat bazei de date
            SQLiteDataSource ds = new SQLiteDataSource();
            ds.setUrl(JDBC_URL);
            if (conn == null || conn.isClosed())
                // obitnem obiectul conexiune
                conn = ds.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException("Eroare la conectarea cu baza de date", e);
        }
    }

    private void createSchema() {
        try {
            try (final Statement stmt = conn.createStatement()) {
                stmt.executeUpdate("CREATE TABLE IF NOT EXISTS autori(id int, nume varchar(100));");
            }
        } catch (SQLException e) {
            System.err.println("[ERROR] createSchema : " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public void close() throws Exception {
        // ne asiguram ca am inchis conexiunea cu baza de date
        if (conn != null) {
            conn.close();
        }
    }
}
