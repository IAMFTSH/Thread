package thread.state;

/**
 * @author 邝明山
 * on 2020/9/30 14:38
 * 如果是两个独立的Runnable去创建线程，那么他们的全局变量线程间不共享
 * 但hi如果是同一个Runnable去创建线程，那么共享全局变量
 */
public class Thread16Buy {
    public static void main(String[] args) {
        Buy buy=new Buy();
        //Buy buy2=new Buy();
        new Thread(buy, "线程1").start();
        //new Thread(buy2, "线程2").start();
        new Thread(buy, "线程2").start();

    }}

class Buy implements Runnable{
    private int num=1000;
    private boolean flag=true;
    @Override
    public void run() {
        while (flag){
            isExist();
        }
    }
    synchronized void isExist(){
        if (num<=0) {
            flag=false;
            return;
        }
        else {
            //奇怪了，为什么不会多买呢,因为方法不够复杂
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+":"+num--);
            return;
        }

    }
}