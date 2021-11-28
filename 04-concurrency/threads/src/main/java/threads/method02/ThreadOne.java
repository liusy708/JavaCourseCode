package threads.method02;

/**
 * 方法二：使用volatile变量flag作为信号量，线程2结束后通过flag通知线程1
 */
public class ThreadOne {
    public volatile static int flag = 0;

    public static void main(String[] args) {
        System.out.println("线程1开始");
        Thread t2 = new ThreadTwo();
        t2.start();

        while (true) {
            if (flag > 0) {
                break;
            }
        }

        System.out.println("线程1结束");
    }
}
