package threads.method03;

import java.util.concurrent.CountDownLatch;

public class ThreadTwo extends Thread {

    private CountDownLatch latch;

    public ThreadTwo(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        System.out.println("线程2开始");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程2结束");
        latch.countDown();
    }
}
