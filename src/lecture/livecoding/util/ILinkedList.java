package lecture.livecoding.util;

public interface ILinkedList<T> {

    // C++
    //  public: virtual add(Object& element) = 0 ;
    void add(T element);

    T get(int index);

    int size();

}
