package LAB5;

public class Main {

    static void Singleton1() {
        System.out.println("First realization");
        Singleton1 singleton1 = Singleton1.getInstance();
        Singleton1 singleton11 = Singleton1.getInstance();
        System.out.println(singleton1);
        System.out.println(singleton11);
    }

    static void Singleton2() {
        System.out.println("Second realization");
        Singleton2 singleton2 = Singleton2.getInstance();
        Singleton2 singleton22 = Singleton2.getInstance();
        System.out.println(singleton2);
        System.out.println(singleton22);
    }

    static void Singleton3() {
        System.out.println("Third realization");
        Singleton3 singleton3 = Singleton3.getInstance();
        Singleton3 singleton33 = Singleton3.getInstance();
        System.out.println(singleton3);
        System.out.println(singleton3);
    }

    public static void main(String[] args) {
        Main.Singleton1();
        Main.Singleton2();
        Main.Singleton3();
    }
}
