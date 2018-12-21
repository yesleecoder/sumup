/**
 * Create by Intellij IDEA  2017.2
 * Create by  lee
 * Create at  2018/12/20 14:23
 */
package main.com.lee.json.fastjson;

import com.alibaba.fastjson.JSON;

public class FastJsonTest {
    public static void main(String[] args) {
        Group group = new Group();
        group.setId(0L);
        group.setName("admin");

        User guestUser = new User();
        guestUser.setId(2L);
        guestUser.setName("guest");

        User rootUser = new User();
        rootUser.setId(3L);
        rootUser.setName("root");

        group.getUsers().add(guestUser);
        group.getUsers().add(rootUser);

        String jsonString = JSON.toJSONString(group);

        System.out.println(jsonString);

        Group group2 = JSON.parseObject(jsonString, Group.class);

        System.out.println("json:"+group2.getName());
    }
}
