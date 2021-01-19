FROM openjdk:8-jdk-alpine

MAINTAINER hekai

WORKDIR /home

ADD target/*.jar app.jar

RUN mkdir /home/logs

ENV JAVA_OPTS=""

ENTRYPOINT exec java $JAVA_OPTS -jar /home/app.jar