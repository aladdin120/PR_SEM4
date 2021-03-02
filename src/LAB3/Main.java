package LAB3;

public class Main {

    private static final ListSynchronized<Integer> list = new ListSynchronized<>();
    private static final SetSemaphore<String> set = new SetSemaphore<String>();

    public static void ListSyncTask() throws InterruptedException {
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
        Thread.sleep(100);
        thread2.start();
        Thread.sleep(100);
        System.out.println("Main in ListSyncTask ends");
    }
    public static void SetSemTask() throws InterruptedException {
        System.out.println("Main in SetSemTask starts");
        Thread thread1 = new Thread(() -> {
            System.out.println("Thread 1 starts");
            for (int i = 1; i < 4; i++) {
                set.add("String " + i);
            }
            set.print();
            System.out.println("Thread 1 ends");
        });

        Thread thread2 = new Thread(() -> {
            System.out.println("Thread 2 starts");
            for (int i = 5; i < 11; i++) {
                set.add("String " + i);
            }
            set.print();
            System.out.println("Thread 2 ends");
        });
        thread1.start();
        Thread.sleep(100);
        thread2.start();
        Thread.sleep(100);

        System.out.println("Main in SetSemTask ends");
    }


    public static void main(String[] args) throws InterruptedException {
        Main.ListSyncTask();
        System.out.println();
        Main.SetSemTask();
    }
}
