package base;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * @author 邝明山
 * on 2020/9/28 21:11
 * 练习，实现多线程下载图片
 */
@Data
@AllArgsConstructor
public class Thread2Download extends Thread{
    private String url;
    private String fileName;

    public static void main(String[] args) {
        Thread2Download t1=new Thread2Download("https://www.baidu.com/img/flexible/logo/pc/peak-result.png","file.png");
        Thread2Download t2=new Thread2Download("https://www.baidu.com/img/flexible/logo/pc/result.png","file1.png");
        Thread2Download t3=new Thread2Download("https://dss1.baidu.com/9vo3dSag_xI4khGko9WTAnF6hhy/forum/crop=192,0,1728,1080/sign=d386eb0614178a82da7325e0cb324abf/3801213fb80e7bec0547122b252eb9389a506b5e.jpg","file2.jpg");
        t1.start();
        t2.start();
        t3.start();
    }

    @Override
    public void run() {
        WebDownloader webDownloader=new WebDownloader();
        webDownloader.download(url,fileName);
        System.out.println(this.getName()+"线程:"+fileName);
    }
}

class WebDownloader{
    public void download(String url,String fileName){
        try {
            FileUtils.copyURLToFile(new URL(url) ,new File(fileName));
        } catch (IOException e) {
            System.out.println("download方法出现异常");
            e.printStackTrace();
        }
    }
}
