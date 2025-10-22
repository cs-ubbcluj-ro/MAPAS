package seminar.group321.seminar2;

public class Author extends IdObject {

    private String name;

    public Author(int id, String name) {
        // TODO exceptie in cazul unui nume invalid
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", id=" + id +
                "} " + super.toString();
    }
}
