package com.elasticsearch.utils;

import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created with IDEA
 * @author:wang
 * @Date:2018/7/13 0013 下午 2:38
 * @Description:
 */
@Component
public class EsUtils {

    @Autowired
    private TransportClient client;


    public static EsUtils esUtils;

    @PostConstruct
    public void init(){
        esUtils=this;
    }


    public static GetResponse get(String index, String type, String id){
        return esUtils.client.prepareGet(index,type,id).get();
    }
}
