package com.song.admin.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Description:  登录检查
 *      1、 配置好拦截器要拦截哪些请求
 *      2、将这些配置放在容器中
 *
 * @Create : 2024/2/26 -16:20
 * @Version : v1.0
 */
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    /**
     * 在请求处理之前执行
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        log.info("preHandle判断拦截的请求路径是：{}", requestURI);

        // 登陆检查逻辑
        HttpSession session = request.getSession();
        if (session.getAttribute("loginUser") != null) {
            // 放行
            return true;
        }
        // 拦截住，未登录时跳转到登录页

/*        session.setAttribute("msg", "请先登录");
        response.sendRedirect( "/");     //重定向方式   */
        request.setAttribute("msg", "请先登录");
        request.getRequestDispatcher("/").forward(request, response);
        return false;
    }

    @Override
    /**
     * 在请求处理之后执行
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("postHandle执行，{}", modelAndView);
    }

    @Override
    /**
     * 页面渲染之后
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("afterCompletion执行，异常：{}", ex);
    }
}
