package com.smile.controller;

import com.smile.util.JwtHelper;
import org.apache.logging.slf4j.Log4jLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by smi1e
 * Date 2019/7/15 11:36
 * Description
 */
@RestController
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Map login(String userName,String passWord){
        Map<String,Object> res = new HashMap<>();
        if ("smile".equals(userName) && "123".equals(passWord)){
            res.put("token",JwtHelper.generateToken(userName,1));
            return res ;
        }
        res.put("token",null);
        return res;
    }

    @RequestMapping(value = "/errorMsg")
    public String error(){
        return "token不存在！！！";
    }
}
