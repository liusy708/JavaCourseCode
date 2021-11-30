package threads;

import java.util.concurrent.CountDownLatch;

public class ChildThread03 extends Thread {

    private CountDownLatch latch;

    public ChildThread03(CountDownLatch latch) {
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
        Method03.flag = 100;
        System.out.println("线程2结束");
        latch.countDown();
    }
}
