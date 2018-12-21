/**
 * Create by Intellij IDEA  2017.2
 * Create by  lee
 * Create at  2018/12/20 14:19
 */
package main.com.lee.json.fastjson;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.util.Collection;

public class User {
    private Long id;
    private String name;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public User(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    public User(){

    }

    @Override
    public String toString() {
      //  return super.toString();
       return ReflectionToStringBuilder.toString(this);
    }
}
