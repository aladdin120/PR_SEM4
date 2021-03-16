package LAB7.Adapter;

public class AuxCable {
    private String data;

    public AuxCable(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void insertCable() {
        System.out.println("Insert Aux Cable");
        System.out.println("Transfer data: " + data);
    }
}
