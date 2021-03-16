package LAB8.State;

public class Main {
    public static void main(String[] args) {
        Door door = new Door();
        door.turnHandle();
        door.turnLock();
        door.turnHandle();
    }
}
