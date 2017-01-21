FROM openjdk:8-jre-alpine

MAINTAINER agoncal

LABEL name="Quote 5 Micro Service"
LABEL url="http://localhost:8085/quotes"
LABEL vendor="@agoncal"

EXPOSE 8085

COPY quote5-swarm.jar /opt/quote5-swarm.jar
ENTRYPOINT ["java", "-jar", "/opt/quote5-swarm.jar"]