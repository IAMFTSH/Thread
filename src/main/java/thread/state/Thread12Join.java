package thread.state;

/**
 * @author 邝明山
 * on 2020/9/29 22:04
 * join() 插队
 *
 * 主线程不再跑 ，但是另外的副线程还在跑
 */
public class Thread12Join implements Runnable{

    public static void main(String[] args) throws InterruptedException {
        Thread12Join thread12Join=new Thread12Join();
        Thread thread=new Thread(thread12Join,"插队的");
        new Thread(thread12Join,"守规矩的").start();
        thread.start();
        for (int i = 0; i < 10000; i++) {
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++"+i);
            if(i==500){
                System.out.println("插队了————————————————————————————————————————————————————————————————————————");
                thread.join();
            }
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            System.out.println(Thread.currentThread().getName()+"-------------"+i);
        }
    }
}
