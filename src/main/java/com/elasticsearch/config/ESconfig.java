package com.elasticsearch.config;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created with IDEA
 * author:wang
 * Date:2018/6/20 0020 下午 6:31
 * Description:
 */
@Configuration
public class ESconfig {


    @Bean
    public TransportClient client() throws UnknownHostException{

        //es集群配置（自定义配置） 连接自己安装的集群名称
//        Settings settings = Settings.builder()
//                .put("cluster.name","demo")
//                .build();
        PreBuiltTransportClient client = new PreBuiltTransportClient(Settings.EMPTY);
        //es集群连接
        client.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300));

        return client;
    }
}