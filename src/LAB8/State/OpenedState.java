package LAB8.State;

public class OpenedState extends State{
    OpenedState(Door door) {
        super(door);
    }

    @Override
    public void turnHandle() {
        System.out.println("The door is opened!");
    }
}
