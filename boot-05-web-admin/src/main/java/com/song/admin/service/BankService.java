package com.song.admin.service;

import com.song.admin.bean.Bank;
import com.song.admin.mapper.BankMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description: 基于mybatis操作数据库：
 *                      通过Service层调用Mapper层;
 *                      Controller调用 Service层；
 *
 * @Create : 2024/3/21 -11:40
 * @Version : v1.0
 */
@Service
public class BankService {

    @Autowired
    BankMapper bankMapper;
    public Bank getBankById(Integer id) {
        return bankMapper.getBank(id);
    }

}
