package com.song.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Package:com.song.boot.controller
 * Description:
 *          1、测试注解@RequestAttribute，获取request域中保存的属性，给其设置属性是为了在页面转发时保存当前数据
 *          2、测试 Map或Model类型的参数：此时相当于给request域中存放数据，因此可通过注解或request对象获取值
 *          3、HttpServletResponse可用于向浏览器发送数据，比如添加cookie
 * @Author: songhuayu
 * @Create: 2024/1/10 -17:37
 * @Version: v1.0
 */
@Controller
public class RequestController {

    @GetMapping("/testmv")
    public String testMV(Map<String,Object> map, Model model){
        map.put("开工","二月19日");
        model.addAttribute("驾校","报名");
        return "测试一下非跳转请求时，执行完目标方法mv的值:当view有值或参数为model或map时都不为null";
    }

    @GetMapping("/params")
    public String testParams(Map<String,Object> map, Model model,HttpServletRequest request, HttpServletResponse response){
        map.put("复炸","全麦面包好难吃");
        model.addAttribute("modelx","tsl");
        request.setAttribute("Servlet api","解析器ServletRequestMethodArgumentResolver");

        Cookie cookie = new Cookie("c1","v1");
        response.addCookie(cookie);
        return "forward:/success";

    }

    @GetMapping("/goto")   //ServletRequestMethodArgumentResolver可解析HttpServletRequest类型的参数
    public String goToPage(HttpServletRequest request){
        // 设置属性
        request.setAttribute("msg","成功转发");
        request.setAttribute("code",200);
        return "forward:/success";  // 转发到 /success请求，此处仅为测试，实际开发一般跳转到页面处理
    }


    //两种获取request域中保存属性值的方式：1、直接使用注解获取
    //                             2、使用转发的原生request对象获取
    @ResponseBody
    @GetMapping("/success")
    public Map successTo(
                        // 1
                        @RequestAttribute(value = "msg",required = false) String msg,
                        @RequestAttribute(value = "code",required = false) String code,
                        // 通过注解获取Map或Model类型参数保存到request域中的值
                        @RequestAttribute(value = "modelx",required = false) String modelx,
                        @RequestAttribute(value = "复炸",required = false) String test01,
                        // 2
                         HttpServletRequest request){
        Map<String,Object> map = new HashMap<>();

        Object msg1 = request.getAttribute("msg"); //通过原生request对象获取到属性值
        map.put("regGet_msg", msg1);
        map.put("annotation_msg", msg); // 通过注解获取到属性值

        map.put("复炸",test01);
        map.put("annotation_modelx",modelx);
        Object modelx1 = request.getAttribute("modelx");
        map.put("regGet_modelx",modelx1);
        Object sa = request.getAttribute("Servlet api");
        map.put("Servlet api",sa);
        return map;
    }


}
