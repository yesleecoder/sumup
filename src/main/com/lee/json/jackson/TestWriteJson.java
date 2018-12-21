/**
 * Create by Intellij IDEA  2017.2
 * Create by  lee
 * Create at  2018/12/20 16:21
 */
package main.com.lee.json.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

public class TestWriteJson {
    @Test
    public void writeJson() throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();

        JSONCaseA case1 = new JSONCaseA();
        case1.setCity("BeiJing");

        case1.setUnknownAttr("testVal");
        case1.setAge(123);

        String jsonStr = mapper.writeValueAsString(case1);

        System.out.println("JSON:" + jsonStr);
    }

}
