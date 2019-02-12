#!/usr/bin/env bash

# build
./gradlew clean
./gradlew build -x test # build without test

# remove image
docker rmi weather-report-service:latest

# build image
docker build -t weather-report-service:latest .

# push image to docker hub