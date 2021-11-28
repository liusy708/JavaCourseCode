package threads.method04;


import java.util.concurrent.*;

/**
 * 方法四：使用future.get方法
 */
public class ThreadOne {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        System.out.println("线程1开始");

        ExecutorService executor = Executors.newFixedThreadPool(1);
        Callable myCallable = () -> {
            System.out.println("线程2开始");
            Thread.sleep(2000);
            System.out.println("线程2结束");
            return null;
        };
        Future future = executor.submit(myCallable);
        future.get();
        System.out.println("线程1结束");
    }
}