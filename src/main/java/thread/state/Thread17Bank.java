package thread.state;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author 邝明山
 * on 2020/9/30 15:02
 * 这里使用同一个对象去构建对象，那么他们就会共享这个对象的数据
 */
public class Thread17Bank {
    public static void main(String[] args) {
        Account account=new Account(100000,"结婚基金");
        Drawing myLove=new Drawing(account,100000,0);
        Drawing me=new Drawing(account,50000,0);
        new Thread(myLove).start();
        new Thread(me).start();
    }
}
@AllArgsConstructor
class Account{
    int money;
    String name;
}
@Data
@AllArgsConstructor
class Drawing implements Runnable{
    private Account account;
    private int drawing;
    private int nowMoney;
    @Override
    public void run() {

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
        System.out.println(Thread.currentThread().getName()+":"+nowMoney);
        System.out.println(account.money);
    }
}