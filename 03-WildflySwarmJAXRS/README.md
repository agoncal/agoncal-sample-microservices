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
* You can then start all the processes with `launch_all_services.sh`, curl all the services with `curl_all_services.sh` and kill them all with `pkill -f quote`

## Docker

* `mvn clean install -Pswarm,docker` : creates docker images for the services 
* `docker image ls` : show all the images
* `docker image ls | grep quote` : show all the images for quotes
* `docker container ls`
* `docker container run -p 8081:8081 agoncal/quote1`

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

## Web

This project was generated with [angular-cli](https://github.com/angular/angular-cli) version 1.0.0-beta.26.

### Code scaffolding

These are the commands that generate most of the application : 

* `ng new quote --prefix qt`
* `npm install ng2-bootstrap bootstrap --save`
* `ng generate component quotes`
* `ng generate service quotes`
* `ng generate component chain`
* `ng generate component aggregate`
* `ng generate component asynch`

### Development server

Before anything, you need to download the needed dependencies. You can use [Yarn](https://yarnpkg.com/) running `yarn install` under the `web` directory,. Then, run `ng serve` for a dev server. Navigate to `http://localhost:4200/`. The app will automatically reload if you change any of the source files.

### Build

Run `ng build` to build the project. The build artifacts will be stored in the `dist/` directory. Use the `-prod` flag for a production build.

### Running unit tests

Run `ng test` to execute the unit tests via [Karma](https://karma-runner.github.io).

### Running end-to-end tests

Run `ng e2e` to execute the end-to-end tests via [Protractor](http://www.protractortest.org/).
Before running the tests make sure you are serving the app via `ng serve`.

### Deploying to GitHub Pages

Run `ng github-pages:deploy` to deploy to GitHub Pages.

### Further help

To get more help on the `angular-cli` use `ng help` or go check out the [Angular-CLI README](https://github.com/angular/angular-cli/blob/master/README.md).

## Licensing

<a rel="license" href="http://creativecommons.org/licenses/by-sa/3.0/"><img alt="Creative Commons License" style="border-width:0" src="http://i.creativecommons.org/l/by-sa/3.0/88x31.png" /></a><br />This work is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by-sa/3.0/">Creative Commons Attribution-ShareAlike 3.0 Unported License</a>.

<div class="footer">
    <span class="footerTitle"><span class="uc">a</span>ntonio <span class="uc">g</span>oncalves</span>
</div>
