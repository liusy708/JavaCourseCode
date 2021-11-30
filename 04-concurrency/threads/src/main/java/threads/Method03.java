package threads;

import java.util.concurrent.CountDownLatch;

/**
 * 方法三：使用CountDownLatch.await方法，暂停线程1直到线程2结束
 */
public class Method03 {
    public volatile static int flag = 0;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("线程1开始");
        CountDownLatch countDownLatch = new CountDownLatch(1);

        new ChildThread03(countDownLatch).start();
        countDownLatch.await();
        if (flag > 0) {
            System.out.println("线程1结束");
        }
    }
}