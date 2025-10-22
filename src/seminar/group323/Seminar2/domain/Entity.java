package seminar.group323.Seminar2.domain;

public abstract class Entity {
    private int id;

    public Entity(int id) {
        this.id=id;
    }

    public int  getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "id=" + id +
                '}';
    }
}
