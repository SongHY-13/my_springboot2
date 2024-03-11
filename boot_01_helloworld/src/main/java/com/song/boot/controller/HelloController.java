package com.song.boot.controller;

import com.song.boot.bean.Car;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*
 * ClassName:HelloController
 * Package:com.song.boot.controller
 * Description:
 * @Author: songhuayu
 * @Create: 2023/12/20 -17:07
 * @Version: v1.0
 */

/*
    @RestController效果等价于@ResponseBody + @Controller
*/

@Slf4j  // lombok简化日志开发：结合log.info等使用;
@RestController
public class HelloController {

    @Autowired
    Car car;

    @RequestMapping("/micar")
    public Car car(){
        return car;
    }


//    @ResponseBody： 方法返回的是字符串
    @RequestMapping("/hello")
    public String handle01(@RequestParam("name") String name){
        //2023-12-29 09:43:04.168  INFO 13048 --- [nio-8888-exec-3] c.song.boot.controller.HelloController   : 请求进来了
        log.info("请求进来了");
        return "Hello,"+ name+"，加速学习spring boot 2!";
    }
}

