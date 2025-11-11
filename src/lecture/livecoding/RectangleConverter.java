package lecture.livecoding;

public class RectangleConverter implements ShapeConverter<Rectangle> {
    @Override
    public String toString(Rectangle shape) {
        return shape.getId() + "," + shape.getName() + "," + shape.getWidth() + "," + shape.getHeight();
    }

    @Override
    public Rectangle toObject(String asString) {
        String[] tokens = asString.split(",");
        int id = Integer.parseInt(tokens[0]);
        String name = tokens[1];
        int width = Integer.parseInt(tokens[2]);
        int height = Integer.parseInt(tokens[3]);
        return new Rectangle(id, name, width, height);
    }
}
