# spring boot 配置文件中一些敏感信息加密

### 1.前言
我们项目中经常有一些配置文件涉及密码一些敏感信息，我们想加密方式来保护密码，最长用的方式Oracle JEC Jar；
这里我们采用jasypt.jar来加密配置文件。
### 2.准备jar包
```
<dependency>
    <groupId>com.github.ulisesbocchio</groupId>
    <artifactId>jasypt-spring-boot-starter</artifactId>
    <version>2.1.2</version>
 </dependency>
```
### 3.构建一个spring boot 项目
1. 在application.yml添加一个password，这里可以认为是密钥。
```$xslt
jasypt:
  encryptor:
    password: even
```
2. 本项目是整合mysql数据库为列,现在将mysql的密码加密。在test包中密码加密得到加密后的字符串。
```$xslt
 @Autowired
    private StringEncryptor stringEncryptor;

    @Test
    public void contextLoads() {
        String mysqlPassWord="UI.com1234qwer";
        String encryptMysql= stringEncryptor.encrypt(mysqlPassWord);
        String decryptMysql=stringEncryptor.decrypt(encryptMysql);
        System.out.println(encryptMysql);
        System.out.println(decryptMysql);
    }
```
输出结果：
```$xslt
OfYtKN5FQJ5E8vnAeo8CiqLT4CdHzIcB
UI.com1234qwer
```
3. 在application.yml把输出的字符串结果用ENC()包裹起来。
```$xslt
spring:
  application:
    name: file-encryption
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://192.168.0.10:3310/study?useSSL=false&serverTimezone=CTT&useUnicode=true&characterEncoding=utf-8&rewriteBatchedStatements=true&useOldAliasMetadataBehavior=true
    username: root
    password: ENC(sXEm4xE5UAhod49Jow6SWrhaZCFTl9i2)
    hikari:
      pool-name: Hikari-Pool
      minimum-idle: 5
      maximum-pool-size: 15
      auto-commit: true
      idle-timeout: 180000
      max-lifetime: 180000
      connection-timeout: 5000
      connection-test-query: select 1
    type: com.zaxxer.hikari.HikariDataSource
```
4. 启动项目程序正常启动。

### 4.通过其他方式设置密钥
1. 以上只是一个demo，我们实际开发中或者生产环境中是不会直接将密钥写在配置文件中。可以通过如下方式写入代码中。
```$xslt
/**
     * 设置密钥
     * 这里每次加密的字符串都不一样确可以通过密钥解密出相同的明文
     */
    @Test
    public void setPassword(){
        BasicTextEncryptor basicTextEncryptor = new BasicTextEncryptor();
        // application.properties, jasypt.encryptor.password
        basicTextEncryptor.setPassword("even");
        String mysqlPassWord="UI.com1234qwer";
        String rootOne=basicTextEncryptor.encrypt(mysqlPassWord);
        String rootTwo=basicTextEncryptor.encrypt(mysqlPassWord);
        String rootTree=basicTextEncryptor.encrypt(mysqlPassWord);
        // encrypt mysqlPassWord
        System.out.println(rootOne);
        System.out.println(rootTwo);
        System.out.println(rootTree);
        // decrypt, the result is mysqlPassWord
        System.out.println(basicTextEncryptor.decrypt(rootOne));
        System.out.println(basicTextEncryptor.decrypt(rootTwo));
        System.out.println(basicTextEncryptor.decrypt(rootTree));
    }
```
2. 注释掉application.yml,在开发工具VM中添加"-Djasypt.encryptor.password=even"
```$xslt
#jasypt:
#  encryptor:
#    password: even
```
VM options添加，运行test方法正常运行
```$xslt
-Djasypt.encryptor.password=even
```
### 5.在打成jar包运行的时候只需要添加"-Djasypt.encryptor.password=even"即可。
```$xslt
java -jar -Djasypt.encryptor.password=even xxx.jar
```
### 6.参考资料
1. [jasypt](https://github.com/ulisesbocchio/jasypt-spring-boot)
2. [本项目demo github地址]()