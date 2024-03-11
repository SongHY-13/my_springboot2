package com.song.admin.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Description: web开发第九部分：原生组件注入： servlet
 *
 * @Create : 2024/3/7 -16:24
 * @Version : v1.0
 */

//@WebServlet(urlPatterns = "/my")
public class MyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().write("需要在配置类上添加@ServletComponentScan，设置扫描servlet所在包");
    }
}
