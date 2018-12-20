/**
 * Create by Intellij IDEA  2017.2
 * Create by  lee
 * Create at  2018/12/14 10:35
 */
package main.com.lee.generic;

public class GenericClass {
    // 泛型类的简单定义
    //key这个成员变量的类型为T,T的类型由外部指定
    private static class generic<T>{
        private T var;

        public generic(T var){  //泛型构造方法形参key的类型也为T，T的类型由外部指定
            this.var = var;
        }
        public T get(){
            return this.var;
        }
        public void set(T var){
            this.var = var;
        }

    }

    public static void main(String[] args) {
        //传入的实参类型需与泛型的类型参数类型相同，即为Integer.
        generic<Integer> g1 = new generic<Integer>(1);    // 泛型类的使用
        generic<String> g2 = new generic<String>("test");

        System.out.println(g1.get());
        System.out.println(g2.get());


    }
}
