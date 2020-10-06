package thread.state;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author 邝明山
 * on 2020/9/30 15:02
 * 这里使用同一个对象去构建对象，那么他们就会共享这个对象的数据
 */
public class Thread20SynchronizedBank {
    public static void main(String[] args) {
        Account account=new Account(100000,"结婚基金");
        Drawing2 myLove=new Drawing2(account,100000,0);
        Drawing2 me=new Drawing2(account,50000,0);
        new Thread(me).start();
        new Thread(myLove).start();

    }
}

@Data
@AllArgsConstructor
class Drawing2 implements Runnable{
    private Account account;
    private int drawing;
    private int nowMoney;
    //方法这里如果加Synchronized锁的是myLove或者是me，不是锁account
    @Override
    public void run() {

        //方法块锁，锁的是增删改的，但是查和增删改联系紧密还是一起锁吧
        synchronized (account){
            if(account.money<drawing){
                System.out.println(Thread.currentThread().getName()+":钱不够");
                return;
            }
            //睡眠扩大问题
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            nowMoney = drawing;
            account.money-=drawing;
        }
        System.out.println(Thread.currentThread().getName()+":"+nowMoney);
        System.out.println(account.money);
    }
}