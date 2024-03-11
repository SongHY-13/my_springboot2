package com.song.boot.config;

import ch.qos.logback.core.db.DBHelper;
import com.song.boot.bean.Car;
import com.song.boot.bean.Pet;
import com.song.boot.bean.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 * ClassName:MyConfig01
 * Package:com.song.boot.config
 * Description:
 *
 * @Author: songhuayu
 * @Create: 2023/12/22 -15:26
 * @Version: v1.0
 */

/**
 * 1、配置类中使用@Bean注解在方法上给容器注册组件，默认也是单实例的
 * 2、配置类本身也是容器中的一个组件
 * 3、spring5.2后新特性@Configuration: proxyBeanMethods 代理bean的方法
 *      Full模式：proxyBeanMethods = true 可用于解决组件依赖问题，
 *      lite模式：proxyBeanMethods = false 可用于提高springBoot的速度（每次调用不检查容器是否存在组件）
 * 4、@Import({User.class, DBHelper.class})
 *      调用无参构造，自动给容器中创建这两个类型的组件；
 *      组件名字为全类名
 */
@Import({User.class, DBHelper.class})
@Configuration(proxyBeanMethods=true)
//@ConditionalOnBean(name = "boluo")   // 放在类上，只有容器中注册了boluo，类中的配置才成立
@ConditionalOnMissingBean(name = "boluo")  //  容器中无boluo时，类内配置才生效
@ImportResource("classpath:beans.xml")
@EnableConfigurationProperties(Car.class)    //两个功能：1、开启Car配置绑定功能 2、把这个Car这个组件自动注册到容器中
public class MyConfig01 {

    /**
     * 当proxyBeanMethods = true时，无论外部调用多少次配置类中的这个组件注册方法，
     * 获取的都是之前注册容器中的单实例对象
     * @return  返回值即组件在容器中的实例
     */
//    @ConditionalOnBean(name = "boluo")  // 在方法上，当容器中注册了boluo组件时，才注册user01组件
    @Bean //给容器中添加组件。默认以方法名作为组件id；组件类型即返回类型；返回值即组件在容器中的实例。
    public User user01(){
        User zhangsan = new User("",18);
        // Full模式下，才能成立，user组件依赖了pet组件
        zhangsan.setPet(tomcatPet());
        return zhangsan;
    }

    @Bean("boluo") //也可自定义组件名
    public Pet tomcatPet(){
        return new Pet("tom-cat");
    }
/*
//  在Car类上使用@ConfigurationProperties绑定配置文件属性后，在配置类中注册到容器也会根据配置文件进行属性配置
    @Bean
    public Car car01(){
        return new Car();
    }
*/
}
