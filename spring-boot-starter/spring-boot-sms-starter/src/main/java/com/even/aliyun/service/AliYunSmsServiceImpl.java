package com.even.aliyun.service;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.even.aliyun.properties.AliYunSmsProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Random;

/**
 * @author even
 * @date 2019/10/15 0015
 * @describe
 */
@Slf4j
@RequiredArgsConstructor
public class AliYunSmsServiceImpl implements AliYunSmsService{

    private final  AliYunSmsProperties aliYunSmsProperties;

    /**
     * 获取默认客户端
     * @return
     */
    public IAcsClient getDefaultAcsClient(){
        DefaultProfile profile = DefaultProfile.getProfile(aliYunSmsProperties.getRegionId(), aliYunSmsProperties.getAccessKeyId(), aliYunSmsProperties.getAccessSecret());
        DefaultProfile.addEndpoint( aliYunSmsProperties.getRegionId(),
                aliYunSmsProperties.getProduct(), aliYunSmsProperties.getDomain());
        //可自助调整超时时间
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");
        return new DefaultAcsClient(profile);
    }

    /**
     * 封装公共的request
     * @return
     */
    private CommonRequest request(){
        CommonRequest request = new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysDomain(aliYunSmsProperties.getDomain());
        request.setSysVersion("2017-05-25");
        request.setSysAction("SendSms");
        request.putQueryParameter("RegionId", aliYunSmsProperties.getRegionId());
        return request;
    }

    @Override
    public boolean sendSms(String phoneNumber, String signName, String templateCode, String templateParam) {
        CommonRequest request = this.request();
        request.putQueryParameter("PhoneNumbers", phoneNumber);
        request.putQueryParameter("SignName", signName);
        request.putQueryParameter("TemplateCode", templateCode);
        request.putQueryParameter("TemplateParam", templateParam);
        try {
            CommonResponse response = this.getDefaultAcsClient().getCommonResponse(request);
            log.info(response.getData());
            return true;
        } catch (Exception e) {
            log.error("{}",e);
        }
        return false;
    }


    @Override
    public String getRandCode(int digits) {
        StringBuilder sBuilder = new StringBuilder();
        Random rd = new Random( LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli());
        for(int i = 0; i < digits; ++i) {
            sBuilder.append(rd.nextInt(9));
        }
        return sBuilder.toString();
    }
}
