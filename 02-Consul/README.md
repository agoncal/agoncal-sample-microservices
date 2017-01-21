# Sample - Micro Services - Consul and Wildfly Swarm

## Purpose of this sample

The purpose of this sample is to show you how WildFly Swarm Topology interacts with Consul.

* Using JAX-RS Endpoints
* Using Consul

[Read more on my blog](http://antoniogoncalves.org/2011/01/12/bootstrapping-cdi-in-several-environments/)

## Consul

Start consul :

    $ consul agent -dev

Check the Admin Console at [http://localhost:8500/ui]()

Check the [REST APIs](https://www.consul.io/docs/agent/http.html) at :

* [http://localhost:8500/v1/catalog/nodes]()
* [http://localhost:8500/v1/catalog/services]()
* [http://localhost:8500/v1/catalog/service/quote1]()

# Licensing

<a rel="license" href="http://creativecommons.org/licenses/by-sa/3.0/"><img alt="Creative Commons License" style="border-width:0" src="http://i.creativecommons.org/l/by-sa/3.0/88x31.png" /></a><br />This work is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by-sa/3.0/">Creative Commons Attribution-ShareAlike 3.0 Unported License</a>.

<div class="footer">
    <span class="footerTitle"><span class="uc">a</span>ntonio <span class="uc">g</span>oncalves</span>
</div>