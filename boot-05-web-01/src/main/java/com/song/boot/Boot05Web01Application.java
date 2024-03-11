package com.song.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class Boot05Web01Application {

    public static void main(String[] args) {
        // 启动并返回容器
        ConfigurableApplicationContext run = SpringApplication.run(Boot05Web01Application.class, args);
        // 获取容器中所有的WebMvcConfigurer的组件
        String[] names = run.getBeanNamesForType(WebMvcConfigurer.class);
        for (String name : names){
            System.out.println(name);
        }

//        System.out.println(run.getBean(Person.class));

    }

}
