package com.song.boot.controller;

import com.song.boot.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName:HiController
 * Package:com.song.boot.controller
 * Description:
 *
 * @Author: songhuayu
 * @Create: 2024/1/3 -10:52
 * @Version: v1.0
 */
@RestController
public class HiController {
    @Autowired
    Person person;

    @RequestMapping("/aPerson")
    public Person aPerson(){
        System.out.println(person.getUserName()); // 测试yml中字符串不加引号，加双引号，加单引号的区别
        return person;
    }
}
