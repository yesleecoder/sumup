/**
 * Create by Intellij IDEA  2017.2
 * Create by  lee
 * Create at  2018/12/20 14:47
 */
package main.com.lee.json.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import org.junit.Test;

import java.util.*;


public class FastJsonDemo {

    /**
     * String转化为实体类User
     */
     @Test
    public void StrToObject() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append("\"id\": 1L,");
        sb.append(" \"name\": \"lee\"");
        sb.append("}");
        System.out.println(sb);
        User user = JSON.parseObject(sb.toString(), User.class);
        System.out.println(user.toString());
    }

    /**
     * String转化为jsonObject
     */
    @Test
    public void StrToJsonObject() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append("\"id\": 1L,");
        sb.append(" \"name\": \"lee\"");
        sb.append("}");
        JSONObject jsonObj = JSON.parseObject(sb.toString());

        for(Map.Entry<String, Object> entry : jsonObj.entrySet()){
            System.out.println(entry.getKey()+"--"+entry.getValue());
        }
    }


    /**
     * 实体类转换为json
     * 多个实体类转换为json数组形式的string
     * String转化为List<User>
     */
    @Test
    public void StrToListObject() {
        List<User> userList =  new ArrayList<>();
        User user1 = new User(1L,"song");
        System.out.println(user1);

        User user2 = new User(2L,"lee");

        userList.add(user1);
        userList.add(user2);
        //实体类转换为json
        String user1Str = JSON.toJSONString(user1);
        //多个实体类转换为json数组形式的string
        String userStr = JSON.toJSONString(userList);
        //String转化为List<User>
        List<User> userList3 = JSON.parseArray(userStr,User.class);
        System.out.println(user1Str);
        System.out.println(userStr);
        System.out.println(userList3);
    }


    /**
     * String转化为数组
     * String转化为ArrayList
     */
    @Test
    public void StrToArrayList() {
        StringBuilder sb = new StringBuilder();
        sb.append("[{");
        sb.append("\"id\": 1L,");
        sb.append(" \"name\": \"lee\"");
        sb.append("}]");
        System.out.println(sb);
        // String转化为数组
        User[] arrUser = JSON.parseObject(sb.toString(),new TypeReference<User[]>(){});
        List<User> list = Arrays.asList(arrUser);
        for (int i = 0; i < arrUser.length; i++) {
            System.out.println(arrUser[i].toString());
        }
        // String转化为ArrayList
        ArrayList<User> userList=  JSON.parseObject(sb.toString(),new TypeReference<ArrayList<User>>(){});

        for(User user : userList){
            System.out.println(user.toString());
        }
    }

    /**
     * map和json互相转换
     */
    @Test
    @SuppressWarnings("unused")
    public void mapTo(){
        Map<String,Object> map = new HashMap<>();
        map.put("id", 1L);
        map.put("name", "lee");

        //map转换为json
        String json = JSON.toJSONString(map);
        System.out.println(json);
        //json转换为map
        Map map1 = JSON.parseObject(json);
        Map<String,String> map2 = (Map<String,String>)JSON.parse(json);
        System.out.println(map1);
        System.out.println(map2);

    }

}
