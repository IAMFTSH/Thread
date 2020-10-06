package base;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.concurrent.*;

/**
 * @author 邝明山
 * on 2020/9/29 10:55
 * Callable
 * 1.可以返回值
 * 2.可以抛出异常
 * 3.好像是以start运行
 */
@Data
@AllArgsConstructor

public class Thread6Callable implements Callable {
    private String url;
    private String fileName;

    public static void main(String[] args) {
        Thread6Callable t1=new Thread6Callable("https://www.baidu.com/img/flexible/logo/pc/peak-result.png","file.png");
        Thread6Callable t2=new Thread6Callable("https://www.baidu.com/img/flexible/logo/pc/result.png","file1.png");
        Thread6Callable t3=new Thread6Callable("https://dss1.baidu.com/9vo3dSag_xI4khGko9WTAnF6hhy/forum/crop=192,0,1728,1080/sign=d386eb0614178a82da7325e0cb324abf/3801213fb80e7bec0547122b252eb9389a506b5e.jpg","file2.jpg");
        //创建服务
        ExecutorService executorService= Executors.newFixedThreadPool(3);
        //提交执行
        Future<Boolean> r1=executorService.submit(t1);
        Future<Boolean> r2=executorService.submit(t2);
        Future<Boolean> r3=executorService.submit(t3);
        //获得结果
        try {
            System.out.println("结果1："+r1.get());
            System.out.println("结果2："+r2.get());
            System.out.println("结果3："+r3.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        //关闭服务
        executorService.shutdownNow();
    }

    public Boolean call() throws Exception {
        WebDownloader webDownloader=new WebDownloader();
        webDownloader.download(url,fileName);
        System.out.println(Thread.currentThread().getName()+"线程:"+fileName);
        return true;
    }
}


