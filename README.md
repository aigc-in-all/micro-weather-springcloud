
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
* Redis -> 5.0.3
* Quartz Scheduler -> 2.3.0
* Docker -> 18.09.0

### 截图

![](/screenshot/report.png)

![](/screenshot/eureka.png)

### 启动方式(Docker)

#### 1.编译

在项目根目录下执行：
```bash
sh ./buils.sh
```
> 以上命令将分别编译各微服务项目并且构建docker镜像。

#### 2.启动

在项目根目录下执行：
```bash
docker-compose up
```

然后在本机访问[http://localhost:8083/report/cityId/101280601](http://localhost:8083/report/cityId/101280601)，如果已部署在服务器上，更改localhost为对应IP或域名即可。

Eureka注册中心地址：[http://localhost:8761/](http://localhost:8761/)，可以查看各服务的实例情况。

> 具体的服务和端口配置可查看根目录下的**docker-compose.yml**文件

### TODO

使用k8s进行容器编译