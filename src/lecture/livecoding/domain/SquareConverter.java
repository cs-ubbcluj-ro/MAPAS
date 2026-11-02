package lecture.livecoding.domain;

import lecture.livecoding.util.ShapeConverter;

public class SquareConverter implements ShapeConverter<Square> {

    @Override
    public Square stringToObject(String source) {
        var tokens = source.split(",");
        var squareId = Integer.parseInt(tokens[0]);
        var squareName = tokens[1];
        var squareWidth = Integer.parseInt(tokens[2]);
        return new Square(squareId, squareName, squareWidth);
    }

    @Override
    public String objectToString(Square object) {
        return object.getId() + "," + object.getName() + "," + object.getWidth();
    }
}
