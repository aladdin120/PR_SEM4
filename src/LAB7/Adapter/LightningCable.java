package LAB7.Adapter;

public class LightningCable {
    private String data;

    public LightningCable(String data) {
        this.data = data;
    }

    public void insertCable() {
        System.out.println("Insert Lightning Cable");
        System.out.println("Transfer data: " + data);
    }
}
