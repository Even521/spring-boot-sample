## 1.前言
我们用spring boot发现会有很多spring-boot-starter-xxx,在实际开发中可能会通过@Bean注解来实现组件的加载，我们希望通过配置文件如application.yml或者application.properties来实现自定义类的加载到spring 容器中去。
本文采用spring boot版本为2.1.1为例。
官方文档建议我们自定义组件命名最好采用xxx-spring-boot-starter [命名规则参考](https://docs.spring.io/spring-boot/docs/2.1.1.RELEASE/reference/htmlsingle/#boot-features-custom-starter-naming)。
##2.准备知识
知识点 | 学习网址|特性
---|---|---
@Configuration| [配置元数据](https://docs.spring.io/spring/docs/5.1.3.RELEASE/spring-framework-reference/core.html#beans-factory-metadata)|spring 3.0开始<br>引入该注解，<br>@Configuration作用<br>在用于描述类、<br>接口(包括注解类型) 或enum声明。<br>初始化配置类我们知道有2种方式:<br>1.通过META-INF/<br>spring.factories文件来实现<br>org.springframework.boot<br>.autoconfigure.EnableAuto<br>Configuration<br>=<br>\com.even.fastjson.<br>FastJsonAutoConfiguration<br> (spring boot采用SPI的约定)。<br>2.采用扫包的方式<br>scanBasePackages实现。
@EnableConfiguration<br>Properties|[注册的属性类](https://docs.spring.io/spring-boot/docs/2.1.1.RELEASE/reference/htmlsingle/#boot-features-external-config-vs-value)|  该注解是用来开启对<br>@ConfigurationProperties注解配置Bean的支持。<br>也就是@EnableConfiguration<br>Properties注解<br>告诉Spring Boot 能支持@ConfigurationProperties。
@ConditionalOnClass |  [条件注解](https://docs.spring.io/spring-boot/docs/2.1.1.RELEASE/reference/htmlsingle/#boot-features-developing-auto-configuration) | 含义是有某个类bean才会加载。  
@ConditionalOnProperty|[@Conditional<br>OnProperty<br>来控制Configuration<br>是否生效](https://docs.spring.io/spring-boot/docs/2.1.1.RELEASE/reference/htmlsingle/#boot-features-developing-auto-configuration)|通过其两个属性name以及havingValue来实现的，其中name用来从application.properties中读取某个属性值。<br>如果该值为空，则返回false;如果值不为空，则将该值与havingValue指定的值进行比较，如果一样则返回true;否则返回false。 <br>如果返回值为false，则该configuration不生效；为true则生效。                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               
@Conditional<br>OnWebApplication|[Web应用程序条件](https://docs.spring.io/spring-boot/docs/2.1.1.RELEASE/reference/htmlsingle/#boot-features-developing-auto-configuration)|让配置取决于<br>应用程序是否是一个“Web应用程序”被包括在内。<br>Web应用程序是使用<br>Spring WebApplicationContext，<br>定义session范围或具有的任何应用程序StandardServletEnvironment。
fastJson|[fastJson](https://github.com/alibaba/fastjson)| FastJson是一个Java库，可用于将Java对象转换为其JSON表示。 它还可用于将JSON字符串转换为等效的Java对象。<br> FastJson可以处理任意Java对象，包括您没有源代码的预先存在的对象。                                                                                                                                                                                   
##3.依赖
```$maven
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-autoconfigure</artifactId>
    </dependency>
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-configuration-processor</artifactId>
      <optional>true</optional>
    </dependency>
    <dependency>
      <groupId>javax.servlet</groupId>
      <artifactId>javax.servlet-api</artifactId>
      <scope>provided</scope>
    </dependency>

    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-web</artifactId>
      <scope>provided</scope>
    </dependency>

    <dependency>
      <groupId>com.alibaba</groupId>
      <artifactId>fastjson</artifactId>
      <version>${fast.json}</version>
    </dependency>
```
##4.代码实现
1.创建FastJsonProperties类,主要是放默认的fastJson配置文件。
```$java
@ConditionalOnClass({JSON.class})
@ConfigurationProperties(prefix = "spring.fastjson")
public class FastJsonProperties {
    /**
     * 默认Content-Type
     */
    private final static String DEFAULT_MEDIA_TYPE = "application/json;charset=UTF-8";
    /**
     * 是否生效
     */
    private boolean enabled;
    /**
     * 默认List<MediaType>
     */
    private List<MediaType> supportedMediaTypes = MediaType.parseMediaTypes(DEFAULT_MEDIA_TYPE);
    /**
     * 实例化一个FastJsonConfig对象
     */
    private FastJsonConfig config = new FastJsonConfig();

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public List<MediaType> getSupportedMediaTypes() {
        return supportedMediaTypes;
    }

    public void setSupportedMediaTypes(List<MediaType> supportedMediaTypes) {
        this.supportedMediaTypes = supportedMediaTypes;
    }

    public FastJsonConfig getConfig() {
        return config;
    }

    public void setConfig(FastJsonConfig config) {
        this.config = config;
    }
```
2.创建FastJsonAutoConfiguration类。
- (1)注入配置文件类。
- (2)过滤配置文件值判断是否生效。
- (3)重新构造HttpMessageConverter方法。
- (4)把bean注入到容器中。
```$java
@Configuration
@EnableConfigurationProperties({FastJsonProperties.class})
@ConditionalOnClass({JSON.class, HttpMessageConverter.class})
public class FastJsonAutoConfiguration {
    @Resource
    private FastJsonProperties fastJsonProperties;
    @Bean
    @ConditionalOnProperty(prefix = "spring.fastjson", name = "enabled", havingValue = "true", matchIfMissing = true)
    @ConditionalOnWebApplication
    public HttpMessageConverter<?> httpMessageConverter() {
        /**
         * FastJsonHttpMessageConverter转换类
         */
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
        /*媒体类型*/
        fastJsonHttpMessageConverter.setSupportedMediaTypes(fastJsonProperties.getSupportedMediaTypes());
        /*配置*/
        fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonProperties.getConfig());
        return fastJsonHttpMessageConverter;
    }
```
3.在resources下的META-INF里创建spring.factories文件,spring boot通个这个文件来扫包把我们的bean加载到容器中。
```$java
org.springframework.boot.autoconfigure.EnableAutoConfiguration=\
com.even.fastjson.FastJsonAutoConfiguration
```
4.为了让IDE编辑器能提示我们一些配置提示我们自己创建一个spring-configuration-metadata.json文件里面添加一些元数据。
[参考文档](https://docs.spring.io/spring-boot/docs/2.1.1.RELEASE/reference/htmlsingle/#configuration-metadata)
```$java
{
  "properties": [
    {
      "name": "spring.fastjson.supportedMediaTypes",
      "type": "java.lang.String",
      "description": "Description for spring.fastjson.supportedMediaTypes.",
      "defaultValue": "application/json;charset=UTF-8"
    },
    {
      "name": "spring.fastjson.config.serializerFeatures",
      "type": "com.alibaba.fastjson.serializer.SerializerFeature",
      "description": "Description for spring.fastjson.config.serializerFeatures."
    },
    {
      "name": "spring.fastjson.enabled",
      "type": "java.lang.Boolean",
      "description": "Whether to enable FastJsonHttpMessageConverter.",
      "defaultValue": true
    },
    {
      "name": "spring.fastjson.config.dateFormat",
      "type": "java.lang.String",
      "description": "Date serialization format."
    }
  ],
  "hints": [
    {
      "name": "spring.fastjson.supportedMediaTypes",
      "values": [
        {
          "value": "application/json;charset=UTF-8"
        },
        {
          "value": "text/html"
        },
        {
          "value": "text/plain"
        },
        {
          "value": "text/xml"
        }
      ]
    },
    {
      "name": "spring.fastjson.config.serializerFeatures",
      "providers": [
        {
          "name": "handle-as",
          "parameters": {
            "target": "com.alibaba.fastjson.serializer.SerializerFeature"
          }
        }
      ]
    },
    {
      "name": "spring.fastjson.enabled",
      "values": [
        {
          "value": true
        },
        {
          "value": false
        }
      ]
    },
    {
      "name": "spring.fastjson.config.dateFormat",
      "values": [
        {
          "value": "yyyy-MM-dd"
        },
        {
          "value": "yyyy-MM-dd HH:mm:ss"
        },
        {
          "value": "HH:mm:ss"
        }
      ]
    }
  ]
}
```
6.自定义starter代码完成了需要打成jar包,别的spring-boot只需要将这个包引用进来。
注意打包的时候看一下target/classes/META-INF/下是否有spring.factories文件,我打包的时候出现了没有这个文件导致我测试fastjson一直不生效。
7.测试
- (1)创建一个新的spring-boot项目。
- (2)引入spring-boot-fastjson-starter包。
- (3)在配置文件开启spring.fastjson.enabled=true。
- (4)写一个demo这里就省略demo。
User类
```$java
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class User {
    //去掉ID
    @JSONField(serialize=false)
    private Long id;
    @JSONField(ordinal = 3)
    private String name;
    private int age;
    @JSONField(ordinal = 1)
    private LocalDate birthday;
}
```
(5)输出结果:{"age":20,"birthday":"2018-12-21","name":"even"}
##5.资料
- 参考文档:[spring-boot文档](https://docs.spring.io/spring-boot/docs/2.1.1.RELEASE/reference/htmlsingle/)
- 参考源码:[fastjson-spring-boot-starter](https://github.com/coffee377/spring-boot-starter-fastjson)
- 笔者源码地址:[spring-boot-fastjson-starter](https://github.com/Even521/spring-boot-sample/tree/master/spring-boot-starter/spring-boot-fastjson-starter)
- 笔者测试demo源码地址:[spring-boot-fastjson](https://github.com/Even521/spring-boot-sample/tree/master/spring-boot-demo/spring-boot-fastjson)
- 笔者邮箱:even366@qq.com