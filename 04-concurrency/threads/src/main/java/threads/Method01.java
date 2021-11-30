package threads;

import java.util.concurrent.*;

/**
 * 方法一：使用join方法，暂停线程1直到线程2结束
 */
public class Method01 {

    public static volatile int flag = 0;

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        System.out.println("主线程开始");

        Thread t = new ChildThread01();
        t.start();
        t.join();

        if (flag > 0) {
            System.out.println("主线程结束");
        }
    }
}