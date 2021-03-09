package LAB6.AbstractFactory;

public class BoysFactory implements PersonFactory{
    @Override
    public Clothes createClothes() {
        return new AlexClothes();
    }

    @Override
    public Person createPerson() {
        return new Alex();
    }
}
