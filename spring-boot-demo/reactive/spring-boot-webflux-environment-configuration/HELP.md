# spring boot 2.4配置多环境

### spring boot 2.4版本
增加分组group
```
spring:
  profiles:
    active: dev
    group:
      dev: dev-file
      prod: prod-file

---
spring:
  config:
    activate:
      on-profile: dev-file

environment: dev

---
spring:
  config:
    activate:
      on-profile: test-file

environment: test
---
spring:
  config:
    activate:
      on-profile: prod-file

environment: prod
```
### 启动程序
日志可以看到The following profiles are active: dev,dev-file,默认dev
```
2020-12-22 14:05:57.612  INFO 14004 --- [           main] bfluxEnvironmentConfigurationApplication : The following profiles are active: dev,dev-file
2020-12-22 14:05:58.531  INFO 14004 --- [           main] o.s.b.web.embedded.netty.NettyWebServer  : Netty started on port(s): 8080
2020-12-22 14:05:58.539  INFO 14004 --- [           main] bfluxEnvironmentConfigurationApplication : Started 
```

###源码分析
SpringApplication 类中可以找到容器默认加载环境active profiles
```
    //启动日志
	protected void logStartupProfileInfo(ConfigurableApplicationContext context) {
		Log log = getApplicationLog();
		if (log.isInfoEnabled()) {
			String[] activeProfiles = context.getEnvironment().getActiveProfiles();
			if (ObjectUtils.isEmpty(activeProfiles)) {
				String[] defaultProfiles = context.getEnvironment().getDefaultProfiles();
				log.info("No active profile set, falling back to default profiles: "
						+ StringUtils.arrayToCommaDelimitedString(defaultProfiles));
			}
			else {
				log.info("The following profiles are active: "
						+ StringUtils.arrayToCommaDelimitedString(activeProfiles));
			}
		}
	}
```
