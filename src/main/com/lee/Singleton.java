/**
 * Create by Intellij IDEA  2017.2
 * Create by  lee
 * Create at  2018/12/10 14:54
 */
package main.com.lee;

/**
 * 单例模式： 一个类只能创建一个实例
 * 意义：
 * 意义：
 *    1. 避免不一致状态 避免多个实例不一致状态
      2. 由于单例模式只生成一个实例, 减少了系统性能开销(如: 当一个对象的产生需要比较多的资源时, 如读取配置, 产生其他依赖对象,
         则可以通过在应用启动时直接产生一个单例对象, 然后永久驻留内存的方式来解决)
   应用：
         Windows中的任务管理器;
         文件系统, 一个操作系统只能有一个文件系统;
         数据库连接池的设计与实现;
         Spring中, 一个Component就只有一个实例Java-Web中, 一个Servlet类只有一个实例;
 * 下面饿汉式单例模式 写法  线程不安全
 */
public class Singleton {
    private static Singleton singletonTest;
    private Singleton(){

    }

    private static Singleton getinstance(){
        if (singletonTest == null){
            singletonTest = new Singleton();
        }
        return singletonTest;
    }

}
