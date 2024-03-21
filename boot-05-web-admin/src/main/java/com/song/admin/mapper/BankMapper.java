package com.song.admin.mapper;

import com.song.admin.bean.Bank;
import org.apache.ibatis.annotations.Mapper;

/**
 * Description:  使用mybatis的 Mapper操作数据库 atguigu.t_bank表，此处是接口
 *                  需要使用@Mapper注解使其被扫描到
 *
 * @Create : 2024/3/21 -11:04
 * @Version : v1.0
 */
@Mapper
public interface BankMapper {

    public Bank getBank(Integer id);

}
