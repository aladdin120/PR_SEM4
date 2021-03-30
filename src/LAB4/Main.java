package LAB4;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorServiceClass es = new ExecutorServiceClass(4);

        Callable<String> myName = () -> {
            return "My name is " + Thread.currentThread().getName() + "\n";
        };

        Runnable runnable = ()  -> {
            System.out.println("My name is " + Thread.currentThread().getName() + "\n");
        };

        es.execute(runnable);

        Future<String> f1 = es.submit(myName);
        Future<String> f2 = es.submit(myName);
        Future<String> f3 = es.submit(myName);

        System.out.println(f1.get() + f2.get() + f3.get());
        es.shutdown();
    }


}
