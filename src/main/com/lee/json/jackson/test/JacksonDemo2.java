/**
 * Create by Intellij IDEA  2017.2
 * Create by  lee
 * Create at  2018/12/20 16:41
 */
package main.com.lee.json.jackson.test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public class JacksonDemo2 {
    public static ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) throws ParseException, IOException {
        String json = "[{\"name\":\"zhangsan\",\"age\":20,\"birthday\":844099200000,\"email\":\"zhangsan@163.com\"}]";
        List<User> beanList = mapper.readValue(json, new TypeReference<List<User>>() {});
     //   List<User> beanList = mapper.readValue(json, new TypeReference(){});
        System.out.println(beanList);
    }
}
