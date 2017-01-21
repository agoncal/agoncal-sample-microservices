#!/usr/bin/env bash

# You need first to package all the services with Wildfly Swarm with mvn clean package -Pswarm

java -jar ./service1/target/service1-swarm.jar &
java -jar ./service2/target/service2-swarm.jar &
#java -jar ./service3/target/service3-swarm.jar &
#java -jar ./service4/target/service4-swarm.jar &
#java -jar ./service5/target/service5-swarm.jar &
#java -jar ./service6/target/service6-swarm.jar &
