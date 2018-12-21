/**
 * Create by Intellij IDEA  2017.2
 * Create by  lee
 * Create at  2018/12/20 16:42
 */
package main.com.lee.json.jackson.test;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * JSON序列化和反序列化使用的User类
 */
public class User2 {

    private String name;

    //不JSON序列化年龄属性
    @JsonIgnore
    private Integer age;

    //格式化日期属性
    @JsonFormat(pattern = "yyyy年MM月dd日")
    private Date birthday;

    //序列化email属性为mail
    @JsonProperty("my_email")
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                ", email='" + email + '\'' +
                '}';
    }
}
