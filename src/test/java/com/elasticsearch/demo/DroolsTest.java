package com.elasticsearch.demo;

import com.elasticsearch.drools.service.DroolsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created with IDEA
 * author:wang
 * Date:2018/8/23 0023 上午 10:01
 * Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DroolsTest {

    @Autowired
    private DroolsService droolsService;
    @Test
    public void contextLoads() {
        droolsService.fireRule();
    }
}
