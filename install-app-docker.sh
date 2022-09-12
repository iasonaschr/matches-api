#!/bin/bash

./mvnw install
if [ $? -ne 0 ]; then
	exit 1;
fi
cp target/matches-0.0.1-SNAPSHOT.jar docker-demo/matches
cd docker-demo
docker-compose -f docker-compose-full.yaml build api
docker-compose -f docker-compose-full.yaml up



