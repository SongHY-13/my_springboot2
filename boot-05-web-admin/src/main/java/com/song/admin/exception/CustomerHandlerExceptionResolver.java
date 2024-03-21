package com.song.admin.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Description:  通过实现HandlerExceptionResolver接口，自定义异常处理器（需要注册到容器中生效）
 *
 * @Create : 2024/3/7 -14:58
 * @Version : v1.0
 */

//@Order(Ordered.HIGHEST_PRECEDENCE)   // 设置优先级（数字越小优先级越高） ，为了让自定义的异常处理齐先执行
//@Component
public class CustomerHandlerExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

        try {
            response.sendError(511,"我想要自己处理的错误");
        } catch (IOException e) {
           e.printStackTrace();
        }

        return new ModelAndView();
    }
}
