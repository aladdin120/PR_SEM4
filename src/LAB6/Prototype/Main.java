package LAB6.Prototype;

public class Main {
    public static void main(String[] args) {
        Person person = new Person();
        person.setAge(18);
        System.out.println(person + " - person");

        Person newPerson = person.copy();
        System.out.println(newPerson + " - newPerson, prototype of person");
        newPerson.setName("Alex");
        System.out.println(newPerson + " - changes name of newPerson");

        System.out.println(person + " - changes in newPerson not affected on person");
    }
}
