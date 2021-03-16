package LAB8.Strategy;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PurchaseStrategy strategy;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose payment method:\n" +
                "1 - By credit card\n" +
                "2 - By cash");
        if (scanner.next().equals("1")) {
            strategy = new CreditCard();
        } else {
            strategy = new Cash();
        }
        strategy.printMethod();
    }
}
