package com.elasticsearch.spring.service;

import com.elasticsearch.spring.entity.City;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created with IDEA
 * author:wang
 * Date:2018/6/26 0026 下午 3:00
 * Description:
 */
public interface CityService {

    /**
     * 新增 ES 城市信息
     *
     * @param city
     * @return
     */
    Long saveCity(City city);

    /**
     * 搜索词搜索，分页返回城市信息
     *
     * @param searchContent 搜索内容
     * @return
     */
    List<City> searchCity(String searchContent) throws ExecutionException, InterruptedException;

    List<City> searchCity2(String searchContent)throws ExecutionException, InterruptedException;
}
