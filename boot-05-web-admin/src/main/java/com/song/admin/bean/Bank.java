package com.song.admin.bean;

import lombok.Data;

/**
 * Description: 封装数据库atguigu.t_bank表
 *
 * @Create : 2024/3/21 -11:05
 * @Version : v1.0
 */

@Data
public class Bank {
    private Integer id;
    private String account;
    private Integer money;
}
