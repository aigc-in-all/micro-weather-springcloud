
## 基于Spring Cloud技术栈构建的微服务架构

### 一、目录结构介绍

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

### 二、架构图
![](/screenshot/architecture.png)

### 三、环境参数
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
* Docker Compose -> 1.23.2

### 四、截图

![](/screenshot/report.png)

![](/screenshot/eureka.png)

### 五、启动方式(Docker)

#### 1.编译

在项目根目录下执行：
```bash
$ sh ./buils.sh
```
> 以上命令将分别编译各微服务项目并且构建docker镜像。

#### 2.启动

在项目根目录下执行：
```bash
$ docker-compose up
```

然后在本机访问[http://localhost:8083/report/cityId/101280601](http://localhost:8083/report/cityId/101280601)，如果已部署在服务器上，更改localhost为对应IP或域名即可。

Eureka注册中心地址：[http://localhost:8761/](http://localhost:8761/)，可以查看各服务的实例情况。

> 具体的服务和端口配置可查看根目录下的**docker-compose.yml**文件

除了命令行的方式操作和查看Docker，推荐使用图形化的管理工具**Portainer**，它本身也提供了docker镜像，使用起来非常简单。

https://portainer.readthedocs.io/en/latest/deployment.html

```bash

$ docker volume create portainer_data
$ docker run -d -p 9000:9000 --name portainer --restart always \
-v /var/run/docker.sock:/var/run/docker.sock \
-v portainer_data:/data portainer/portainer
```
然后可以访问[http://localhost:9000](http://localhost:9000)按照提示设置即可。

具体文档可以参考：[https://portainer.readthedocs.io/en/latest/deployment.html](https://portainer.readthedocs.io/en/latest/deployment.html)

### 六、TODO

使用k8s进行容器编译
