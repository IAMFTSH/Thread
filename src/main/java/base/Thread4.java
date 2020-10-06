package base;

/**
 * @author 邝明山
 * on 2020/9/29 10:22
 * 并发问题
 */
public class Thread4 implements Runnable{
    private int num=100;

    public static void main(String[] args) {
        Thread4 run=new Thread4();
        new Thread(run,"张三").start();
        new Thread(run,"李四").start();
        new Thread(run,"王五").start();

    }

    public void run() {
        int i=0;
        while (num>0) {
            System.out.println(Thread.currentThread().getName() + "抢到了一张，剩余票数" + num--);
            i++;
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + "票数:" +i);
    }
}
