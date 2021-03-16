package LAB7.Adapter;

public class AuxToLightningAdapter extends LightningInput {

    public LightningCable connectWithAdapter(AuxCable auxCable) {
        System.out.println("Connect Lightning adapter to Aux cable");
        return new LightningCable(auxCable.getData());
    }

    @Override
    public void connect(LightningCable lightningCable) {
        System.out.println("Connect Lightning to phone");
    }
}
