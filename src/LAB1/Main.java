package LAB1;

public class Main {

    public static void main(String[] args) {
        int num1 = 5;
        int num2 = 100;
        CompareNumbers comp = new CompareNumbers();
        System.out.print("Число "+comp.compare(num1, num2)+" больше по модулю");
    }
}
