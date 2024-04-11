package com.song.admin.controller;

import com.song.admin.bean.Bank;
import com.song.admin.bean.City;
import com.song.admin.service.BankService;
import com.song.admin.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Description:   1、测试 druid 监控数据库功能
 *
 *               2、测试mybatis操作atguigu数据库t_bank表：
 *                  Controller调用Service层，Service层调用Mapper层，Mapper层操作数据库
 *
*                3、使用纯注解方式测试操作city表：
 *                      @Select替代XXXMapper.xml文件操作数据库;
 *               4、 混合方式：
 *                      注解+xml文件（对于复杂的实现方法sql语句），互不影响
 *
 * @Create : 2024/3/20 -14:24
 * @Version : v1.0
 */

@Controller
public class SqlController {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    BankService bankService;

    @Autowired
    CityService cityService;
    @ResponseBody
    @PostMapping("/city")    // 表单提交，使用postman测试
    public City saveCity(@RequestBody City city){

        cityService.saveCity(city);

        return city;
    }

    @ResponseBody
    @GetMapping("/city")
    public City city(@RequestParam("id") Long id){

        return cityService.findById(id);
    }


    @ResponseBody
    @GetMapping("/bank")
    public Bank getById(@RequestParam("id") Integer id){

        return bankService.getBankById(id);
    }


    @ResponseBody
    @GetMapping(value = "/sql")
    public String sql() {
        Long l = jdbcTemplate.queryForObject("select count(*) from t_user", Long.class);
        return l.toString();
    }
}
