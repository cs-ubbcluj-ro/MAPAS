package seminar.group322.seminar2.repository;

import lecture.livecoding.Square;
import org.sqlite.SQLiteDataSource;
import seminar.group322.seminar2.domain.Employee;
import seminar.group322.seminar2.domain.RepositoryException;

import java.sql.*;

public class SQLEmployeeRepository extends Repository<Employee> implements AutoCloseable {
    /**
     * Cum lucram cu baza de date SQL in Java si IntelliJ?
     * <p>
     * 1. Folosim JDBC (standard intre Java si cam toti furnizorii de baze de date SQL)
     * 2. Avem nevoie de un driver JDBC pentru implementarea noastra (SQLite)
     * File -> Project Structure... -> Libraries -> + (from Maven)
     * 3. In Settings... -> Plugins, avem Database Tools and SQL e instalat
     * <p>
     * putem incepe sa scriem cod care foloseste SQL :)
     *
     */

    // Avem nevoie de un string de conectare la baza de date
    //
    private static final String JDBC_URL =
            "jdbc:sqlite:src/seminar/group322/employees.db";

    // Avem nevoie de o conexiune la baza de date
    // Asta o obtinem folosind JDBC
    private Connection conn = null;

    public SQLEmployeeRepository() {
        // obtinem conexiunea la baza de date
        openConnection();
        // cream tabelele din baza de date (daca ele nu exista deja)
        // (optional)
        createSchema();
        // de incarcat datele din baza de date
        loadData();
    }

    private void loadData() {
        try (PreparedStatement statement = conn.prepareStatement("SELECT * from employee");
             ResultSet rs = statement.executeQuery();) {
            while (rs.next()) {
                Employee e = new Employee(rs.getInt("id"), rs.getString("name"),
                        rs.getInt("salary"));
                super.add(e);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } catch (RepositoryException e) {
            throw new RuntimeException(e);
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
                stmt.executeUpdate("CREATE TABLE IF NOT EXISTS employee(id int, name varchar(100), salary int);");
            }
        } catch (SQLException e) {
            System.err.println("[ERROR] createSchema : " + e.getMessage());
        }
    }

    @Override
    public void add(Employee p) throws RepositoryException {
        super.add(p);

        //adaugam in baza de date
        try (PreparedStatement statement = conn.prepareStatement("INSERT INTO employee VALUES (?, ?, ?)")) {
            statement.setInt(1, p.getId());
            statement.setString(2, p.getName());
            statement.setInt(3, p.getSalary());
            statement.executeUpdate();
        } catch (SQLException e) {
//            throw new lecture.livecoding.RepositoryException(e);
        }

    }

    @Override
    public void close() throws Exception {
        if (conn != null) {
            conn.close();
        }
    }
}
