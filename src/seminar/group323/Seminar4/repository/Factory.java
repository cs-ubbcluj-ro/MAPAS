package seminar.group323.Seminar4.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface Factory<T> {
    T fromTokens(String[] tokens); // linie (splitată) -> obiect
    String toLine(T entity);       // obiect -> linie  (ex. "1;Sarbatori;2.0;Various Artists")
    T fromResultSet(ResultSet rs) throws SQLException; // ResultSet -> obiect
}
