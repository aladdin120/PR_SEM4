package LAB6.AbstractFactory;

public class GirlsFactory implements PersonFactory {
    @Override
    public Clothes createClothes() {
        return new KateClothes();
    }

    @Override
    public Person createPerson() {
        return new Kate();
    }
}
