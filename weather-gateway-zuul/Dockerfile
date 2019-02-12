FROM openjdk:8-jdk-alpine
MAINTAINER qingbao.ho@gmail.com

COPY build/libs/weather-gateway-zuul-1.0.jar /weather-gateway-zuul.jar
ENTRYPOINT ["java", "-jar", "/weather-gateway-zuul.jar"]