package seminar.group322.seminar2.repository;

import seminar.group322.seminar2.domain.Person;

import java.util.ArrayList;

public class Repository {
    private ArrayList<Person> dataList = new ArrayList<>();

    public void addPerson(Person p) {
        if (p == null) {
            // Eroarea asta nu ar trebui sa apara in timpul executiei programului
            throw new NullPointerException();
        }

        if (find(p.getId()) != null) {
            throw new IllegalArgumentException("Person already exists!");
        }

        this.dataList.add(p);
    }


    public Person find(int id) {
        for (Person p : dataList) {
            if (id == p.getId()) {
                return p;
            }
        }
        return null; // valoarea implicita pentru un Person
    }

    @Override
    public String toString() {
        return "Repository{" +
                "dataList=" + dataList +
                '}';
    }
}
