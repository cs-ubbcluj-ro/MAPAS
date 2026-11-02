package lecture.livecoding.util;

import lecture.livecoding.domain.Shape;

public interface ShapeConverter<E extends Shape> {

    E stringToObject(String source);

    String objectToString(E object);
}
