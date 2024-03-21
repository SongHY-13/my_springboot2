package com.song.admin.servlet;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * Description:  注册原生Servlet组件：1、原生注解注册；MyServlet、MyFilter、MyServletContextListener
 *                                 2、Spring方式：配置类 + @Bean + RegistrationBean注册
 *
 * @Create : 2024/3/11 -17:37
 * @Version : v1.0
 */

@Configuration
public class MyRegistConfig {
    @Bean
    public ServletRegistrationBean myServlet() {

        return new ServletRegistrationBean(new MyServlet(), "/my", "/mmp");
    }

    @Bean
    public FilterRegistrationBean myFilter() {

//        return new FilterRegistrationBean(new MyFilter(), myServlet());

        // 也可以直接配置urlPatterns
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new MyFilter());
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/my", "/css/*"));
        return filterRegistrationBean;
    }
    @Bean
    public ServletListenerRegistrationBean myListener() {
        MyServletContextListener myServletContextListener = new MyServletContextListener();

        return new ServletListenerRegistrationBean(myServletContextListener);

    }

}
