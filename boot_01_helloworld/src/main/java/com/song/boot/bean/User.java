package com.song.boot.bean;

import lombok.*;

/**
 * ClassName:User
 * Package:com.song.boot.bean
 * Description:
 *
 * @Author: songhuayu
 * @Create: 2023/12/22 -15:17
 * @Version: v1.0
 */
@NoArgsConstructor
@ToString
@Data
@EqualsAndHashCode
//@AllArgsConstructor
public class User {

    private String name;
    private Integer age;

    private Pet pet;

    public User(String name,Integer age){
        this.name = name;
        this.age = age;
    }
}
