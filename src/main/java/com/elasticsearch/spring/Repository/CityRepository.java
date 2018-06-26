package com.elasticsearch.spring.Repository;

import com.elasticsearch.spring.entity.City;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Created with IDEA
 * author:wang
 * Date:2018/6/26 0026 下午 3:03
 * Description:
 */
public interface CityRepository extends ElasticsearchRepository<City,Long> {
}
