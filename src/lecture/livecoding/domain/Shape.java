package lecture.livecoding.domain;

public class Shape {


    private int id;

    private String name;

    public Shape(int id) {
        this.id = id;
    }

    public Shape(int id, String name) {
        // Putem apela un constructor din alt constructor
        // this() trebuie sa fie prima instructiune
        this(id);
        this.name = name;
    }

    public int getId() {
        return id;
    }
}
