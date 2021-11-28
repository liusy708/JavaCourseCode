package threads.method05;

/**
 * 方法五：判断线程2是否还在存活
 */
public class ThreadOne {

    public static void main(String[] args) {
        System.out.println("线程1开始");
        Thread t2 = new threads.method01.ThreadTwo();
        t2.start();

        while (true) {
            if (!t2.isAlive()) {
                break;
            }
        }
        System.out.println("线程1结束");
    }
}
