package com.even.exception.dingtalk.service.impl;

import com.even.exception.dingtalk.model.DingTalkExceptionInfo;
import com.even.exception.dingtalk.model.DingTalkResult;
import com.even.exception.dingtalk.model.ExceptionInfo;
import com.even.exception.dingtalk.properties.DingTalkProperties;
import com.even.exception.dingtalk.service.DingTalkService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

/**
 * @author even
 * @date 2019/8/28 0028
 * @describe
 */
@Log4j2
@RequiredArgsConstructor
public class DingTalkServiceImpl implements DingTalkService {

    private final DingTalkProperties dingTalkProperties;

    private final RestTemplate restTemplate;



    @Override
    public void sendNotice(ExceptionInfo exceptionInfo) {
        DingTalkExceptionInfo dingDingNotice = new DingTalkExceptionInfo(exceptionInfo.createText(),
                dingTalkProperties.getAtPhones());
        Assert.hasText(dingTalkProperties.getWebHook(),"DingTalk webHook must not be null");
        DingTalkResult result = restTemplate.postForObject(dingTalkProperties.getWebHook(), dingDingNotice, DingTalkResult.class);
        log.debug("{}",result.toString());
    }
}
