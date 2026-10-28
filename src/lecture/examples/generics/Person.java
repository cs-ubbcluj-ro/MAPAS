package lecture.examples.generics;

class Person implements MyComparable<Person> {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Person element) {
        return this.name.compareTo(element.name);
    }
}
