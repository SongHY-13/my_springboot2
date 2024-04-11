package com.song.admin.mapper;

import com.song.admin.bean.City;
import org.apache.ibatis.annotations.Select;

/**
 * Description:  创建CityMapper接口:
 *                      1、mybatis纯注解方式 @Select将方法和SQL语句映射起来
 *                      2、混合方式，当某个方法实现SQL语句比较复杂时，使用混合方式:
 *                              如创建CityMapper.xml映射文件，在文件中实现insert的SQL语句，
 *                              此时@Select注解映射的findById方法同时也有效；
 *
 * @Create : 2024/3/22 -10:20
 * @Version : v1.0
 */
//@Mapper
public interface CityMapper {
/*    @Insert("INSERT INTO city (name, state, country) VALUES(#{name}, #{state}, #{country})")
    @Options(useGeneratedKeys = true, keyProperty = "id")*/
    void insert(City city);

    // 替代XXXMapper.xml配置文件映射操作数据库
    @Select("SELECT id, name, state, country FROM city WHERE id = #{id}")
    City findById(Long id);

}
