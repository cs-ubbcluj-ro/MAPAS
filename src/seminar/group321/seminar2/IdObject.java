package seminar.group321.seminar2;

import java.io.Serializable;

public class IdObject implements Serializable {
    // fiecare entitate din program trebuie sa aiba un id unic
    protected int id;

    public IdObject(int id) {
        if (id < 0) {
            throw new IllegalArgumentException("Id < 0!");
        }
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "IdObject{" +
                "id=" + id +
                '}';
    }
}
