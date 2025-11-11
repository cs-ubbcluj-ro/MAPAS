package lecture.livecoding;

import org.sqlite.SQLiteDataSource;

import java.sql.*;

public class SQLSquareRepository extends MemoryRepository<Square> {

    private static final String JDBC_URL =
            "jdbc:sqlite:src/lecture/livecoding/square.db";

    private Connection conn = null;

    public SQLSquareRepository() {
        openConnection();
        createSchema();
        loadData();
    }

    private void loadData() {

        try (PreparedStatement statement = conn.prepareStatement("SELECT * from square");
             ResultSet rs = statement.executeQuery();) {
            while (rs.next()) {
                Square square = new Square(rs.getInt("id"), rs.getString("name"),
                        rs.getInt("width"));
                data.add(square);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    private void openConnection() {
        try {
            SQLiteDataSource ds = new SQLiteDataSource();
            ds.setUrl(JDBC_URL);
            if (conn == null || conn.isClosed())
                conn = ds.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException("Eroare la conectarea cu baza de date", e);
        }
    }

    private void createSchema() {
        try {
            try (final Statement stmt = conn.createStatement()) {
                stmt.executeUpdate("CREATE TABLE IF NOT EXISTS square(id int, name varchar(100), width int);");
            }
        } catch (SQLException e) {
            System.err.println("[ERROR] createSchema : " + e.getMessage());
        }
    }

    @Override
    public void store(Square element) throws RepositoryException {
        super.store(element);
        // TODO Salvare in BD

        try (PreparedStatement statement = conn.prepareStatement("INSERT INTO square VALUES (?, ?, ?)")) {
            statement.setInt(1, element.getId());
            statement.setString(2, element.getName());
            statement.setInt(3, element.getWidth());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RepositoryException(e);
        }
    }
}
