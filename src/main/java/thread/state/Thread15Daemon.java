package thread.state;

/**
 * @author 邝明山
 * on 2020/9/30 11:11
 * 守护线程
 * 当主线程结束时，其余的守护线程自动关闭，就免去了还要继续关闭子线程的麻烦。如：Java垃圾回收线程就是一个典型的守护线程；内存资源或者线程的管理，但是非守护线程也可以。
 */
public class Thread15Daemon implements Runnable{
    public static void main(String[] args) {
        Thread15Daemon thread15Daemon=new Thread15Daemon();
        new Thread(thread15Daemon).start();
        God god=new God();
        Thread thread=new Thread(god);
        thread.setDaemon(true);
        thread.start();

    }

    @Override
    public void run() {
        for (int i = 0; i < 36500; i++) {
            System.out.println("快乐活着第"+i+"天");
        }
    }
}
class God implements Runnable{

    @Override
    public void run() {
        while (true) {
            System.out.println("上帝守护");
        }
    }
}
