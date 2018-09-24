# Sample - Micro Services - Hystrix

## Purpose of this sample

The purpose of this sample is to show you how to add Hystrix in between 2 microservices.

## Stock Price

This microservice returns a price for a stock. The URL to get a price is:

```
http://localhost:8083/price/api/getTickerPrice/{ticker name}
```

This microservice is built so it fails randomly and takes random time to return a price. To stress this endpoint and see the failures, use the [ab](https://httpd.apache.org/docs/2.4/programs/ab.html) stress tool:

```
ab -n 500 -c 10 http://127.0.0.1:8083/price/api/getTickerPrice/blahblah
```

This sample uses Gatling for stress testing. Execute Gatling with:

```
$ mvn gatling:test
```

This previous command will hit 500 requests, 10 at a time 

## Licensing

<a rel="license" href="http://creativecommons.org/licenses/by-sa/3.0/"><img alt="Creative Commons License" style="border-width:0" src="http://i.creativecommons.org/l/by-sa/3.0/88x31.png" /></a><br />This work is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by-sa/3.0/">Creative Commons Attribution-ShareAlike 3.0 Unported License</a>.

<div class="footer">
    <span class="footerTitle"><span class="uc">a</span>ntonio <span class="uc">g</span>oncalves</span>
</div>
