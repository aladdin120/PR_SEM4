package LAB6.AbstractFactory;

public class Main {

    public static void main(String[] args) {
        PersonFactory boysFactory = new BoysFactory();
        PersonFactory girlsFactory = new GirlsFactory();

        Factory factory = new Factory(boysFactory);
        factory.print();

        factory = new Factory(girlsFactory);
        factory.print();
    }
}
