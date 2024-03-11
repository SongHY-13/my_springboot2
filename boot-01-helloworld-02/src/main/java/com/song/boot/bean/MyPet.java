package com.song.boot.bean;

import lombok.Data;

/**
 * ClassName:MyPet
 * Package:com.song.boot.bean
 * Description:
 *
 * @Author: songhuayu
 * @Create: 2024/1/3 -10:03
 * @Version: v1.0
 */
//@ConfigurationProperties(prefix = "mypet")
//@Component
@Data
public class MyPet {
    private String name;
    private Double weight;
}
