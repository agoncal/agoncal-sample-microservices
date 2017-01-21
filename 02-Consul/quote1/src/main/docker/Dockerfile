FROM openjdk:8-jre-alpine

MAINTAINER agoncal

LABEL name="Quote 1 Micro Service"
LABEL url="http://localhost:8081/quotes"
LABEL vendor="@agoncal"

EXPOSE 8081

COPY quote1-swarm.jar /opt/quote1-swarm.jar
ENTRYPOINT ["java", "-jar", "/opt/quote1-swarm.jar"]