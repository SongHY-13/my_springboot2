package com.song.admin.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Description:  处理整个web controller的异常：
 *          - @ControllerAdvice + @ExceptionHandler 处理全局异常
 *
 * @Create : 2024/3/6 -20:37
 * @Version : v1.0
 */

@Slf4j
@ControllerAdvice   // 源代码可知是@Component组合的注解
public class GlobalExceptionHandler {

    @ExceptionHandler({ArithmeticException.class, NullPointerException.class}) // 设置想要处理的异常
    public String handleArithException(Exception e){

        log.error("异常是：{}",e);
        return "login";  // 视图地址；也可选择返回ModelAndView
    }
}


