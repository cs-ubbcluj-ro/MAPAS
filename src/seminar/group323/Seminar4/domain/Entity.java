package seminar.group323.Seminar4.domain;

import java.io.Serializable;

public abstract class Entity implements Serializable {
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
                "id=" + getId() +
                '}';
    }
}
