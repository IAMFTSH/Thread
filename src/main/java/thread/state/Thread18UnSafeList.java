package thread.state;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 邝明山
 * on 2020/9/30 15:17
 */
public class Thread18UnSafeList {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            new Thread(()->{
                list.add(Thread.currentThread().getName());
            }).start();
        }
        //几个线程同时向list中增加东西，导致同一位置，多处重复，发生了覆盖
        System.out.println(list.size());
    }
}

