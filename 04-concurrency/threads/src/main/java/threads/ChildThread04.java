package threads;

public class ChildThread04 extends Thread {

    @Override
    public void run() {
        System.out.println("线程2开始");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程2结束");
        Method04.flag = fibo(3);
    }

    private static int fibo(int a) {
        if ( a < 2)
            return 1;
        return fibo(a-1) + fibo(a-2);
    }

}
