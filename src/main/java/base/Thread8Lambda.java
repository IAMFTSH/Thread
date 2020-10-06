package base;

/**
 * @author 邝明山
 * on 2020/9/29 20:47
 * 各种类
 */
public class Thread8Lambda {
    static class Impl2 implements LamBdaInterface {
        @Override
        public void print(int i) {
            System.out.println("静态全局内部类"+i);
        }
    }

    public static void main(String[] args) {
        class Impl3 implements LamBdaInterface {

            @Override
            public void print(int i) {
                System.out.println("局部内部类"+i);
            }
        }


        LamBdaInterface impl1 = new Impl1();
        impl1.print(1);
        LamBdaInterface impl2 = new Impl2();
        impl2.print(2);
        LamBdaInterface impl3 = new Impl3();
        impl3.print(3);
        LamBdaInterface impl4 = new LamBdaInterface() {
            @Override
            public void print(int i) {
                System.out.println("匿名局部内部类"+i);
            }
        };
        impl4.print(4);
        LamBdaInterface impl5 = (i) -> {

            System.out.println("LamBda简化匿名局部内部类"+i);

        };
        impl5.print(5);

        LamBdaInterface impl6 = i -> System.out.println("LamBda更简化版匿名局部内部类+这里简化了大括号和小括号，大括号如果多条函数可以加上"+i);
        impl6.print(6);
    }
}

//1.定义一个接口
interface LamBdaInterface {
    /**
     * 只能由一个方法
     */
    void print(int i);
}

//普通类
class Impl1 implements LamBdaInterface {

    @Override
    public void print(int i) {
        System.out.println("普通类"+i);
    }
}
