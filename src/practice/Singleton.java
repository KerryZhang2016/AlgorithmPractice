package practice;

/**
 * Java单例模式的一种实现方式
 * 采用内部类，在这个内部类里面去创建对象实例。这样的话，只要应用中不使用内部类 JVM 就不会去加载这个单例类，也就不会创建单例对象，从而实现懒汉式的延迟加载和线程安全。
 *
 * Created by admin on 16/8/29.
 */
public class Singleton {

    private static class SingletonHolder {
        public static Singleton instance = new Singleton();
    }

    private Singleton() {}

    public static Singleton newIntance() {
        return SingletonHolder.instance;
    }

}
