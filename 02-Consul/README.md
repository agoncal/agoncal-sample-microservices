# Sample - Micro Services - Consul and Wildfly Swarm

## Purpose of this sample

The purpose of this sample is to show you how WildFly Swarm Topology interacts with Consul.

* Using JAX-RS Endpoints
* Using Consul

[Read more on my blog](http://antoniogoncalves.org/2011/01/12/bootstrapping-cdi-in-several-environments/)

## Building

You have different ways to build and test the app : 

* `mvn clean install` : creates several war files to deploy on a Wildfly 
* `mvn clean install -Pswarm` : creates several uber-jar files so you can execute the jar 
* `mvn clean install -Pswarm,docker` : creates docker images for the services 

## Docker

* `docker image ls` : show all the images
* `docker image ls | grep quote` : show all the images for quotes
* `docker image ls | grep quote` : show all the images for quotes
* `docker run -p 8081:8081 agoncal/quote1`

### Docker compose

* `docker-compose up` : executes the 6 services with a consul
* `docker-compose down` : add the `--remove-orphans` flags if needed

* `docker ps`: you will be able to see all the quote services and consul
* `docker exec -t <2c3f777af3e0> consul members` : checks all the consul members running on Docker 


## Consul

Start consul :

    $ consul agent -dev

Check the Admin Console at [http://localhost:8500/ui]()

Check the [REST APIs](https://www.consul.io/docs/agent/http.html) at :

* [http://localhost:8500/v1/catalog/nodes]()
* [http://localhost:8500/v1/catalog/services]()
* [http://localhost:8500/v1/catalog/service/quote1]()
* [http://localhost:8500/v1/health/service/consul]()

# Licensing

<a rel="license" href="http://creativecommons.org/licenses/by-sa/3.0/"><img alt="Creative Commons License" style="border-width:0" src="http://i.creativecommons.org/l/by-sa/3.0/88x31.png" /></a><br />This work is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by-sa/3.0/">Creative Commons Attribution-ShareAlike 3.0 Unported License</a>.

<div class="footer">
    <span class="footerTitle"><span class="uc">a</span>ntonio <span class="uc">g</span>oncalves</span>
</div>