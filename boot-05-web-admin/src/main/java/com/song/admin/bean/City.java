package com.song.admin.bean;

import lombok.Data;

/**
 * Description:  mybatis纯注解方式学习：封装测试表city
 *
 * @Create : 2024/3/22 -10:13
 * @Version : v1.0
 */
@Data
public class City {

    private Long id;
    private String name;
    private String state;
    private String country;
}
