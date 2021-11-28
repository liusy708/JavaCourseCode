package threads.method01;

/**
 * 方法一：使用join方法，暂停线程1直到线程2结束
 */
public class ThreadOne {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("线程1开始");
        Thread t2 = new ThreadTwo();
        t2.start();
        t2.join();
        System.out.println("线程1结束");
    }
}