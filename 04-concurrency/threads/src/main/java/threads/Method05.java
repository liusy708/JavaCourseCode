package threads;

import threads.ChildThread02;

/**
 * 方法五：判断线程2是否还在存活
 */
public class Method05 {

    public static int flag = 0;

    public static void main(String[] args) {
        System.out.println("线程1开始");
        Thread t2 = new ChildThread02();
        t2.start();

        while (true) {
            if (!t2.isAlive()) {
                break;
            }
        }
        if (flag > 0) {
            System.out.println("线程1结束");
        }
    }
}
