package com.song.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Description: 提取公共页面章节学习；
 *              错误处理学习
 *
 *
 * @Create : 2024/2/22 -16:05
 * @Version : v1.0
 */
@Controller
public class TableController {
    /**
     *
     * @param a  不带请求参数或参数类型不对时：出现异常
     * @return
     */
    @GetMapping("/basic_table")
    public String basic_table(@RequestParam("a") int a){
        int i = 10/0;

        return "table/basic_table";
    }

    @GetMapping("/dynamic_table")
    public String dynamic_table(Model model){
        // 表格内容的遍历
/*        List<User> users = Arrays.asList(new User("zhangsan", "123456"),
                new User("lisi", "123444"),
                new User("haha", "aaaaa"),
                new User("hehe", "aaddd"));
        model.addAttribute("users", users);

        if(users.size()>3) throw new UserTooManyException(); 抛出自定义异常，测试mybatis时注释掉*/

        // 从数据库中查询出user表中的数据

        return "table/dynamic_table";
    }

    @GetMapping("/responsive_table")
    public String responsive_table(){

        return "table/responsive_table";
    }

    @GetMapping("/editable_table")
    public String editable_table(){

        return "table/editable_table";
    }
}
