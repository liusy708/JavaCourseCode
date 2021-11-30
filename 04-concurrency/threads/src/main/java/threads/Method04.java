package threads;


import java.util.concurrent.*;

/**
 * 方法四：使用future.get方法
 */
public class Method04 {
    public static int flag = 0;

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        System.out.println("线程1开始");

        ExecutorService executor = Executors.newFixedThreadPool(1);
        Callable myCallable = () -> {
            System.out.println("线程2开始");
            Thread.sleep(2000);
            System.out.println("线程2结束");
            return 100;
        };
        Future future = executor.submit(myCallable);
        flag = (int) future.get();
        if (flag > 0) {
            System.out.println("线程1结束");
        }
        executor.shutdown();
    }
}