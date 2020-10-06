package base;

/**
 * @author 邝明山
 * on 2020/9/29 10:30
 */
public class Thread5Race implements Runnable{

    final int target=10000;
    String winner=null;
    public static void main(String[] args) {
        Thread5Race race=new Thread5Race();
        new Thread(race,"兔子").start();
        new Thread(race,"乌龟").start();

    }

    public void run() {
        int step=0;


        for (int i = 0; i <= target; i++) {
            if (Thread.currentThread().getName().equals("兔子")){
                if(i%1000==0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                step+=20;
            }

            if (isOver(step)||winner!=null){
                break;
            }
            System.out.println(Thread.currentThread().getName()+step++);;
        }
    }
    boolean isOver(int step){
        if(step>=target) {
            winner=Thread.currentThread().getName();
            System.out.println(winner+"---"+step);
            return true;
        }
        return false;
    }
}
