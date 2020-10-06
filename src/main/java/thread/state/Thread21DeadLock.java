package thread.state;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author 邝明山
 * on 2020/9/30 16:08
 * 死锁，两个线程需要两个对象，但是都被对方拿着一个不放，僵持
 */
@Data
public class Thread21DeadLock{
    public static void main(String[] args) {

        DeadLock me=new DeadLock(1,"本帅哥");
        DeadLock he=new DeadLock(0,"丑逼");
        new Thread(me).start();
        new Thread(he).start();

    }
}
class Key{

}
class Drive{

}
@AllArgsConstructor
class DeadLock implements Runnable{
    static Key key=new Key();
    static Drive drive=new Drive();
    int choice;
    String name;
    @Override
    public void run() {
        if(choice==1){
            synchronized (key){
                System.out.println(name+"获得key");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (drive){
                    System.out.println(name+"获得drive");
                }
            }
        }else {
            synchronized (drive){
                System.out.println(name+"获得drive");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (key){
                    System.out.println(name+"获得key");
                }
            }
        }
    }
}