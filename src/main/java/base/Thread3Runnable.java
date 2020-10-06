package base;

/**
 * @author 邝明山
 * on 2020/9/28 21:46
 * Runnable实现，主要区别是需要创建一个实现类，如何放入继承接口的类
 *
 * 推荐使用Runnable
 */
public class Thread3Runnable implements Runnable{

    public static void main(String[] args) {
        Thread3Runnable runnable3=new Thread3Runnable();
        //这个会先于主线程，执行完副线程才执行主线程
        //thread.run();
        //thread2.run();
        //这个会和主线程同步执行，一起抢cpu
        new Thread(runnable3,"线程名1").start();
        new Thread(runnable3,"线程名2").start();




        for (int i = 0; i < 2000; i++) {
            System.out.println("这是主线程-----------------------------------"+i);
        }
    }

    public void run() {
        for (int i = 0; i < 2000; i++) {
            System.out.println(Thread.currentThread().getName()+"--------这是副线程++++++++++++++++++++++++++++"+i);
        }
    }
}
