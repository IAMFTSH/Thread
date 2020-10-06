package base;

/**
 * @author 邝明山
 * on 2020/9/29 11:17
 * 静态代理模式
 * 代理对象和代理人实现同一个接口
 * 代理对象要代理真实角色
 * 好处
 * 代理对象处理自己事情
 * 代理人处理别的事情
 * 可以让逻辑不那么复杂，各自做各自的事情
 */
public class Thread7StaticProxy {
    public static void main(String[] args) {
        Marrier marrier=new Marrier();
        MarryCompany marryCompany=new MarryCompany(marrier);
        marryCompany.merry();
    }
}
interface HappyMerry{
    /**
     * 结婚需要处理的事情
     */
    public void merry();
}

class Marrier implements HappyMerry{
    public void merry() {
        System.out.println("洞房花烛夜");
    }
}
class MarryCompany implements HappyMerry{
    HappyMerry marrier;

    public MarryCompany(HappyMerry Marrier) {
        this.marrier = Marrier;
    }

    public void merry() {
        System.out.println("结婚前处理");
        this.marrier.merry();
        System.out.println("结婚后处理");
    }
}