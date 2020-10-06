package thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Thread26NewFixedThreadPoolTest {

    public static void main(String[] args) {
        // 创建一个可重用固定个数的线程池   Runtime.getRuntime().availableProcessors()根据系统资源变动大小
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        for (int i = 0; i < 10000; i++) {
            fixedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        // 打印正在执行的缓存线程信息
                        System.out.println(Thread.currentThread().getName()
                                + "正在被执行");
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

}