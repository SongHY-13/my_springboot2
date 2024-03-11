package com.song.boot.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * ClassName:Person
 * Package:com.song.boot.bean
 * Description:
 *
 * @Author: songhuayu
 * @Create: 2024/1/3 -10:01
 * @Version: v1.0
 */
@ConfigurationProperties(prefix = "person")
@Component
@Data
public class Person {
    private String userName;
    private Boolean boss;
    private Date birth;
    private Integer age;
    private MyPet pet;
    private String[] interests;
    private List<String> animal;
    private Map<String, Object> score;
    private Set<Double> salarys;
    private Map<String, List<MyPet>> allPets;

}
