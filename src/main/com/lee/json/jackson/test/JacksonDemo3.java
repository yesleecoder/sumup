/**
 * Create by Intellij IDEA  2017.2
 * Create by  lee
 * Create at  2018/12/20 16:43
 */
package main.com.lee.json.jackson.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class JacksonDemo3 {

    public static void main(String[] args) throws ParseException, IOException {
        User2 user = new User2();
        user.setName("zhangsan");
        user.setEmail("zhangsan@163.com");
        user.setAge(20);

        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        user.setBirthday(dateformat.parse("1996-10-01"));

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(user);
        System.out.println(json);
    }
}
