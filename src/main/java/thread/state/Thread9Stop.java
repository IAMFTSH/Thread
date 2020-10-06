package thread.state;

import lombok.Data;

/**
 * @author 邝明山
 * on 2020/9/29 21:15
 */
@Data
public class Thread9Stop implements Runnable {
    private boolean flag = true;
    private int o=0;
    public static void main(String[] args) {
        Thread9Stop thread9Stop = new Thread9Stop();
        new Thread(thread9Stop, "推荐停止线程的方法是正常停止").start();

        for (int i = 0; i < 100000; i++) {
            System.out.println("------------------"+i);
            if (thread9Stop.getO() >100000) {
                thread9Stop.stop();
            }
        }
    }

    @Override
    public void run() {
        while (flag) {
            System.out.println(Thread.currentThread().getName() + o++);
        }
        System.out.println("停止了");
    }

    public void stop() {
        this.flag = false;
    }
}
