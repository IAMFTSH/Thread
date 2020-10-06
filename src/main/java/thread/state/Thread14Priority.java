package thread.state;

/**
 * @author 邝明山
 * on 2020/9/29 22:30
 * 优先级只是概率更高
 */
public class Thread14Priority implements Runnable{
    public static void main(String[] args) {
        Thread14Priority thread14Priority=new Thread14Priority();
        Thread thread1=new Thread(thread14Priority,"线程1");
        Thread thread2=new Thread(thread14Priority,"线程2");
        Thread thread3=new Thread(thread14Priority,"线程3");
        Thread thread4=new Thread(thread14Priority,"线程4");
        Thread thread5=new Thread(thread14Priority,"线程5");
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread1.setPriority(Thread.MIN_PRIORITY);
        thread2.setPriority(2);
        thread3.setPriority(3);
        thread4.setPriority(4);
        thread5.setPriority(Thread.MAX_PRIORITY);

    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"优先级："+Thread.currentThread().getPriority());
    }
}
