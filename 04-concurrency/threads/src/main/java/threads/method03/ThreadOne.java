package threads.method03;

import java.util.concurrent.CountDownLatch;

/**
 * 方法三：使用CountDownLatch.await方法，暂停线程1直到线程2结束
 */
public class ThreadOne {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("线程1开始");
        CountDownLatch countDownLatch = new CountDownLatch(1);

        new ThreadTwo(countDownLatch).start();
        countDownLatch.await();
        System.out.println("线程1结束");
    }
}