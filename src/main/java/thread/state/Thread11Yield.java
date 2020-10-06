package thread.state;

/**
 * @author 邝明山
 * on 2020/9/29 21:56
 * 线程礼让，但是是下一个还是不是他，看cpu
 * 所以实现结果可以并不明显
 */
public class Thread11Yield implements Runnable{

    public static void main(String[] args) {
        Thread11Yield thread11Yield=new Thread11Yield();
        new Thread(thread11Yield,"---------线程一").start();
        new Thread(thread11Yield,"线程二").start();
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"开始执行");
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()+"："+i);
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName()+"结束执行");
    }
}
