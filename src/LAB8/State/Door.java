package LAB8.State;

public class Door {

    private State state;

    public Door() {
        this.state = new LockedState(this);
    }

    public void turnHandle() {
        state.turnHandle();
    }

    public void turnLock() {
        this.state = new OpenedState(this);
    }
}
