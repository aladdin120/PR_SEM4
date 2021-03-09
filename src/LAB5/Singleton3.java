package LAB5;

public class Singleton3 {

    private static final Singleton3 instance = new Singleton3();

    private Singleton3() {}

    public static Singleton3 getInstance() {
        return instance;
    }
}
