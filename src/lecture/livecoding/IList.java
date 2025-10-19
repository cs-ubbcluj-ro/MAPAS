package lecture.livecoding;

public interface IList<T> {
    /*
    Interfata nu are constructor deoarece nu poate fi instantiata
    Toate metodele sunt publice
     */
    void add(T elem);

    T get(int index);

    int size();
}
