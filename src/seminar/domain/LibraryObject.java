package seminar.domain;

public abstract class LibraryObject {
    private final int id;

    public LibraryObject(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
