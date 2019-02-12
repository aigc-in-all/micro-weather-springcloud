FROM openjdk:8-jdk-alpine
MAINTAINER qingbao.ho@gmail.com

COPY build/libs/weather-eureka-server-1.0.jar /weather-eureka-server.jar
ENTRYPOINT ["java", "-jar", "/weather-eureka-server.jar"]