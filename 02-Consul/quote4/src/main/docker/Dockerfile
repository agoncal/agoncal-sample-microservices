FROM openjdk:8-jre-alpine

MAINTAINER agoncal

LABEL name="Quote 4 Micro Service"
LABEL url="http://localhost:8084/quotes"
LABEL vendor="@agoncal"

EXPOSE 8084

COPY quote4-swarm.jar /opt/quote4-swarm.jar
ENTRYPOINT ["java", "-jar", "/opt/quote4-swarm.jar"]