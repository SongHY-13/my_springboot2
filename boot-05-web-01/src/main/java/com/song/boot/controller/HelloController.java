package com.song.boot.controller;

import org.springframework.web.bind.annotation.*;

/**
 * ClassName:HelloController
 * Package:com.song.boot.controller
 * Description:     使用REST风格的请求
 *
 * @Author: songhuayu
 * @Create: 2024/1/3 -17:02
 * @Version: v1.0
 */
@RestController
public class HelloController {
    @RequestMapping("南瓜.png")
    public String hello(){
        return "abcdef我";
    }


//    @RequestMapping(value = "/user",method = RequestMethod.GET)
    @GetMapping("/user")
    public String getUser(){
        return "GET-张三";
    }

//    @RequestMapping(value = "/user",method = RequestMethod.POST)
    @PostMapping("/user")
    public String saveUser(){
        return "POST-张三";
    }


//    @RequestMapping(value = "/user",method = RequestMethod.PUT)
    @PutMapping("/user")
    public String putUser(){

        return "PUT-张三";
    }

    @DeleteMapping("/user")
//    @RequestMapping(value = "/user",method = RequestMethod.DELETE)
    public String deleteUser(){
        return "DELETE-张三";
    }
}
