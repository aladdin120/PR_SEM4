package LAB6.Builder;

public class Main {

    public static void main(String[] args) {
        Person person1 = new Person.Builder()
                .buildWithGender("MALE")
                .build();
        System.out.println(person1.toString());

        Person person2 = new Person.Builder()
                .buildWithGenderAndAge("MALE", 30)
                .build();
        System.out.println(person2.toString());

        Person person3 = new Person.Builder()
                .buildWithAll("FEMALE", 20, "Kate")
                .build();
        System.out.println(person3.toString());
    }
}
