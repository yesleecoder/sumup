/**
 * Create by Intellij IDEA  2017.2
 * Create by  lee
 * Create at  2018/12/20 16:20
 */
package main.com.lee.json.jackson;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class JSONCaseA {

    @JsonProperty("testa")
    private int age;

    @JsonIgnore
    private String unknownAttr;

    private String location;

    private String city;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUnknownAttr() {
        return unknownAttr;
    }

    public void setUnknownAttr(String unknownAttr) {
        this.unknownAttr = unknownAttr;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}

