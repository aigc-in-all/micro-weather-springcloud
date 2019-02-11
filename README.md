
## 基于Spring Cloud技术栈构建的微服务架构

### 目录结构介绍

Module | 介绍
---|---
micro-weather-basic | 基于SpringBoot构建的完整单体项目，其它均是拆分
weather-collection-service | 天气数据采集微服务，负责天气数据采集和存储
weather-data-service | 天气数据API微服务，提供天气数据查询功能
weather-city-service | 城市数据API微服务，提供城市列表信息
weather-report-service | 天气预报微服务，提供天气预报Web界面展示天气信息
weather-config-server | Spring Cloud Config Server端 
weather-config-client | Spring Cloud Config Client端
weather-eureka-server | Eureka注册中心
weather-gateway-zuul | Zuul网关

### 架构图
![](/screenshot/architecture.png)

### 环境参数
* JDK -> 1.8
* IDE -> Intellij IDEA
* Gradle -> 4.10
* Spring Boot -> 2.1.2.RELEASE
* Eureka Server -> Greenwich.RELEASE
* Zuul -> Greenwich.RELEASE
* Hystrix ->Greenwich.RELEASE
* Feign ->Greenwich.RELEASE
* Config ->Greenwich.RELEASE
* Redis -> 3.2
* Quartz Scheduler -> 2.3.0


### 截图

![](/screenshot/report.png)

![](/screenshot/eureka.png)

### Todo

结合Docker+k8s容器编排技术做自动扩展
