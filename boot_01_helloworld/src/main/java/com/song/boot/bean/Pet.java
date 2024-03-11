package com.song.boot.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * ClassName:Pet
 * Package:com.song.boot.bean
 * Description:    lombok注解；
 *                  结合配置类MyConfig1中注册组件；
 *
 * @Author: songhuayu
 * @Create: 2023/12/22 -15:17
 * @Version: v1.0
 */


@ToString
@Data
@NoArgsConstructor     // 编译阶段生成无参构造
@AllArgsConstructor   // 全参构造
public class Pet {
    private String name;

}
