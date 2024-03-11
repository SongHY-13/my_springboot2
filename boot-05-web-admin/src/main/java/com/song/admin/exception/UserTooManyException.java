package com.song.admin.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Description: 自定义异常 + @ResponseStatus 自定义异常处理逻辑
 *                底层由 ResponseStatusExceptionResolver 支持
 * @Create : 2024/3/7 -10:43
 * @Version : v1.0
 */
@ResponseStatus(value= HttpStatus.FORBIDDEN, reason = "用户数量过多")  // 表示该异常可以返回一个状态码信息
public class UserTooManyException extends RuntimeException{

    public UserTooManyException(){
        super();
    }

    public UserTooManyException(String massage){
        super(massage);
    }
}
