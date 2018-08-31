package com.elasticsearch.drools.service;

import com.elasticsearch.drools.domain.Message;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;

/**
 * Created with IDEA
 * author:wang
 * Date:2018/8/23 0023 上午 9:41
 * Description:
 */
@Service
public class DroolsService {

    public String fireRule() {
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieContainer = kieServices.getKieClasspathContainer();
        KieSession kieSession = kieContainer.newKieSession("helloWorldSession");
        Message message = new Message();
        message.setMessage("Hello World");
        message.setStatus(Message.HELLO);
        kieSession.insert(message);
        kieSession.fireAllRules();
        kieSession.dispose();
        return message.getMessage();
    }
}
