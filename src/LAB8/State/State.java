package LAB8.State;

public abstract class State {

    Door door;

    State(Door door) {
        this.door = door;
    }

    public abstract void turnHandle();
}
