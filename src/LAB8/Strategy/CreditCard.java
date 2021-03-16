package LAB8.Strategy;

public class CreditCard implements PurchaseStrategy{
    @Override
    public void printMethod() {
        System.out.println("You choose purchase by credit card.");
    }
}
