package thread.state;

/**
 * @author 邝明山
 * on 2020/9/29 22:16
 */
public class Thread13State implements Runnable{
    public static void main(String[] args) throws InterruptedException {
        Thread13State thread13State=new Thread13State();
        Thread thread=new Thread(thread13State,"等待");
        thread.start();
        for (int i = 0; i < 1000; i++) {
            System.out.println("状态:"+thread.getState());
            Thread.sleep(1000);
        }
    }
    @Override
    public void run() {
        int i=0;
        while (true) {
            i++;
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
