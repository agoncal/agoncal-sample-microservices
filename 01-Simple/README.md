# Sample - CDI - Simple

## Purpose of this sample

The purpose of this sample is to show you how WildFly Swarm packages simple services and how they affect resources.

* Using a Servlet
* Using a JAX-RS Endpoint

[Read more on my blog](http://antoniogoncalves.org/2011/01/12/bootstrapping-cdi-in-several-environments/)

## Servlet

* Package the code with a simple `mvn clean package`
* Execute the jar using `java -jar target/sampleMicroServiceServlet-swarm.jar`
* Go to `http://localhost:8080/microServlet`

## JAX-RS

* Package the code with a simple `mvn clean package`
* Execute the jar using `java -jar target/sampleMicroServiceJaxRS-swarm.jar `
* Go to `http://localhost:8080/microRestEndpoint`


# Licensing

<a rel="license" href="http://creativecommons.org/licenses/by-sa/3.0/"><img alt="Creative Commons License" style="border-width:0" src="http://i.creativecommons.org/l/by-sa/3.0/88x31.png" /></a><br />This work is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by-sa/3.0/">Creative Commons Attribution-ShareAlike 3.0 Unported License</a>.

<div class="footer">
    <span class="footerTitle"><span class="uc">a</span>ntonio <span class="uc">g</span>oncalves</span>
</div>