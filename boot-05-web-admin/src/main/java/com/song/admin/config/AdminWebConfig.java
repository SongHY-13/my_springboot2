package com.song.admin.config;

import com.song.admin.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Description: 自定义拦截器：
 *          1、编写一个拦截器实现HandlerInterceptor接口;
 *          2、在Spring容器中注册这个拦截器（实现WebMvcConfigurerAdapter的addInterceptors方法）;
 *          3、指定拦截规则【注意/**拦截所有，包括静态资源】
 *
 * @Create : 2024/2/26 -16:31
 * @Version : v1.0
 */
@Configuration
public class AdminWebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
       registry.addInterceptor(new LoginInterceptor())
               .addPathPatterns("/**")                // 添加拦截路径，/**表示拦截所有请求,包括静态资源
               .excludePathPatterns("/", "/login","/css/**","/fonts/**", "/images/**", "/js/**" );   // 添加放行的请求
    }
}
