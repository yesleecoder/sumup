/**
 * Create by Intellij IDEA  2017.2
 * Create by  lee
 * Create at  2018/12/14 17:27
 */
package main.com.lee.encode;

import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class EncodeTest {


    public static void main(String[] args) {
        // 查看所有jvm 支持的编码　　　JVM有自己所支持的编码种类
        Map m = Charset.availableCharsets();
        Set names = m.keySet();
        Iterator it = names.iterator();
        while(it.hasNext())
        {
            System.out.println(it.next());
        }
      //  获取所有的　　　目前JVM所使用的编码
        Properties pps = System.getProperties();
        pps.list(System.out);
    }
}
