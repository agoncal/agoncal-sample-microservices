#!/usr/bin/env bash

# You need first to package all the services with Wildfly Swarm with mvn clean package -Pswarm

java -Dlogging.configuration=file:./logging.properties  -jar ./quote1/target/quote1-swarm.jar &
java -Dlogging.configuration=file:./logging.properties  -jar ./quote2/target/quote2-swarm.jar &
java -Dlogging.configuration=file:./logging.properties  -jar ./quote3/target/quote3-swarm.jar &
java -Dlogging.configuration=file:./logging.properties  -jar ./quote4/target/quote4-swarm.jar &
java -Dlogging.configuration=file:./logging.properties  -jar ./quote5/target/quote5-swarm.jar &
java -Dlogging.configuration=file:./logging.properties  -jar ./quote6/target/quote6-swarm.jar &
