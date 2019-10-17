package com.even;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.exceptions.ClientException;
import com.even.aliyun.service.AliYunSmsService;
import com.even.aliyun.service.AliYunSmsServiceImpl;
import lombok.extern.log4j.Log4j2;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log4j2
public class SpringBootAliyunSmsDemoApplicationTests {

    @Autowired
    private AliYunSmsService aliYunSmsService;

    @Test
    public void contextLoads() throws ClientException {

        JSONObject object=new JSONObject();
        String randCode=aliYunSmsService.getRandCode(6);
        log.info("验证码为：{}",randCode);
        object.put("code",randCode);
        Assert.assertEquals(true,aliYunSmsService.sendSms("13138141458","你的签名","你的模板code",object.toString()));
    }

}
