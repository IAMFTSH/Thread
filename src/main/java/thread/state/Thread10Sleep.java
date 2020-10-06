package thread.state;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 邝明山
 * on 2020/9/29 21:43
 * 计时器实现
 */
public class Thread10Sleep implements Runnable {
    public static void main(String[] args) {
        Thread10Sleep thread10Sleep=new Thread10Sleep();
        new Thread(thread10Sleep).start();
    }

    /**
     * 倒计时
     */
    @Override
    public void run() {
        int i = 10;
        while (true) {
            System.out.println(i--);
            try {
                Date data=new Date(System.currentTimeMillis());
                System.out.println(new SimpleDateFormat("HH:MM:SS").format(data));
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(i==0) {
                break;
            }
        }
    }
}
