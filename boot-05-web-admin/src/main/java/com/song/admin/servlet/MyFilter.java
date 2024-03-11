package com.song.admin.servlet;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import java.io.IOException;

/**
 * Description:
 *
 * @Create : 2024/3/11 -15:32
 * @Version : v1.0
 */

@Slf4j
//@WebFilter(urlPatterns = {"/css/*", "/images/*"})     // servlet中*表示SpringMVC中的**
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("MyFilter初始化完成");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("MyFilter过滤器开始执行");
        chain.doFilter(request, response);
        log.info("MyFilter过滤器执行完成");

    }
    @Override
    public void destroy() {
       log.info("MyFilter销毁");
    }
}
