FROM openjdk:8-jre-alpine

MAINTAINER agoncal

LABEL name="Quote 3 Micro Service"
LABEL url="http://localhost:8083/quotes"
LABEL vendor="@agoncal"

EXPOSE 8083

COPY quote3-swarm.jar /opt/quote3-swarm.jar
ENTRYPOINT ["java", "-jar", "/opt/quote3-swarm.jar"]
CMD ["-Dswarm.topology.consul.url=http://consul:8500"]
