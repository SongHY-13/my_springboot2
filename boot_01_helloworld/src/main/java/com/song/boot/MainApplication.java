package com.song.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/*
 * ClassName:MainApplication
 * Package:com.song.boot
 * Description:
 * @Author: songhuayu
 * @Create: 2023/12/20 -17:05
 * @Version: v1.0
 */

/**
 * 主程序类；主配置类
 *  -@SpringBootApplication ：声明为SpringBoot应用，默认扫描主程序所在包和其子包
 *     可替换为这三个注解:
 *       -@SpringBootConfiguration
 *       -@EnableAutoConfiguration
 *       -@ComponentScan("com.song")  指定扫描路径
 */

@SpringBootApplication(scanBasePackages = {"com.song"})  // 扫描指定包下面的类
public class MainApplication {
    public static void main(String[] args) {
        //1、返回IOC容器
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);

        //2、 查看容器中的组件: 可以看到spring-boot-starter-web引入的各个组件，包括mvc等等
        String[] names = run.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
        int beanDefinitionCount = run.getBeanDefinitionCount();
        System.out.println("容器中组件组件数量："+ beanDefinitionCount);
/*        // 查看自动配置机制的按需装配结果
        String[] names = run.getBeanNamesForType(CacheAspectSupport.class);
        System.out.println("容器中CacheAspectSupport类型组件的数量："+ names.length);

        String[] names1 = run.getBeanNamesForType(WebMvcProperties.class);
        System.out.println("容器中WebMvcProperties类型组件的数量："+ names1.length);*/

/*        //3、验证：从spring容器中获取组件，且为单实例
        Pet boluo1 = run.getBean("boluo", Pet.class);
        Pet boluo2 = run.getBean("boluo", Pet.class);
        System.out.println("组件单实例：" + (boluo1 == boluo2));

        //4、 配置类也是组件，详解@Configuration(proxyBeanMethods = true)代理对象调用方法。
        // 为true时，SpringBoot总会检查这个组件是否在容器中有，保持组件单实例
        MyConfig01 myc = run.getBean(MyConfig01.class);
        System.out.println(myc); //com.song.boot.config.MyConfig01$$EnhancerBySpringCGLIB$$8f707107@4a325eb9

        // 测试调用注释了@Bean注解的方法，看看是从容器里取还是新建实例
        User user1 = myConfig01.user01();
        User user2 = myConfig01.user01();
        System.out.println("调用配置类中注册组件的方法得到单实例对象：" + (user1 == user2));
        
        //测试组件依赖
        User user01 = run.getBean("user01", User.class);
        Pet 菠萝 =  run.getBean("boluo", Pet.class);

        System.out.println("user组件依赖pet:"+(user01.getPet() == 菠萝));

        //5、 查看@Import导入组件效果，含有同类型组件时
        String[] beanNames = run.getBeanNamesForType(User.class);
        System.out.println("===========");
        for (String s:beanNames) {
            System.out.println(s);
        }
        System.out.println(run.getBean(DBHelper.class));*/

 /*       // 6、测试条件装配：容器中存在名为boluo的组件时，注解所在配置类中配置才生效（一定是先判断，再执行内部）
        System.out.println("容器中boluo組件:" + run.containsBean("boluo"));
        System.out.println("容器中user01組件：" + run.containsBean("user01"));
        System.out.println("容器中组件boluo22："+ run.containsBean("boluo22"));*/

/*        // 7、 测试@ImportResource 导入xml配置文件，在任意配置类上写入一次
        System.out.println("容器中组件haha："+ run.containsBean("haha"));
        System.out.println("容器中组件hehe："+ run.containsBean("hehe"));*/
    }
}
