package threads.method02;

public class ThreadTwo extends Thread {

    @Override
    public void run() {
        System.out.println("线程2开始");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程2结束");
        ThreadOne.flag = 1;
    }

}
