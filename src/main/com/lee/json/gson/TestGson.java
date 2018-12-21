/**
 * Create by Intellij IDEA  2017.2
 * Create by  lee
 * Create at  2018/12/21 9:39
 */
package main.com.lee.json.gson;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

public class TestGson {

    private Gson gson = new Gson();

    /**
     * 测试main
     */
    public static void main(String[] args) {
        TestGson test = new TestGson();
        test.test9();
    }

    /**
     * json字符串转基本数据类型(String虽不是基本数据类型，但是是值传递，与基本数据类型处理相似)
     */
    public void test1() {
        int i = gson.fromJson("100", int.class); // 100
        double d = gson.fromJson("\"99.99\"", double.class); // 99.99
        boolean b = gson.fromJson("true", boolean.class); // true
        String str = gson.fromJson("String", String.class); // String

        System.out.println(i);
        System.out.println(d);
        System.out.println(b);
        System.out.println(str);
    }

    /**
     * 基本数据类型转json字符串(String虽不是基本数据类型，但是是值传递，与基本数据类型处理相似)
     */
    public void test2() {
        String jsonNumber = gson.toJson(100); // 100
        String jsonBoolean = gson.toJson(false); // false
        String jsonString = gson.toJson("String"); // "String"

        System.out.println(jsonNumber);
        System.out.println(jsonBoolean);
        System.out.println(jsonString);
    }

    /**
     * java对象转json字符串
     */
    public void test3() {
        User user = new User("ZhangSan", 24);
        String jsonObject = gson.toJson(user); // {"name":"ZhangSan","age":24}

        System.out.println(jsonObject);
    }

    /**
     * json字符串转java对象
     */
    public void test4() {
        String jsonString = "{\"name\":\"ZhangSan\",\"age\":24}";
        User user = gson.fromJson(jsonString, User.class);

        System.out.println(user.getName() + " | " + user.getAge() + " | " + user.getEmailAddress());
    }

    /**
     * @SerializedName()的使用_1
     */
    public void test5() {
        User user = new User("ZhangSan", 24, "abc@163.com");
        String jsonObject = gson.toJson(user);

        // User.emailAddress未加'@SerializedName("email_address")'时的转换效果如下：
        // {"name":"ZhangSan","age":24,"emailAddress":"abc@163.com"}

        // User.emailAddress加了'@SerializedName("email_address")'时的转换效果如下：
        // {"name":"ZhangSan","age":24,"email_address":"abc@163.com"}

        System.out.println(jsonObject);
    }

    /**
     * @SerializedName()的使用_2
     */
    public void test6() {
        String json = "{\"name\":\"ZhangSan\",\"age\":24,\"emailAddress\":\"abc_1@example.com\","
+"\"email\":\"abc_2@example.com\",\"email_address\":\"abc_3@example.com\"}";
        User user = gson.fromJson(json, User.class);

        System.out.println(user.emailAddress); // abc_3@example.com

        // 当上面的三个属性(email_address、email、emailAddress)都中出现任意一个时均可以得到正确的结果。
        // 注：当多种情况同时出时，以最后一个出现的值为准。
        // 注：alternate需要2.4版本,本次测试的版本不可使用
    }

    /**
     * json字符串转基本类型数组(String虽不是基本数据类型，但是是值传递，与基本数据类型处理相似)
     */
    public void test7() {
        String jsonArray = "[\"Android\",\"Java\",\"PHP\"]";
        String[] strings = gson.fromJson(jsonArray, String[].class);

        System.out.println(strings[1]);
    }

    /**
     * TypeToken来实现对泛型的支持_1 将String[].class 直接改为 List<String>.class
     * 是行不通的。需要进行泛型擦除。
     */
    public void test8() {
        String jsonArray = "[\"Android\",\"Java\",\"PHP\"]";
        List<String> stringList = gson.fromJson(jsonArray, (new TypeToken<List<String>>() {
        }).getType());

        System.out.println(stringList.get(1));
    }

    /**
     * TypeToken来实现对泛型的支持_2
     */
    @SuppressWarnings("serial")
    public void test9() {
        Result<List<User>> result = new Result<List<User>>();
        result.setCode(200);
        result.setMessage("success");
        result.setData(new ArrayList<User>() {
            {
                for (int i = 0; i < 2; i++) {
                    this.add(new User("ZhangSan" + i, 25 + i, "abc@163.com"));
                }
            }
        });

        // 不使用TypeToken无法将User的内容转换出来
        // fromJson()方法也是一样需要使用TypeToken指定要转换成的java对象类型
        String gsonStr = gson.toJson(result, (new TypeToken<Result<List<User>>>() {}).getType());
        System.out.println(gsonStr);
    }

}
@Data
class User {

    public String name;

    public int age;

    // @SerializedName("email_address") // test5()使用
    // @SerializedName(value="emailAddress",alternate={"email","email_address"})//test6()使用
    public String emailAddress;

    /**
     * 构造函数1
     */
    public User() {
        super();
    }

    /**
     * 构造函数2
     */
    public User(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    /**
     * 构造函数3
     */
    public User(String name, int age, String emailAddress) {
        super();
        this.name = name;
        this.age = age;
        this.emailAddress = emailAddress;
    }

    // getters/setters(略)

}
@Data
class Result<T> {

    public int code;

    public String message;

    public T data;

    /**
     * 构造函数
     */
    public Result() {
        super();
    }

    // getters/setters(略)

}
