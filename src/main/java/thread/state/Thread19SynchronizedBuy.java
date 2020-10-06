package thread.state;

/**
 * @author 邝明山
 * on 2020/9/30 14:38
 * synchronized锁的是this，锁的是方法调用者本身锁的是创建这个线程用的Runnable
 * 如果num太小，可能会导致一个线程抢光了
 */
public class Thread19SynchronizedBuy {
    public static void main(String[] args) {
        BuySynchronized buy = new BuySynchronized();
        //Buy buy2=new Buy();
        new Thread(buy, "线程1").start();
        //new Thread(buy2, "线程2").start();
        new Thread(buy, "线程2").start();

    }
}


class BuySynchronized implements Runnable {
    private int num = 1000;
    private boolean flag = true;

    @Override
    public void run() {
        while (flag) {
            try {
                isExist();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //synchronized锁的是this，锁的是方法调用者本身锁的是创建这个线程用的Runnable
    private synchronized void isExist() throws InterruptedException {
        if (num <= 0) {
            flag = false;
            return;
        }
        Thread.sleep(1);
        System.out.println(Thread.currentThread().getName() + ":" + num--);
    }
}