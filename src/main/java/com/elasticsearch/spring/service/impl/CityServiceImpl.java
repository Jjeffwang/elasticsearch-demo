package com.elasticsearch.spring.service.impl;

import com.elasticsearch.spring.Repository.CityRepository;
import com.elasticsearch.spring.entity.City;
import com.elasticsearch.spring.service.CityService;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.lucene.search.function.CombineFunction;
import org.elasticsearch.common.lucene.search.function.FieldValueFactorFunction;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.functionscore.FunctionScoreQueryBuilder;
import org.elasticsearch.index.query.functionscore.ScoreFunctionBuilder;
import org.elasticsearch.index.query.functionscore.ScoreFunctionBuilders;
import org.elasticsearch.search.SearchHit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created with IDEA
 * author:wang
 * Date:2018/6/26 0026 下午 3:01
 * Description:
 */
@Service
public class CityServiceImpl implements CityService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CityServiceImpl.class);

    /* 分页参数 */
    Integer PAGE_SIZE = 12;          // 每页数量
    Integer DEFAULT_PAGE_NUMBER = 0; // 默认当前页码

    /* 搜索模式 */
    String SCORE_MODE_SUM = "sum"; // 权重分求和模式
    Float  MIN_SCORE = 10.0F;      // 由于无相关性的分值默认为 1 ，设置权重分最小值为 10

    @Autowired
    CityRepository cityRepository; // ES 操作类

    @Autowired
    private TransportClient client;


    public Long saveCity(City city) {
        City cityResult = cityRepository.save(city);
        return cityResult.getId();
    }

    public List<City> searchCity(Integer pageNumber, Integer pageSize, String searchContent) throws ExecutionException, InterruptedException {

        SearchRequestBuilder searchRequestBuilder=client.prepareSearch("province").setTypes("city");
        searchRequestBuilder.setSearchType(SearchType.DFS_QUERY_THEN_FETCH);
        //分页
        searchRequestBuilder.setFrom(DEFAULT_PAGE_NUMBER).setSize(PAGE_SIZE);
        //explain为true表示根据数据相关度排序，和关键字匹配最高的排在前面
        searchRequestBuilder.setExplain(true);
        BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery();
        queryBuilder.must(QueryBuilders.matchQuery("name",searchContent));

//        ScoreFunctionBuilder<?> scoreFunctionBuilder = ScoreFunctionBuilders.fieldValueFactorFunction("sales").modifier(FieldValueFactorFunction.Modifier.LN1P).factor(0.1f);
        FunctionScoreQueryBuilder query = QueryBuilders.functionScoreQuery(queryBuilder);
        /**
         * 方式一
         * 直接获取
         */
        searchRequestBuilder.setQuery(query);
        SearchResponse searchResponse = searchRequestBuilder.execute().get();
        long totalCount = searchResponse.getHits().getTotalHits();
        System.out.println("总条数 totalCount:" + totalCount);
        //遍历结果数据
        SearchHit[] hitList = searchResponse.getHits().getHits();
        for (SearchHit hit : hitList) {
            System.out.println("SearchHit hit string:" + hit.getSourceAsString());
        }

        /**
         * 方式二
         * 根据cityRepository获取
         */
        SearchQuery searchQuery= new NativeSearchQueryBuilder().withQuery(query).build();
        Page<City> cityPage = cityRepository.search(searchQuery);
        return cityPage.getContent();
    }

}
