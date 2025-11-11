package lecture.livecoding;

public interface ShapeConverter<E extends Shape> {
    String toString(E shape);

    E toObject(String asString);
}
