package base;

/**
 * @author 邝明山
 * on 2020/9/28 20:51
 * run方法和start的区别
 */
public class Thread1 extends Thread{
    public Thread1(String theadName) {
        this.setName(theadName);
    }

    public static void main(String[] args) {
        Thread1 thread=new Thread1("线程1");
        Thread1 thread2=new Thread1("线程2");

        //这个会先于主线程，执行完副线程才执行主线程
        //thread.run();
        //thread2.run();
        //这个会和主线程同步执行，一起抢cpu
        thread.start();
        thread2.start();

        for (int i = 0; i < 200000000; i++) {
            System.out.println("这是主线程-----------------------------------"+i);
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < 200000000; i++) {
            System.out.println(this.getName()+"--------这是副线程++++++++++++++++++++++++++++"+i);
        }
    }
}
