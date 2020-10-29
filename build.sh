#!/bin/bash
source ./setenv
docker volume create $MYSQL_DATABASE_VOLUME
pushd app
mvn clean package
docker build -f Dockerfile -t com.example/app:latest \
    --build-arg MYSQL_HOST=$MYSQL_HOST \
    --build-arg MYSQL_DATABASE=$MYSQL_DATABASE \
    --build-arg MYSQL_USER=$MYSQL_USER \
    --build-arg MYSQL_PASSWORD=$MYSQL_PASSWORD .
pushd

