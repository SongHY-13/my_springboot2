package com.song.admin.servlet;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Description:
 *
 * @Create : 2024/3/11 -17:07
 * @Version : v1.0
 */

@Slf4j
//@WebListener
public class MyServletContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info("MyServletContextListener 监听到项目初始化完成");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
       log.info("MyServletContextListener 监听到项目销毁");
    }
}
