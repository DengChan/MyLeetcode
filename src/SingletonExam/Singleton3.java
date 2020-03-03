package SingletonExam;

// 登记式 线程安全
// 注意点: final 修饰变量和方法
// 类只会装载一次,第一次get的时候会装载 singletonHolder
public class Singleton3 {

    private static class singletonHolder{
        private static final Singleton3 instance = new Singleton3();
    }
    private Singleton3(){}
    public static final Singleton3 getInstance(){
        return singletonHolder.instance;
    }

    public void myPrint(){
        System.out.println("This is 登记式 Singleton3.");
    }

}
