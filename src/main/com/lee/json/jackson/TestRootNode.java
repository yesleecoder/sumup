/**
 * Create by Intellij IDEA  2017.2
 * Create by  lee
 * Create at  2018/12/20 16:25
 */
package main.com.lee.json.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.Test;

public class TestRootNode {

    @Test
    public void testRootNode() throws JsonProcessingException {
        JsonCaseB caseb = new JsonCaseB();

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);

        caseb.setAge(123);
        caseb.setSex("Boy");

        String jsonStr = mapper.writeValueAsString(caseb);

        System.out.println("JSON:" + jsonStr);
    }
}
