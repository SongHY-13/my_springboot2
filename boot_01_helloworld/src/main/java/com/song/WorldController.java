package com.song;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * ClassName:WorldController
 * Package:com.song
 * Description:  测试spring默认扫描机制（无需自己配置）：默认只扫描主程序所在包和其子包内
 * @Author: songhuayu
 * @Create: 2023/12/22 -11:23
 * @Version: v1.0
 */

@RestController
public class WorldController {
    @RequestMapping("/w")
    public  String world66(){
        return "World";
    }
}
