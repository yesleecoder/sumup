/**
 * Create by Intellij IDEA  2017.2
 * Create by  lee
 * Create at  2018/12/6 10:38
 */
package com.lee;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class UrlTest {
    @Before
    public void setNum(){
        System.out.println("1");
    }

    @Test
    public  void test() {
        try{
            long begintime = System.currentTimeMillis();

            URL url = new URL("http://www.baidu.com");

            System.out.println("URL 为：" + url.toString());
            System.out.println("协议为：" + url.getProtocol());
            System.out.println("验证信息：" + url.getAuthority());
            System.out.println("文件名及请求参数：" + url.getFile());
            System.out.println("主机名：" + url.getHost());
            System.out.println("路径：" + url.getPath());
            System.out.println("端口：" + url.getPort());
            System.out.println("默认端口：" + url.getDefaultPort());
            System.out.println("请求参数：" + url.getQuery());
            System.out.println("定位位置：" + url.getRef());


            HttpURLConnection urlcon = (HttpURLConnection) url.openConnection();
            urlcon.connect();         //获取连接
            InputStream is = urlcon.getInputStream();
            BufferedReader buffer = new BufferedReader(new InputStreamReader(is));
            StringBuffer bs = new StringBuffer();
            String l = null;
            while ((l = buffer.readLine()) != null) {
                bs.append(l).append("/n");
            }
            System.out.println(bs.toString());

            //System.out.println(" content-encode："+urlcon.getContentEncoding());
            //System.out.println(" content-length："+urlcon.getContentLength());
            //System.out.println(" content-type："+urlcon.getContentType());
            //System.out.println(" date："+urlcon.getDate());

            System.out.println("总共执行时间为：" + (System.currentTimeMillis() - begintime) + "毫秒");
        }catch(IOException e)
        {
            System.out.println(e);
        }

    }

}
