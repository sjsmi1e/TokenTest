package com.smile.TokenTest;

import com.smile.util.JwtHelper;
import org.junit.Test;
import org.springframework.aop.scope.ScopedProxyUtils;

import java.util.HashMap;

import static java.lang.Thread.sleep;

/**
 * Created by smi1e
 * Date 2019/7/15 11:06
 * Description
 */
public class JwtTest {
    @Test
    public void test1() throws InterruptedException {
//        String token = JwtHelper.generateToken("123", 1);
//        System.out.println(token);
//        System.out.println(JwtHelper.verifyJwt(token).toString());
        HashMap<String,Object> map = new HashMap<>();
        map.put("userName","tony");
        map.put("userId","201606060425");
        String token = JwtHelper.createJWT(map, 10*1000L);
        System.out.println(JwtHelper.verifyJwt(token));
        sleep(10000);
        System.out.println(JwtHelper.verifyJwt(token));
    }
}
