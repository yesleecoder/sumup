/**
 * Create by Intellij IDEA  2017.2
 * Create by  lee
 * Create at  2018/12/13 11:28
 */
package main.com.lee.generic;

import java.util.Arrays;
import java.util.List;

public class convert {
   // 数组转集合
    private static void fun6() {
        //数组转集合
        int[] array= {1,2,3,4,5};
        //根据泛型 这个集合中每一个元素都是一个数组
        List<int[]> list = Arrays.asList(array);
        System.out.println(list);
        //直接传入 int[] 系统不会帮你进行自动装箱
        Integer[] newArray= {1,2,3,4,5};
        //直接把数组中的元素放入了集合中
        List<Integer> newList = Arrays.asList(newArray);
        System.out.println(newList);
    }

}
