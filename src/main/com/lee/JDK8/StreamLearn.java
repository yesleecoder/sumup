/**
 * Create by Intellij IDEA  2017.2
 * Create by  lee
 * Create at  2018/11/27 9:33
 */
package main.com.lee.JDK8;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * https://www.cnblogs.com/chenpi/p/5915364.html   参考
 * JDK8 新特性  Stream流的概念
 * 简介：跟JAVA I/O中的InputStream和OutputStream是两个不同的概念。 通过函数拆解成互相连接的多个步骤，有点链式操作的感觉。、
 * 作用：对JAVA集合（Collection）对象功能的增强，方便对集合进行各类操作（过滤、求最大值、最小值、统计等）；
 * 更加高效，提供串行和并行两种模式，并行模式利用了Java中的fork/join框架技术，能充分利用多核处理器，提高程序并发性；
 * 特性：不是一个数据结构， 为lambda表达式设计， 不支持索引访问， 很方便的作为数组或集合输出， 支持惰性访问， 并行计算
 * 重点操作： filter 过滤  map 改变  sort 排序
 * 获取方法：如何得到Stream对象
 *      从 Collection 和数组
 *          Collection.stream()
 *          Collection.parallelStream()
 *          Arrays.stream(T array) or Stream.of()
 *      从 BufferedReader
 *          java.io.BufferedReader.lines()
 *       静态工厂
 *      java.util.stream.IntStream.range()
 *      java.nio.file.Files.walk()
 * 自己创建
 * java.util.Spliterator
 * 其它
 * Random.ints()
 * BitSet.stream()
 * Pattern.splitAsStream(java.lang.CharSequence)
 * JarFile.stream()
 * Stream有两种类型的操作：Intermediate操作和Terminal操作。
 * Intermediate（中间操作）
 * Stream可以进行多次的Intermediate操作，如前面开头的那个例子，其中filter、map、sorted都是Intermediate操作，注意该操作是惰性化的，当调用到该方法的时候，并没有真正开始Stream的遍历。
 * Terminal（结束操作）
 * 一个Stream只有一个Terminal操作，如前面开头的那个例子，其中forEach就是Terminal操作，Terminal操作是Stream的最后一个操作，这时候才会开始Stream的遍历。
 */
public class StreamLearn {
    
    //  操作示例
    @Test
    public  void optest() {
        List<String> myList = Arrays.asList("a1", "a2", "b1", "c2", "c1");
        myList
                .stream()
                .filter(s -> s.startsWith("c"))       //过滤以c字母开头
                .map(String::toUpperCase)        //字符变成大写
                .sorted()                                     //排序
                .forEach(System.out::println);    //打印输出
    }

    // 下面演示多种创建实例方法
    //  使用Stream.of 创建
    public void StreamofCreate() {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        stream.forEach(p -> System.out.println(p));
    }

    // 使用Arrays.stream
    public void ArraysStreamCreate() {
        Stream<Integer> stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        stream.forEach(p -> System.out.println(p));
    }

    // 使用Collection.stream() or Collection.parallelStream()
    public void CollectionStreamCreate() {
        List<Integer> list =
                new ArrayList<Integer>(Arrays.asList(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9}));
        Stream<Integer> stream = list.stream();    //or list.parallelStream();
        stream.forEach(p -> System.out.println(p));
    }

    // 使用IntStream.range
    public void IntStreamCreate() {
        IntStream stream = IntStream.range(1, 9);
        stream.forEach(p -> System.out.println(p));
    }

    // 使用Random.ints()
    public void RadomCreate() {
        IntStream stream = new Random().ints(1, 10);
        stream.forEach(p -> System.out.println(p));
    }

    // 使用Stream.generate()
    static int i = 1;

    public void generateCreate() {
        Stream<Integer> stream = Stream.generate(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return i++;
        });
        stream.forEach(p -> System.out.println(p));
    }

    //   Stream类型转集合/数组类型     集合转stream/ stream 转集合
        //使用stream.collect(Collectors.toList())
        public void streamConvert() {
            List<Integer> list =
                    new ArrayList<Integer>(Arrays.asList(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9}));
            Stream<Integer> stream = list.stream();
            List<Integer> evenNumbersList = stream.filter(i -> i % 2 == 0).collect(Collectors.toList());
            System.out.print(evenNumbersList);
        }

        // 使用stream.toArray(EntryType[]::new)
        public void toArrayConvert() {
            List<Integer> list =
                    new ArrayList<Integer>(Arrays.asList(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9}));
            Stream<Integer> stream = list.stream();
            Integer[] evenNumbersArr = stream.filter(i -> i % 2 == 0).toArray(Integer[]::new);
            System.out.print(Arrays.asList(evenNumbersArr));
        }

    // 下面是核心用法
    // Stream核心操作方法
    //  Intermediate（中间操作），这里只列出常见的几个
    // filter  filter方法，过滤元素
    public void filterFun()
    {
        List<String> list = new ArrayList<String>(Arrays.asList(new String[]{
                "Amitabh", "Shekhar", "Aman", "Rahul",
                "Shahrukh", "Salman", "Yana", "Lokesh"}));
        Stream<String> stream = list.stream();
        stream.filter((s) -> s.startsWith("A")).forEach(System.out::println);
    }

    // map 方法  修改元素
    public void mapFun() {
        List<String> list = new ArrayList<String>(Arrays.asList(new String[]{
                "Amitabh", "Shekhar", "Aman", "Rahul",
                "Shahrukh", "Salman", "Yana", "Lokesh"}));
        Stream<String> stream = list.stream();
        stream.filter((s) -> s.startsWith("A")).map(String::toUpperCase).forEach(System.out::println);
    }

    // sorted方法，排序，可以传入自定义排序接口Comparator，
    public void sortFun() {
        List<String> list = new ArrayList<String>(Arrays.asList(new String[]{
                "Amitabh", "Shekhar", "Aman", "Rahul",
                "Shahrukh", "Salman", "Yana", "Lokesh"}));
        Stream<String> stream = list.stream();
        stream.sorted().map(String::toUpperCase).forEach(System.out::println);
    }

    // Terminal 方法
 /*    这里的例与前面的类似，就不写出全部代码了，列出重要部分。
    forEach方法，迭代元素，并执行相关操作
        stream.sorted().map(String::toUpperCase).forEach(System.out::println);
    collect方法，从Stream中得到集合
        List<String> memNamesInUppercase = stream.sorted().map(String::toUpperCase).collect(Collectors.toList());
            System.out.print(memNamesInUppercase);
    Match方法，匹配判断Stream中的元素是否符合指定规则
        boolean matchedResult = list.stream().anyMatch((s) -> s.startsWith("A"));
            System.out.println(matchedResult);
        matchedResult = list.stream().allMatch((s) -> s.startsWith("A"));
            System.out.println(matchedResult);
        matchedResult = list.stream().noneMatch((s) -> s.startsWith("A"));
            System.out.println(matchedResult);
    count方法，计数
        long totalMatched = list.stream().filter((s) -> s.startsWith("A")).count();
            System.out.println(totalMatched);
   */
    // reduce方法，元素组合操作，常用于字符串拼接、数值的 sum、min、max、average
    public void reduceFun() {
        List<String> list = new ArrayList<String>(Arrays.asList(new String[]{
                "Amitabh", "Shekhar", "Aman", "Rahul",
                "Shahrukh", "Salman", "Yana", "Lokesh"}));
        Optional<String> reduced = list.stream().reduce((s1, s2) -> s1 + "#" + s2);
        reduced.ifPresent(System.out::println);
        //打印结果：Amitabh#Shekhar#Aman#Rahul#Shahrukh#Salman#Yana#Lokesh
    }

    /*    Stream短路操作
        所谓的短路操作。指的是如果符合要求的话，就不继续执行接下来的操作，类似于&&和||操作，
        在Stream中，类似的有anyMatch()和findFirst()方法，*/
    /*
        anyMatch()，返回布尔值，只要找到一个匹配的元素，就停止接下来的元素遍历；
            boolean matched = list.stream().anyMatch((s) -> s.startsWith("A"));
                System.out.println(matched);
            // Output: true
        findFirst()，返回元素，同样，只返回第一个元素，不会全部遍历；
            String firstMatchedName = list.stream().filter((s) -> s.startsWith("L")).findFirst().get();
                System.out.println(firstMatchedName);
            // Output: Lokesh*/
    //  并发parallelStream
    //   Java 7引入了Fork/Join并行计算框架，能让我们以并行方式来拆分任务和加速处理过程。
// 通常编写并行代码很难而且容易出错, 但使用 Stream API 无需编写一行多线程的代码，就可以很方便地写出高性能的并发程序。
    public void parallelFun() {
        List<Integer> list =
                new ArrayList<Integer>(Arrays.asList(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9}));
        // Here creating a parallel stream
        Stream<Integer> stream = list.parallelStream();
        Integer[] evenNumbersArr = stream.filter(i -> i % 2 == 0).toArray(Integer[]::new);
        System.out.print(Arrays.asList(evenNumbersArr));
    }

    //   使用Stream与不用Stream对比
    //   下面给出一个使用Stream与不使用Stream示例，用于统计字符长度为3的字符串个数。
    public void compareFun() {
        List<String> strings = Arrays.asList("abc", "111", "bc", "efg", "12584", "", "1254");
        //使用Java 7, 统计字符长度为3的字符串个数
        long count = 0;
        for (String string : strings) {
            if (string.length() == 3) {
                count++;
            }
        }
        System.out.println("using java7:Strings of length 3: " + count);
        //使用Java 8的stream, 统计字符长度为3的字符串个数
        count = strings.stream().filter(string -> string.length() == 3).count();
        System.out.println("using java8:Strings of length 3: " + count);
    }

}
