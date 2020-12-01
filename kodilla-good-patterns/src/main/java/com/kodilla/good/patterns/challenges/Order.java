package com.kodilla.good.patterns.challenges;

import java.time.LocalDateTime;

public class Order {
    private Customer customer;
    private Product product;
    private LocalDateTime deliveryTime;

    public Order(Customer customer, Product product, LocalDateTime deliveryTime) {
        this.customer = customer;
        this.product = product;
        this.deliveryTime = deliveryTime;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Product getProduct() {
        return product;
    }

    public LocalDateTime getDeliveryTime() {
        return deliveryTime;
    }
}
