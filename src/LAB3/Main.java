package LAB3;

public class Main {
    private static ListSynchronized<Integer> list = new ListSynchronized<>();
    private static SetSemaphore<Integer> set = new SetSemaphore<>();

    public static void ListSyncTask() {
        System.out.println("Main in ListSyncTask starts");
        Thread thread1 = new Thread(() -> {
            System.out.println("Thread 1 starts");
            for (int i = 1; i < 5; i++) {
                list.add(i);
            }
            list.print();
            System.out.println("Thread 1 ends");
        });

        Thread thread2 = new Thread(() -> {
            System.out.println("Thread 2 starts");
            for (int i = 5; i < 11; i++) {
                list.add(i);
            }
            list.print();
            System.out.println("Thread 2 ends");
        });
        thread1.start();

        thread2.start();

        System.out.println("Main in ListSyncTask ends");
    }
    public static void SetSemTask() {
        System.out.println("Main in SetSemTask starts");
        Thread thread1 = new Thread(() -> {
            System.out.println("Thread 1 starts");
            for (int i = 0; i < 5; i++) {
                set.add(i);
            }
            set.print();
            System.out.println("Thread 1 ends");
        });

        Thread thread2 = new Thread(() -> {
            System.out.println("Thread 2 starts");
            for (int i = 5; i < 11; i++) {
                set.add(i);
            }
            set.print();
            System.out.println("Thread 2 ends");
        });
        thread1.start();

        thread2.start();

        System.out.println("Main in SetSemTask ends");
    }


    public static void main(String[] args) {
        Main.ListSyncTask();
        Main.SetSemTask();
    }
}
