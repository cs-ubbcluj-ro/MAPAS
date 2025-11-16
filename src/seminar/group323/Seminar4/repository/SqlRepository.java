package seminar.group323.Seminar4.repository;

import seminar.group323.Seminar4.domain.Album;
import seminar.group323.Seminar4.domain.Entity;
import seminar.group323.Seminar4.domain.Music;
import seminar.group323.Seminar4.exceptions.ObjectNotFoundException;
import seminar.group323.Seminar4.exceptions.RepositoryException;


import java.sql.*;
import java.util.ArrayList;

public class SqlRepository<T extends Entity> implements Repository<T> {
    private final String url;
    private final Factory<T> factory;
    private final String tableName;

    public SqlRepository(String dbPath, String tableName, Factory<T> factory) {
        this.url = "jdbc:sqlite:" + dbPath;
        this.factory = factory;
        this.tableName = tableName;
        createTableIfNotExists();
    }

    private void createTableIfNotExists() {
        String sql;
        if (tableName.equalsIgnoreCase("albums")) {
            sql = """
                    CREATE TABLE IF NOT EXISTS albums(
                        id INTEGER PRIMARY KEY,
                        title TEXT NOT NULL,
                        price REAL,
                        artist TEXT
                    )
                    """;
        } else if (tableName.equalsIgnoreCase("music")) {
            sql = """
                    CREATE TABLE IF NOT EXISTS music(
                        id INTEGER PRIMARY KEY,
                        name TEXT NOT NULL,
                        price REAL,
                        genre TEXT
                    )
                    """;
        } else {
            throw new RepositoryException("Tip tabel necunoscut: " + tableName);
        }

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            throw new RepositoryException("Eroare la crearea tabelei SQLite!", e);
        }
    }

    private Connection connect() throws SQLException {
        return DriverManager.getConnection(url);
    }

    @Override
    public void addElement(T element) {
        String sql;
        if (element instanceof Album album) {
            sql = "INSERT INTO albums(id, title, price, artist) VALUES(?, ?, ?, ?)";
            try (Connection conn = connect();
                 PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setInt(1, album.getId());
                ps.setString(2, album.getName());
                ps.setDouble(3, album.getPrice());
                ps.setString(4, album.getArtist());
                ps.executeUpdate();
            } catch (SQLException e) {
                throw new RepositoryException("Eroare la inserare Album în baza de date!", e);
            }
        } else if (element instanceof Music music) {
            sql = "INSERT INTO music(id, name, price, genre) VALUES(?, ?, ?, ?)";
            try (Connection conn = connect();
                 PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setInt(1, music.getId());
                ps.setString(2, music.getName());
                ps.setDouble(3, music.getPrice());
                ps.setString(4, music.getGenre());
                ps.executeUpdate();
            } catch (SQLException e) {
                throw new RepositoryException("Eroare la inserare Music în baza de date!", e);
            }
        } else {
            throw new RepositoryException("Tip de entitate necunoscut!");
        }
    }

    @Override
    public boolean isIn(int id) {
        String sql = "SELECT id FROM " + tableName + " WHERE id = ?";
        try (Connection conn = connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            throw new RepositoryException("Eroare la verificare existență ID!", e);
        }
    }

    @Override
    public void deleteElement(Integer id) {
        String sql = "DELETE FROM " + tableName + " WHERE id = ?";
        try (Connection conn = connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            int affected = ps.executeUpdate();
            if (affected == 0) throw new ObjectNotFoundException(id);
        } catch (SQLException e) {
            throw new RepositoryException("Eroare la ștergere!", e);
        }
    }

    @Override
    public void deleteElement(T element) {
        deleteElement(element.getId());
    }

    @Override
    public ArrayList<T> getElements() {
        return getAll();
    }

    @Override
    public T getById(int id) {
        String sql = "SELECT * FROM " + tableName + " WHERE id = ?";
        try (Connection conn = connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return factory.fromResultSet(rs);
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RepositoryException("Eroare la getById!", e);
        }
    }

    @Override
    public void updateElement(T newElement) {
        String sql;
        if (newElement instanceof Album album) {
            sql = "UPDATE albums SET title = ?, price = ?, artist = ? WHERE id = ?";
            try (Connection conn = connect();
                 PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, album.getName());
                ps.setDouble(2, album.getPrice());
                ps.setString(3, album.getArtist());
                ps.setInt(4, album.getId());
                int affected = ps.executeUpdate();
                if (affected == 0) throw new ObjectNotFoundException(album.getId());
            } catch (SQLException e) {
                throw new RepositoryException("Eroare la actualizare Album!", e);
            }
        } else if (newElement instanceof Music music) {
            sql = "UPDATE music SET name = ?, price = ?, genre = ? WHERE id = ?";
            try (Connection conn = connect();
                 PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, music.getName());
                ps.setDouble(2, music.getPrice());
                ps.setString(3, music.getGenre());
                ps.setInt(4, music.getId());
                int affected = ps.executeUpdate();
                if (affected == 0) throw new ObjectNotFoundException(music.getId());
            } catch (SQLException e) {
                throw new RepositoryException("Eroare la actualizare Music!", e);
            }
        } else {
            throw new RepositoryException("Tip de entitate necunoscut!");
        }
    }

    @Override
    public int size() {
        String sql = "SELECT COUNT(*) FROM " + tableName;
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            return rs.getInt(1);
        } catch (SQLException e) {
            throw new RepositoryException("Eroare la calculul dimensiunii!", e);
        }
    }

    @Override
    public ArrayList<T> getAll() {
        ArrayList<T> list = new ArrayList<>();
        String sql = "SELECT * FROM " + tableName;
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(factory.fromResultSet(rs));
            }
        } catch (SQLException e) {
            throw new RepositoryException("Eroare la citirea tuturor elementelor!", e);
        }
        return list;
    }

    @Override
    public void clear() {
        String sql = "DELETE FROM " + tableName;
        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RepositoryException("Eroare la clear!", e);
        }
    }

    @Override
    public ArrayList<T> findByName(String name) {
        ArrayList<T> list = new ArrayList<>();
        String columnName = tableName.equalsIgnoreCase("albums") ? "title" : "name";
        String sql = "SELECT * FROM " + tableName + " WHERE lower(" + columnName + ") = lower(?)";
        try (Connection conn = connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(factory.fromResultSet(rs));
            }
        } catch (SQLException e) {
            throw new RepositoryException("Eroare la findByName!", e);
        }
        return list;
    }

    @Override
    public boolean exists(int id) {
        return isIn(id);
    }

    @Override
    public String toString() {
        return "SqlRepository{" + tableName + "@" + url + "}";
    }
}
