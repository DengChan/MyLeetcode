package SingletonExam;
// 懒汉式：双重检查加锁
// 先检查是否实例已经创建，
// 如果尚未创建，“才”进行同步。如果已经创建，则没必要进入同步代码块，减少时间消耗
// 这样以来，只有一次同步，这正是我们想要的效果。
// 关键点 : volatile 关键字；两次判断; synchronized 同步代码块
public class Singleton2 {
    private Singleton2() {}
    private volatile static Singleton2 instance = null;
    public static Singleton2 getInstance(){
        if(instance==null){
            synchronized(Singleton2.class) {
                if(instance==null){
                    instance = new Singleton2();
                }
            }
        }
        return instance;
    }

    public void myPrint(){
        System.out.println("This is 懒汉式双重检查+同步锁 Singleton2.");
    }

}
