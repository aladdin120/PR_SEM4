package LAB2;

import java.time.LocalDate;

public class Human {

    private int age, weight;
    private String firstName, lastName;
    private LocalDate birhdate;

    public Human(int age, int weight, String firstName, String lastName, LocalDate birhdate) {
        this.age = age;
        this.weight = weight;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birhdate = birhdate;
    }

    public LocalDate getBirhdate() {
        return birhdate;
    }

    public int getWeight() {
        return weight;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "Human{" +
                "age=" + age +
                ", weight=" + weight +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birhdate=" + birhdate +
                '}';
    }
}
