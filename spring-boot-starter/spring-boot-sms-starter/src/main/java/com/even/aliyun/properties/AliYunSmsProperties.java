package com.even.aliyun.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author even
 * @date 2019/10/14 0014
 * @describe
 * 阿里云配置
 */

@ConfigurationProperties(prefix=AliYunSmsProperties.PREFIX )
@Data
public class AliYunSmsProperties {
 /**
  * 阿里短信服务配置前缀名
  *
  */
 public static final String PREFIX="ali.sms";

 /**
  * 短信API产品名称（短信产品名固定，无需修改）
  */
 private String product = "Dysmsapi";

 /**
  * 短信API产品域名（接口地址固定，无需修改）
  */
 private String domain = "dysmsapi.aliyuncs.com";
 /**
  * regionId
  */
 private String regionId="cn-hangzhou";
 /**
  * 是否可用
  */
 private boolean enable;
 /**
  * 阿里accessKeyId
  */
 private String accessKeyId;
 /**
  * 阿里accessSecret
  */
 private String accessSecret;

}
