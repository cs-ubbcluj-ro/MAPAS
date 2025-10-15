package seminar.group322.seminar2.domain;

public class Person {
    // O variabila final este constanta dupa prima atribuire
    private final int id;
    private final String name;

    public Person(int id, String name) {
        /*
        || -> se scurtcircuiteaza evaluarea expresiei (eng. short-circuit)
        | -> nu se scurtcircuiteaza (se ruleaza tot, chiar daca se stie rezultatul)
         */
        if (id < 0 || name == null || name.length() < 3) {
            throw new IllegalArgumentException("Invalid person ID or name");
        }

        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;
        return id == person.id && name.equals(person.name);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        return result;
    }
}
