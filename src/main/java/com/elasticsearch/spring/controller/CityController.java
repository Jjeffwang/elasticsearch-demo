package com.elasticsearch.spring.controller;

import com.elasticsearch.spring.entity.City;
import com.elasticsearch.spring.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created with IDEA
 * author:wang
 * Date:2018/6/26 0026 下午 4:06
 * Description:
 */
@RestController
public class CityController {

    @Autowired
    private CityService cityService;

    /**
     * 插入 ES 新城市
     *
     * @param city
     * @return
     */
    @RequestMapping(value = "api/city", method = RequestMethod.POST)
    public Long createCity(@RequestBody City city) {
        return cityService.saveCity(city);
    }

    /**
     * 搜索返回分页结果
     *
     * @param searchContent 搜索内容
     * @return
     */
    @RequestMapping(value = "api/city/search", method = RequestMethod.POST)
    public List<City> searchCity(@RequestParam(name = "searchContent") String searchContent) throws ExecutionException, InterruptedException {
        return cityService.searchCity2(searchContent);
    }
}
