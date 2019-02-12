#!/usr/bin/env bash

# build
./gradlew clean
./gradlew build -x test # build without test

# remove image
docker rmi weather-eureka-server:latest

# build image
docker build -t weather-eureka-server:latest .

# push image to docker hub