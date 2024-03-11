package com.song.boot.controller;

import com.song.boot.bean.Person;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Package:com.song.boot.controller
 * Description:
 *          1、测试web请求中通过注解添加参数：
 *              @PathVariable（从路径中获取变量值）
 *              @RequestHeader（获取请求头）
 *              @RequestParam（获取请求参数）
 *              @CookieValue（获取cookie值）
 *              @RequestBody（获取请求体[仅限POST请求，如表单提交]）
 *              @MatrixVariable （获取矩阵变量）
 *              对于非必传的参数，当其为数据时，最好使用它的包装器类，这样缺省时，可转换为空值使用
 *         2、测试自定义类型参数处理：如Person类型
 *
 * @Author: songhuayu
 * @Create: 2024/1/9 -17:05
 * @Version: v1.0
 */

@RestController
public class ParamTestController {

    // 测试自定义类型参数Person
    // 数据绑定:页面提交的请求数据（GET、POST)都可以和对象属性进行自动的绑定
    // 要求：提交表单的name和对象的属性名一致
    @PostMapping("/saveuser")
    public Person saveUser(Person person){
        return person;
    }

    // 测试注解添加的参数获取
    @GetMapping("/car/{id}/owner/{username}")
    public Map<String,Object> getCar(@PathVariable("id") Integer id,
                                     @PathVariable("username") String username,
                                     //提取所有路径中的参数到pv中
                                     @PathVariable Map<String,String> pv,

                                     @RequestHeader("User-Agent") String userAgent,
                                     // 提取请求的所有请求头
                                     @RequestHeader Map<String,String> headers,

                                     @RequestParam("age") Integer age,
                                     @RequestParam("inters") List<String> inters,
                                     //获取所有请求参数
                                     @RequestParam Map<String,String> params,

                                     @CookieValue("Pycharm-1fb0f292") String cookie1,
                                     @CookieValue("Pycharm-1fb0f292") Cookie cookie){
        Map<String,Object> cars = new HashMap<>();

        cars.put("id", id);
        cars.put("username", username);
        cars.put("pv", pv);

        cars.put("User-Agent", userAgent);
        cars.put("请求头", headers);

        cars.put("age",age);
        cars.put("inters", inters);
        cars.put("params", params);

        cars.put("Pycharm-1fb0f292", cookie1);
        System.out.println(cookie.getName()+"=====>"+cookie.getValue());
        return cars;
    }

    /**
     *
     * @param content  @RequestBody注解从post请求中，获取请求体
     * @return  请求体装载的map
     */
    @PostMapping("/save")
    public Map<String,Object> postMethod(@RequestBody String content){
        Map<String,Object> map = new HashMap<>();
        map.put("请求体", content);
        return map;
    }


    /**
     * 测试web请求中矩阵变量的获取，
     *      1、语法：/cars/sell;low=34;brand=byd,audi,yd
     *      2、SpringBoot默认禁用了矩阵变量的功能
     *          手动开启：原理：SpringBoot使用了默认的org.springframework.web.util.UrlPathHelper规则对路径进行处理
     *           新建规则：方式一： - 利用@Bean在配置类中注册一个实现了WebMvcConfigurer接口的实例
     *                            - 重写configurePathMatch方法：自定义UrlPathHelper规则
     *                    方式二： - 令配置类直接实现WebMvcConfigurer接口
     *                            - 重写configurePathMatch方法：自定义UrlPathHelper规则
     */

//    矩阵变量一定是绑定在路径变量中，sell需要写成变量形式
//    @GetMapping("/cars/sell")   报错404
    @GetMapping("/cars/{path}")
    public Map sellCars(@MatrixVariable("low") Integer low,
                        @MatrixVariable("brand") List<String> brand,
                        @PathVariable("path") String path){
        Map<String,Object> map = new HashMap<>();
        map.put("low",low);
        map.put("brand",brand);
        map.put("真正的访问路径",path);
        return map;
    }

    // 对于请求 "/boss/1;age=20/2;age=10" :两个路径变量，且两个矩阵变量名相同
    @GetMapping("/boss/{bossId}/{empId}")
    public Map boss(@MatrixVariable(value = "age",pathVar = "bossId") Integer bossAge,
                    @MatrixVariable(value = "age",pathVar = "empId") Integer empAge
                    ){
        Map<String,Object> map = new HashMap<>();
        map.put("bossAge",bossAge);
        map.put("empAge",empAge);

//        map.put("矩阵变量",map);
        return map;
    }


}
