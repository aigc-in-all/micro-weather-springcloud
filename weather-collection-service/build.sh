#!/usr/bin/env bash

# build
./gradlew clean
./gradlew build -x test # build without test

# remove image
docker rmi weather-collection-service:latest

# build image
docker build -t weather-collection-service:latest .

# push image to docker hub