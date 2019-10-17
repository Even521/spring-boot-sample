### 1.前言
1.1 目前项目太多地方调用短信服务，微服务与微服务之间太多冗余代码，维护起来也不方便。
项目中也会更改第三服务，由于多数时用spring-boot框架开发，这里封装一下短信服务，做到开箱即用，即使改变第三方只需修改配置文件即可。
### 2.准备jar
2.1 目前我们项目使用的阿里云短信服务，这里引进阿里短信SDK。
```$xslt
<dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-autoconfigure</artifactId>
      <version>${spring-boot.version}</version>
    </dependency>
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-configuration-processor</artifactId>
      <version>${spring-boot.version}</version>
      <optional>true</optional>
    </dependency>

    <dependency>
      <groupId>com.aliyun</groupId>
      <artifactId>aliyun-java-sdk-core</artifactId>
      <version>${aliyun-java-sdk-core.version}</version>
    </dependency>
```
### 3.创建阿里云短信配置类 AliYunSmsProperties
3.1 首先是通过Value注解将配置文件中配置的那四个参数获取到。
3.2 这里的4给参数分别对应阿里云平台：
三个参数分别对应的是:地域ID，RAM账号的AccessKey ID， RAM账号AccessKey Secret
模板ID是阿里云短信生成模板的ID。
```$xslt
@Setter
@Getter
@ConfigurationProperties(prefix=AliYunSmsProperties.PREFIX )
@AllArgsConstructor
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
     * 阿里accessKeyId
     */
    @Value("${accessKeyId}")
    private String accessKeyId;
    /**
     * 阿里accessSecret
     */
    @Value("${accessSecret}")
    private String accessSecret;
    /**
     * 签名名称
     */
    @Value("${signName}")
    private String signName;
    /**
     * 模板code
     */
    @Value("${templateCode}")
    private String templateCode;
}
```
### 4.在AUTO—Config类中添加AliYunSmsService Bean
4.1 注入AliYunSmsService Bean
```$xslt
     @Bean
     public AliYunSmsService aliYunSmsService(AliYunSmsProperties properties){
         return new AliYunSmsServiceImpl(properties);
     }
```
### 5.创建发送短信接口
5.1 创建AliYunSmsService接口,这里只封装了一个给手机发送验证码接口。
5.2 如需批量发送、查询自定义即可。
```$xslt
public interface AliYunSmsService {
    /**
     * 阿里云发送短消息
     * @param phoneNumber
     * @param templateParam 模板内容json串
     * @return
     */
    boolean sendSms(@NonNull String phoneNumber,@NonNull String templateParam);

    /**
     * 获取验证码随机数
     * @param digits 几位验证码数
     * @return
     */
    String getRandCode(int digits);
}

```
### 6.实现AliYunSmsService接口
6.1 实现主要调用阿里sqk里面的方法，request.putQueryParamete()我们修改主要是修改这里面的参数。
```
/**
     * 阿里客户端
     */
    private final IAcsClient client;
    private final AliYunSmsProperties aliYunSmsProperties;


    @Override
    public boolean sendSms(String phoneNumber,String templateParam) {
        CommonRequest request = new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysAction("SendSms");
        request.putQueryParameter("RegionId",aliYunSmsProperties.getRegionId());
        request.putQueryParameter("PhoneNumber",phoneNumber);
        request.putQueryParameter("SingName",aliYunSmsProperties.getSignName());
        request.putQueryParameter("TemplateCode",aliYunSmsProperties.getTemplateCode());
        request.putQueryParameter("TemplateParam",templateParam);
        try {
            CommonResponse response = client.getCommonResponse(request);
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
```
6.2 项目源码:[spring-boot-sms-starter](https://github.com/Even521/spring-boot-sample/tree/master/spring-boot-starter/spring-boot-sms-starter)
### 7.创建一个spring boot项目：spring-boot-aliyun-sms-demo
7.1 导入依赖包
```
<dependency>
            <groupId>com.even</groupId>
            <artifactId>spring-boot-sms-starter</artifactId>
            <version>1.0.0</version>
        </dependency>
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>fastjson</artifactId>
            <version>1.2.61</version>
        </dependency>
```
7.2 添加yml文件配置
```
ali:
  sms:
    access-key-id: 这里填阿里云access-key-id
    access-secret: 这里填阿里云access-secret
    enable: true
```
7.3 单元测试，测试发送一条短信是否生效，注意签名和模板code都是从阿里云平台审核过的签名和模板。
```
 @Autowired
    private AliYunSmsService aliYunSmsService;

    @Test
    public void contextLoads() throws ClientException {

        JSONObject object=new JSONObject();
        String randCode=aliYunSmsService.getRandCode(6);
        log.info("验证码为：{}",randCode);
        object.put("code",randCode);
        Assert.assertEquals(true,aliYunSmsService.sendSms("13138141458","签名","消息code",object.toString()));
    }
```
### 8.测试返回结果
8.1 控制打印信息
```$xslt
2019-10-17 14:13:31.556  INFO 5668 --- [           main] .SpringBootAliyunSmsDemoApplicationTests : 验证码为：861363
2019-10-17 14:13:32.230  INFO 5668 --- [           main] c.e.aliyun.service.AliYunSmsServiceImpl  : {"Message":"OK","RequestId":"CFA4FD81-5506-4F2C-825B-FF420802140D","BizId":"295316571292812259^0","Code":"OK"}
```
### 9源码地址
1. [spring-boot-aliyun-sms-demo](https://github.com/Even521/spring-boot-sample/tree/master/spring-boot-demo/spring-boot-aliyun-sms-demo)
2. [spring-boot-sms-starter](https://github.com/Even521/spring-boot-sample/tree/master/spring-boot-starter/spring-boot-sms-starter)