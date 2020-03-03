package SingletonExam;
// 恶汉模式(线程安全)
// JVM在加载这个类时就马上创建此唯一的单例实例
// 空间换时间，每次调用的时候，就不需要再判断，节省了运行时间
public class Singleton1 {
    private Singleton1(){}
    // 注意 static
    private static Singleton1 instance = new Singleton1();
    // 注意 static
    public static Singleton1 getInstance(){
        return instance;
    }
    public void myPrint(){
        System.out.println("I am 饿汉式 Singleton1.");
    }

}
