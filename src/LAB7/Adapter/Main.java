package LAB7.Adapter;

public class Main {
    public static void main(String[] args) {
        AuxCable auxCable = new AuxCable("Helooo");
        LightningInput lightningInput = new LightningInput();
        AuxToLightningAdapter adapter = new AuxToLightningAdapter();
        lightningInput.connect(adapter.connectWithAdapter(auxCable));
    }
}
