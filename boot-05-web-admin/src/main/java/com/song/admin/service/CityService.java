package com.song.admin.service;

import com.song.admin.bean.City;
import com.song.admin.mapper.CityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description:
 *
 * @Create : 2024/3/22 -10:32
 * @Version : v1.0
 */
@Service
public class CityService {
    @Autowired
    CityMapper cityMapper;
    public City findById(Long id)
    {
        return cityMapper.findById(id);
    }

    public void saveCity(City city)
    {
        cityMapper.insert(city);
    }
}
