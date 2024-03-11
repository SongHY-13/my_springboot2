package com.song.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Description:  测试thymeleaf的页面渲染
 *
 * @Create : 2024/2/21 -20:54
 * @Version : v1.0
 */
@Controller
public class ViewTestController {


    @GetMapping("/atguigu")
    public String atguigu(Model model) {
        // model中的数据会放在请求域中被传递到页面中
        model.addAttribute("msg", "hello 小度");
        model.addAttribute("link", "https://www.baidu.com");
        return "success";  // 跳转页面 不是请求）
    }
}
