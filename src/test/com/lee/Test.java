/**
 * Create by Intellij IDEA  2017.2
 * Create by  lee
 * Create at  2018/12/8 14:42
 */
package com.lee;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Map;

/**
 *  http://99shou.cn 秒杀
 */

public class Test {
    @org.junit.Test
    public static void phonecharge(){
        //登录
        String tokenUrl="http://99shou.cn/api/user-server/user/login";
        RestTemplate restTemplate=new RestTemplate();
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        String requestJson = "{\"username\":\"玖玖账户\",\"password\":\"玖玖密码\"}";
        HttpEntity<String> request = new HttpEntity<>(requestJson,httpHeaders);
        ResponseEntity<Map> responseEntity = restTemplate.postForEntity(tokenUrl, request, Map.class);
        Map body = responseEntity.getBody();
        String token="";
        if(body.get("rtnCode").equals("000000")){
            Map rtnData=(Map)body.get("rtnData");
            token = (String) rtnData.get("token");
        }
        httpHeaders.add("channelid","OP0001");
        httpHeaders.add("token",token);
        String txntime=String.valueOf(System.currentTimeMillis());
        httpHeaders.add("txntime",txntime);
        String requestBody="{\"faceValue\":\"50\"}";
        String securitykey="玖玖开发者key";
        String sign=getMD5(requestBody+securitykey+txntime);
        httpHeaders.add("sign",sign);
        //接单
        HttpEntity<String> phonechargeRequest = new HttpEntity<>(requestBody,httpHeaders);
        String phoneChargeUrl="http://99shou.cn/api/phonecharge-server/phonecharge/phone/receive";
        ResponseEntity<Map> phonechargeResponseEntity = restTemplate.postForEntity(phoneChargeUrl, phonechargeRequest, Map.class);
        Map phonechargeResponse = phonechargeResponseEntity.getBody();
        if(!phonechargeResponse.get("rtnCode").equals("000000")){
            System.out.println(phonechargeResponse.get("rtnMsg"));
            phonecharge();
        }
    }


    /**
     * 对字符串md5加密(小写+字母)
     *
     * @param str 传入要加密的字符串
     * @return  MD5加密后的字符串
     */
    public static String getMD5(String str) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes("UTF-8"));
            return new BigInteger(1, md.digest()).toString(16);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
