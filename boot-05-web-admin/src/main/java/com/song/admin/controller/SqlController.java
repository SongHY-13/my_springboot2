package com.song.admin.controller;

import com.song.admin.bean.Bank;
import com.song.admin.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Description:   1、测试 druid 监控数据库功能
 *
 *               2、测试mybatis操作atguigu数据库t_bank表：
 *                  Controller调用Service层，Service层调用Mapper层，Mapper层操作数据库
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
