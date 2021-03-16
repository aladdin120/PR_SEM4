package LAB8.State;

public class LockedState extends State{
    LockedState(Door door) {
        super(door);
    }

    @Override
    public void turnHandle() {
        System.out.println("The door is locked, turn the lock!");
    }
}
