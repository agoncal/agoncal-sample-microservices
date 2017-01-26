FROM openjdk:8-jre-alpine

MAINTAINER agoncal

LABEL name="Quote 2 Micro Service"
LABEL url="http://localhost:8082/quotes"
LABEL vendor="@agoncal"

EXPOSE 8082

COPY quote2-swarm.jar /opt/quote2-swarm.jar
ENTRYPOINT ["java", "-jar", "/opt/quote2-swarm.jar"]
CMD ["-Dswarm.topology.consul.url=http://consul:8500"]
