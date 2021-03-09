package LAB6.FactoryMethod;

public class PersonFactory {

    public Person createPerson(String name) {
        switch (name) {
            case "Alex":
                return new Alex();
            case "Bill":
                return new Bill();
            default:
                return null;
        }
    }
}
