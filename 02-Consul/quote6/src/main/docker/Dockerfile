FROM openjdk:8-jre-alpine

MAINTAINER agoncal

LABEL name="Quote 6 Micro Service"
LABEL url="http://localhost:8086/quotes"
LABEL vendor="@agoncal"

EXPOSE 8086

COPY quote6-swarm.jar /opt/quote6-swarm.jar
ENTRYPOINT ["java", "-jar", "/opt/quote6-swarm.jar"]
CMD ["-Dswarm.topology.consul.url=http://consul:8500"]
