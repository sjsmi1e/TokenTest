package com.smile.controller;

import com.smile.util.JwtHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by smi1e
 * Date 2019/7/15 14:23
 * Description
 */
@RequestMapping("/user")
@Controller
//@CrossOrigin(origins = "*", allowCredentials = "true",maxAge = 3600)
public class UController {

    private Logger logger = LoggerFactory.getLogger(UController.class);

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    @ResponseBody
    public Map index(String token){
        logger.info("index");
        logger.info(JwtHelper.verifyJwt(token).toString());
        return JwtHelper.verifyJwt(token);
    }

}
