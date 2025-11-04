package seminar.group323.Seminar3.repository;

public interface Factory<T> {
    T fromTokens(String[] tokens); // linie (splitată) -> obiect
    String toLine(T entity);       // obiect -> linie  (ex. "1;Sarbatori;2.0;Various Artists")
}
