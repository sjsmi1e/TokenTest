package com.smile.filter;

import com.smile.util.JwtHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by smi1e
 * Date 2019/7/15 11:44
 * Description
 */
//@CrossOrigin(origins = "*",maxAge = 3600)
public class TokenFilter implements Filter {
    private Logger logger = LoggerFactory.getLogger(TokenFilter.class);
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("启动过滤器。。。");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        logger.info("开始过滤");
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        String token = httpServletRequest.getParameter("token");
        logger.info(token);
        if (token!=null && JwtHelper.verifyJwt(token)!=null){
            logger.info("token有效");
            filterChain.doFilter(httpServletRequest,httpServletResponse);
        }
        else {
            httpServletResponse.setContentType("application/json; charset=utf-8");
            httpServletResponse.getWriter().print("{\"error\":\"token无效\"}");
//            httpServletRequest.getRequestDispatcher("/errorMsg").forward(httpServletRequest, httpServletResponse);
        }
    }

    @Override
    public void destroy() {
        logger.info("销毁过滤器！");
    }
}
