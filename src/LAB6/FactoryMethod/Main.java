package LAB6.FactoryMethod;

public class Main {
    public static void main(String[] args) {
        PersonFactory factory = new PersonFactory();

        Person person = factory.createPerson("Alex");
        Person person1 = factory.createPerson("Bill");
        person.getName();
        person1.getName();
    }
}
