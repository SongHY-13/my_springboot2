package com.song.admin.controller;

import com.song.admin.bean.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

/**
 * Description:
 *
 * @Create : 2024/2/22 -10:41
 * @Version : v1.0
 */
@Slf4j
@Controller
public class IndexController {

    @GetMapping(value={"/", "/login"})   // 访问登录页
    public String loginPage() {
        return "login";
    }


    @PostMapping(value="/login")
    public String main(User user, HttpSession session, Model model){ //也可以写RedirectAttributes
        if(StringUtils.hasLength(user.getUserName()) && "123456".equals(user.getPassword())){
            // 保存登录成功的用户
            session.setAttribute("loginUser", user);

            // 登陆成功,重定向到main.html；  重定向防止表单重复提交
            return "redirect:/main.html";
        }else {
            model.addAttribute("msg", "用户名或密码错误");
             // 回到登陆界面
            return "login";
        }
    }

    /**
     *  发送/main.html请求，到main页面
     *  - 添加判定机制，防止非法访问
     * @return
     */
    @GetMapping("/main.html")
    public String mainPage(HttpSession session,Model model) {

/* 拦截器代替      // 判定是否登录（一般使用拦截器、过滤器机制，此处简易实现）
        Object loginUser = session.getAttribute("loginUser");
        if(loginUser != null){
            return "main";
        }else {
            model.addAttribute("msg", "请先登录");
            // 未登录，返回登录页
            return "login";
        }*/
        log.info("当前方法是：{}","mainPage");

        return "main";
    }

}
