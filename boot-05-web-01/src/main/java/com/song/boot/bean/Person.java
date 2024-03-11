package com.song.boot.bean;

import lombok.Data;

import java.util.Date;

/**
 * Package:com.song.boot.bean
 * Description:
 *        姓名： <input name="userName" value="zhangsan"/>
 *        年龄： <input name="age" value="18"/>
 *        生日： <input name="birth" value="2019/12/10"/>
 *        宠物姓名：<input name="pet.name" value="阿猫"/>
 *        宠物年龄：<input name="pet.age" value="5"/>
 *        宠物： <input name="pet" value="啊猫,3"/>
 *
 * @Author: songhuayu
 * @Create: 2024/1/26 -17:09
 * @Version: v1.0
 */

@Data
public class Person {
    private String userName;
    private Integer age;
    private Date birth;
    private Pet pet;
}
