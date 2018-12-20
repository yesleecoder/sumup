/**
 * Create by Intellij IDEA  2017.2
 * Create by  lee
 * Create at  2018/12/14 11:24
 */
package main.com.lee.generic;

public class GenericMethod {
    //这个类是个泛型类，在上面已经介绍过
    public class Generic<T>{
        private T key;

        public  Generic(T key) {
            this.key = key;
        }

        //我想说的其实是这个，虽然在方法中使用了泛型，但是这并不是一个泛型方法。
        //这只是类中一个普通的成员方法，只不过他的返回值是在声明泛型类已经声明过的泛型。
        //所以在这个方法中才可以继续使用 T 这个泛型。
        public T getKey(){    // 非泛型方法
            return key;
        }

        /**
         * 这个方法显然是有问题的，在编译器会给我们提示这样的错误信息"cannot reslove symbol E"
         * 因为在类的声明中并未声明泛型E，所以在使用E做形参和返回值类型时，编译器会无法识别。
         public E setKey(E key){
         this.key = keu
         }
         */
    }

    /**
     * 这才是一个真正的泛型方法。
     * 首先在public与返回值之间的<T>必不可少，这表明这是一个泛型方法，并且声明了一个泛型T
     * 这个T可以出现在这个泛型方法的任意位置.
     * 泛型的数量也可以为任意多个
     *    如：public <T,K> K showKeyName(Generic<T> container){
     *        ...
     *        }
     */
    public <T> T showKeyName(Generic<T> container){
        System.out.println("container key :" + container.getKey());
        //当然这个例子举的不太合适，只是为了说明泛型方法的特性。
        T test = container.getKey();
        return test;
    }

    //这也不是一个泛型方法，这就是一个普通的方法，只是使用了Generic<Number>这个泛型类做形参而已。
    public void showKeyValue1(Generic<Number> obj){
        System.out.println("泛型测试"+"key value is " + obj.getKey());
    }

    //这也不是一个泛型方法，这也是一个普通的方法，只不过使用了泛型通配符?
    //同时这也印证了泛型通配符章节所描述的，?是一种类型实参，可以看做为Number等所有类的父类
    public void showKeyValue2(Generic<?> obj){
        System.out.println("泛型测试"+"key value is " + obj.getKey());
    }

    /**
     * 这个方法是有问题的，编译器会为我们提示错误信息："UnKnown class 'E' "
     * 虽然我们声明了<T>,也表明了这是一个可以处理泛型的类型的泛型方法。
     * 但是只声明了泛型类型T，并未声明泛型类型E，因此编译器并不知道该如何处理E这个类型。
     public <T> T showKeyName(Generic<E> container){
     ...
     }
     */

    /**
     * 这个方法也是有问题的，编译器会为我们提示错误信息："UnKnown class 'T' "
     * 对于编译器来说T这个类型并未项目中声明过，因此编译也不知道该如何编译这个类。
     * 所以这也不是一个正确的泛型方法声明。
     public void showkey(T genericObj){

     }
     */

    //  参数可变的泛型方法
    public static <T> void printMsg( T... args){
        for(T t : args){
            System.out.println("泛型测试"+"t is " + t);
        }
    }
/*

    静态方法有一种情况需要注意一下，那就是在类中的静态方法使用泛型：静态方法无法访问类上定义的泛型；如果静态方法操作的引用数据类型不确定的时候，必须要将泛型定义在方法上。

    即：如果静态方法要使用泛型的话，必须将静态方法也定义成泛型方法 。

    public class StaticGenerator<T> {
    ....
            ....
        */
/**
         * 如果在类中定义使用泛型的静态方法，需要添加额外的泛型声明（将这个方法定义成泛型方法）
         * 即使静态方法要使用泛型类中已经声明过的泛型也不可以。
         * 如：public static void show(T t){..},此时编译器会提示错误信息：
         "StaticGenerator cannot be refrenced from static context"
         *//*

        public static <T> void show(T t){

        }
    }
*/
    static class Generic1<T>{
        private T Key;
        public Generic1(T key){
            this.Key = key;
        }
        public T getKey(){
            return  this.Key;
        }
    }
    /*为泛型添加上边界，即传入的类型实参必须是指定类型的子类型  <? extends Number>*/

    public static void  showKeyValue11(Generic1<? extends Number> obj){
        System.out.println("泛型测试"+"key value is " + obj.getKey());
    }

    //在泛型方法中添加上下边界限制的时候，必须在权限声明与返回值之间的<T>上添加上下边界，即在泛型声明的时候添加
    //public <T> T showKeyName(Generic<T extends Number> container)，编译器会报错："Unexpected bound"
    public <T extends Number> T showKeyName1(Generic<T> container){
        System.out.println("container key :" + container.getKey());
        T test = container.getKey();
        return test;
    }

    public static void main(String[] args) {
        printMsg("111",222,"aaaa","2323.4",55.55);

        Generic1<String> generic1 = new Generic1<String>("11111");
        Generic1<Integer> generic2 = new Generic1<Integer>(2222);
        Generic1<Float> generic3 = new Generic1<Float>(2.4f);
        Generic1<Double> generic4 = new Generic1<Double>(2.56);

        //这一行代码编译器会提示错误，因为String类型并不是Number类型的子类
       // showKeyValue1(generic1);

        showKeyValue11(generic2);
        showKeyValue11(generic3);
        showKeyValue11(generic4);

    }
}
