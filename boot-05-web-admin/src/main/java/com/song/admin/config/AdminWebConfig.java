package com.song.admin.config;

import com.song.admin.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Description: 自定义拦截器：
 *          1、编写一个拦截器实现HandlerInterceptor接口;
 *          2、在Spring容器中注册这个拦截器（实现WebMvcConfigurerAdapter的addInterceptors方法）;
 *          3、指定拦截规则【注意/**拦截所有，包括静态资源】
 *
 *          定制化 web应用
 *
 * @Create : 2024/2/26 -16:31
 * @Version : v1.0
 */
@EnableWebMvc  // 全面接管SpringMVC：默认的静态资源、视图解析器、欢迎页。。。全部失效
@Configuration
public class AdminWebConfig implements WebMvcConfigurer {
    /**
     *    定义静态资源行为
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        /**
         *  访问 /aa/** 所有请求都去 classpath:/static/ 下进行匹配
         */
        registry.addResourceHandler("/aa/**")
                .addResourceLocations("classpath:/static/");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
       registry.addInterceptor(new LoginInterceptor())
               .addPathPatterns("/**")                // 添加拦截路径，/**表示拦截所有请求,包括静态资源
               .excludePathPatterns("/", "/login","/css/**","/fonts/**", "/images/**", "/js/**", "/aa/**" );   // 添加放行的请求
    }
/*    @Bean
    public WebMvcRegistrations webMvcConfigurer() {
        return new WebMvcRegistrations() {
            @Override
            public RequestMappingHandlerMapping getRequestMappingHandlerMapping() {
                return null;
            }
        };
    }*/

}
