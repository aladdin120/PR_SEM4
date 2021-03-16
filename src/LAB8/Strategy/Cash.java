package LAB8.Strategy;

public class Cash implements PurchaseStrategy{
    @Override
    public void printMethod() {
        System.out.println("You choose purchase by cash.");
    }
}
