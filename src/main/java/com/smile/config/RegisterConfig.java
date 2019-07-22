package com.smile.config;

import com.smile.filter.TokenFilter;
import org.apache.catalina.filters.CorsFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;


/**
 * Created by smi1e
 * Date 2019/7/15 12:00
 * Description
 */
@Configuration
public class RegisterConfig {

    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean filterBean = new FilterRegistrationBean();
        filterBean.setFilter(new TokenFilter());
        filterBean.addUrlPatterns("/user/*");
        filterBean.setOrder(2);
        return filterBean;
    }


}
