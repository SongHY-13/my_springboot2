package com.song.boot.controller;

import com.song.boot.bean.Person;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Package:com.song.boot.controller
 * Description:  响应处理原理:
 *                  // 返回值处理器RequestResponseBodyMethodProcessor，处理方法或类上标注了@ResponseBody的返回值
 *
 * @Author: songhuayu
 * @Create: 2024/2/7 -14:18
 * @Version: v1.0
 */
@Controller
public class ResponseTestController {
    @GetMapping("/hell")
    @ResponseBody  // RequestResponseBodyMethodProcessor--> messageConverter
    public FileSystemResource file(){
        // 文件以该方式返回看看是哪个转换器谁处理的---> ResourceHttpMassageConverter
        return null;
    }

    /**
     *   使用场景：通过内容协商实现一个请求完成三种返回类型
     *      1、浏览器发请求直接返回xml   [application/xml]   jacksonXmlConverter
     *      2、如果是ajax请求，返回json [application/json]   jacksonXmlConverter
     *      3、如果存在一个  硅谷app发送请求，返回自定义协议数据  [application/x-guigu]   xxxxConverter
     *                            设置自定义协议类型为：  属性值1;属性值2;
     *   步骤：
     *      1、添加自定义的MessageConverter进系统底层
     *      2、系统底层统计所有MessageConverter能操作哪些类型
     *      3、客户端内容协商[guigu---->guigu]
     *
     * @return
     */
    @ResponseBody   // 利用返回值处理器中的消息转换器进行处理
    @GetMapping("/test/person")
    public Person getPerson(){
        Person person = new Person();
        person.setAge(10086);
        person.setUserName("YOU");
        person.setBirth(new java.util.Date());
        return person;
    }
}
