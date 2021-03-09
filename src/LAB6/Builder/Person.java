package LAB6.Builder;

public class Person {

    private String gender;
    private int age;
    private String name;

    @Override
    public String toString() {
        return "Person{" +
                "gender='" + gender + '\'' +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    static class Builder {
        private Person person;

        public Builder() {
            person = new Person();
        }

        public Builder buildWithGender(String gender) {
            person.gender = gender;
            return this;
        }

        public Builder buildWithGenderAndAge(String gender, int age) {
            person.gender = gender;
            person.age = age;
            return this;
        }

        public Builder buildWithAll(String gender, int age, String name) {
            person.gender = gender;
            person.age = age;
            person.name = name;
            return this;
        }

        public Person build() {
            return person;
        }
    }
}
