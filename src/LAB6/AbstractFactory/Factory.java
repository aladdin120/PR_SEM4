package LAB6.AbstractFactory;

public class Factory {
    private Clothes clothes;
    private Person person;

    public Factory(PersonFactory factory) {
        clothes = factory.createClothes();
        person = factory.createPerson();
    }

    public void print() {
        person.getName();
        clothes.getClothesName();
    }
}
