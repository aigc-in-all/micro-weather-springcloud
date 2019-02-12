#!/usr/bin/env bash

projects=(
        "weather-eureka-server"
        "weather-city-service"
        "weather-collection-service"
        "weather-data-service"
        "weather-gateway-zuul"
        "weather-report-service"
        )

for proj in ${projects[@]}
do
    echo "############ Start Build (${proj}) ############"
    cd ${proj}
    sh ./build.sh
    cd ..
    echo "############ End Build (${proj}) ############"
done