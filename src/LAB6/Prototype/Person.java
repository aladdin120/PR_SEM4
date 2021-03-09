package LAB6.Prototype;

public class Person implements Copyable {

    private int age;
    private String name;


    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNameAndAge(String name, int age) {
        this.age = age;
        this.name = name;
    }

    @Override
    public Person copy() {
        Person newPerson = new Person();
        newPerson.name = this.name;
        newPerson.age = this.age;
        return newPerson;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
