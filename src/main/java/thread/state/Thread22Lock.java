package thread.state;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author FTSH
 */
public class Thread22Lock implements Runnable {
    final ReentrantLock reentrantLock = new ReentrantLock();
    int num = 1000;
    boolean flat=true;

    public static void main(String[] args) {
        Thread22Lock run = new Thread22Lock();
        new Thread(run, "张三").start();
        new Thread(run, "李四").start();
        new Thread(run, "王五").start();

    }

    @Override
    public void run() {
        int i = 0;
        while (flat) {
            reentrantLock.lock();
            try {
                if(num>0) {
                    System.out.println(Thread.currentThread().getName() + "抢到了一张，剩余票数" + num--);
                    i++;
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                else {
                    flat=false;
                }
            } finally {
                reentrantLock.unlock();
            }
        }
        System.out.println(Thread.currentThread().getName() + "票数:" + i);
    }
}
