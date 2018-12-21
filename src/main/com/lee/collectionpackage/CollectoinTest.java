/**
 * Create by Intellij IDEA  2017.2
 * Create by  lee
 * Create at  2018/12/21 14:24
 */
package main.com.lee.collectionpackage;

import org.junit.Test;

import java.util.*;

public class CollectoinTest {
    //  Collection 接口 有 List 和 Set 两个子接口。 Map 不是其子接口
    // List 接口 有 ArrayList LinkedList 实现类  LinkList和ArrayList 都是线程不安全的  想线程安全使用Vector

     // ArrayList LinkedList 遍历 四张遍历方式
    @Test
    public void ArrayListTest(){
   //     List<String> list=new ArrayList<String>();
        List<String> list=new LinkedList<String>();
        list.add("Hello");
        list.add("World");
        list.add("HAHAHAHA");
        // 遍历方法

        //第一种遍历方法使用foreach遍历List
        for (String str : list) {            //也可以改写for(int i=0;i<list.size();i++)这种形式
            System.out.println(str);
        }
        // 遍历
        for(int i = 0;i<list.size();i++){
            System.out.println(list.get(i));
        }

        //第三种遍历，把链表变为数组相关的内容进行遍历
        String[] strArray=new String[list.size()];
        list.toArray(strArray);
        for(int i=0;i<strArray.length;i++) //这里也可以改写为foreach(String str:strArray)这种形式
        {
            System.out.println(strArray[i]);
        }

        //第四种遍历 使用迭代器进行相关遍历

        Iterator<String> ite=list.iterator();
        while(ite.hasNext())
        {
            System.out.println(ite.next());
        }
    }

    // Set 与 List 区别 set 不能有重复的。list可以有重复的
    // 对 Set 的一些方法 进行演示
    // Set接口的常见实现类有HashSet,LinedHashSet和TreeSet这三个。最常用HashSet
    @Test
    public void SetTest(){
        Set<String> set = new HashSet<String>();
        set.add("Hello");
        set.add("World");
        set.add("Hello");
        System.out.println(set);
        System.out.println(set.size());
        // 这里的遍历方法就不介绍  跟List的一致
    }


}
