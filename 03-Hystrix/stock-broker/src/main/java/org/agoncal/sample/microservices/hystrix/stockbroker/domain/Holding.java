package org.agoncal.sample.microservices.hystrix.stockbroker.domain;

public class Holding {

    private String user;
    private String ticker;
    private String nbShares;
    private double price;

    public Holding(String ticker, double price) {
        this.ticker = ticker;
        this.price = price;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public String getNbShares() {
        return nbShares;
    }

    public void setNbShares(String nbShares) {
        this.nbShares = nbShares;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
