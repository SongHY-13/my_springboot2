package com.song.boot.bean;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * ClassName:Car
 * Package:com.song.boot.bean
 * Description:  配置绑定注解；
 *              lombok注解；
 *
 * @Author: songhuayu
 * @Create: 2023/12/22 -15:17
 * @Version: v1.0
 */

@ToString    // 编译阶段生成toString方法
@Data  // lombok插件的注解，将在编译阶段生成属性的get和set方法
//@Component   //只有在容器中的组件，才能使用SpringBoot提供的功能
@ConfigurationProperties(prefix="mycar")
public class Car {
    private String brand;
    private Integer price;

}
