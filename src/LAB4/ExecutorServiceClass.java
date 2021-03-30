package LAB4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

import static java.lang.ref.Reference.reachabilityFence;

public class ExecutorServiceClass extends AbstractExecutorService  {

    private final ExecutorService e;

    public ExecutorServiceClass(int threadsCount) {
        e = Executors.newFixedThreadPool(threadsCount);
    }

    @Override
    public void shutdown() { e.shutdown(); }

    @Override
    public List<Runnable> shutdownNow() {
        try {
            return e.shutdownNow();
        } finally { reachabilityFence(this); }
    }

    @Override
    public boolean isShutdown() {
        try {
            return e.isShutdown();
        } finally { reachabilityFence(this); }
    }

    @Override
    public boolean isTerminated() {
        try {
            return e.isTerminated();
        } finally { reachabilityFence(this); }
    }

    @Override
    public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
            try {
                return e.awaitTermination(timeout, unit);
            } finally { reachabilityFence(this); }
    }

    @Override
    public <T> Future<T> submit(Callable<T> task) {
        try {
            return e.submit(task);
        } finally { reachabilityFence(this); }
    }

    @Override
    public Future<?> submit(Runnable task) {
        try {
            return e.submit(task);
        } finally { reachabilityFence(this); }
    }

    @Override
    public void execute(Runnable command) {
        try {
            e.execute(command);
        } finally { reachabilityFence(this); }
    }
}
