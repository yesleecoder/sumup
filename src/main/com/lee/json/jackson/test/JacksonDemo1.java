/**
 * Create by Intellij IDEA  2017.2
 * Create by  lee
 * Create at  2018/12/20 16:40
 */
package main.com.lee.json.jackson.test;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.text.ParseException;

/**
 * JSON转Java类[JSON反序列化]
 */
public class JacksonDemo1 {
    public static void main(String[] args) throws ParseException, IOException {
        String json = "{\"name\":\"zhangsan\",\"age\":20,\"birthday\":844099200000,\"email\":\"zhangsan@163.com\"}";
        /**
         * ObjectMapper支持从byte[]、File、InputStream、字符串等数据的JSON反序列化。
         */
        ObjectMapper mapper = new ObjectMapper();
        User user = mapper.readValue(json, User.class);
        System.out.println(user);
    }
}
