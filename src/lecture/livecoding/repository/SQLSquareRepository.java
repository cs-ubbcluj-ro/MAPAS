package lecture.livecoding.repository;


import lecture.livecoding.domain.Square;
import org.sqlite.SQLiteDataSource;

import java.sql.*;
import java.util.logging.Level;

public class SQLSquareRepository extends MemoryRepository<Square> implements AutoCloseable {

    private static final String JDBC_URL =
            "jdbc:sqlite:src/lecture/livecoding/squares.db";

    private Connection conn = null;

    public SQLSquareRepository() throws RepositoryException {
        // Initializam conexiunea in constructor
        openConnection();
        createSchema();
        loadSquares();
    }

    private void openConnection() throws RepositoryException {
        try {
            SQLiteDataSource ds = new SQLiteDataSource();
            ds.setUrl(JDBC_URL);
            if (conn == null || conn.isClosed())
                conn = ds.getConnection();
        } catch (SQLException e) {
            throw new RepositoryException("Eroare la deschiderea conexiunii SQL", e);
        }
    }

    private void createSchema() throws RepositoryException {
        try {
            try (final Statement stmt = conn.createStatement()) {
                stmt.executeUpdate("CREATE TABLE IF NOT EXISTS squares(id int, name varchar(100), side int);");
            }
        } catch (SQLException e) {
            throw new RepositoryException("Eroare la deschiderea conexiunii SQL", e);
        }
    }

    @Override
    public void store(Square element) throws RepositoryException {
        super.store(element);

        // Salvam in baza de date
        try {
            try (PreparedStatement statement = conn.prepareStatement("INSERT INTO squares VALUES (?, ?, ?)")) {
                statement.setInt(1, element.getId());
                statement.setString(2, element.getName());
                statement.setInt(3, element.getWidth());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RepositoryException("Eroare la salvarea datelor", e);
        }
    }

    private void loadSquares() throws RepositoryException {
        try {
            try (var statement = conn.prepareStatement("SELECT * from squares"); ResultSet rs = statement.executeQuery();) {
                while (rs.next()) {
                    Square b = new Square(rs.getInt("id"), rs.getString("name"), rs.getInt("side"));
                    data.add(b);
                }
            }
        } catch (SQLException e) {
            throw new RepositoryException("Eroare la salvarea datelor", e);
        }
    }


    public void close() throws RepositoryException {
        System.out.println("Close apelat!");
        try {
            if (conn != null)
                conn.close();
        } catch (SQLException e) {
            throw new RepositoryException("Eroare la salvarea datelor", e);
        }
    }
}
