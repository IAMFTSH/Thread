package thread.state;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author 邝明山
 * on 2020/9/30 20:47
 * 生产者/消费者，管程法
 */
public class Thread23Monitor {
    public static void main(String[] args) {
        Container container=new Container();
        Produce produce=new Produce(container);
        Customer customer=new Customer(container);
        Customer customer2=new Customer(container);
        Thread produceThread=new Thread(produce);
        Thread customerThread=new Thread(customer);
        Thread customerThread2=new Thread(customer);
        produceThread.start();
        customerThread.start();
        customerThread2.start();
    }
}

class Produce implements Runnable {
    Container container;
    @Override
    public void run() {
        while (container.id++<100) {
            container.push(new Chicken(container.id));
        }
        container.produce=false;
    }
    public Produce(Container container) {
        this.container = container;
    }
}

@AllArgsConstructor
class Customer implements Runnable {
    Container container;
    @Override
    public void run() {
        while (container.produce==true||container.count!=0) {
            System.out.println("消费者吃了：" + container.pop() + "鸡");
        }
    }
}

@Data
class Container {
    int count = 0;
    int id=0;
    Boolean produce=true;
    Chicken[] chickens = new Chicken[10];

    synchronized int pop() {
        while (count == 0) {
            try {
                System.out.println("消费者等待");
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count--;
        int id=chickens[count].getId();
        notifyAll();
        return id;
    }

    synchronized void push(Chicken chicken) {
        while ( count== chickens.length) {
            try {
                System.out.println("生产者等待"+count);
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        chickens[count] =chicken;
        count++;
        notifyAll();
    }
}

@AllArgsConstructor
@Data
class Chicken {
    int id;
}
