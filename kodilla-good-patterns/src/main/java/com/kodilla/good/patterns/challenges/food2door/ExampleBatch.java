package com.kodilla.good.patterns.challenges.food2door;

import com.kodilla.good.patterns.challenges.food2door.producers.ExtraFoodShop;
import com.kodilla.good.patterns.challenges.food2door.producers.GlutenFreeShop;
import com.kodilla.good.patterns.challenges.food2door.producers.HealthyShop;

public class ExampleBatch {

    public void exampleData() {

        Customer customer1 = new Customer("Hieronim", "Warszawa", "Krucza 3", "00-134");
        Customer customer2 = new Customer("Andrzej", "Kraków", "Wawelska 9", "33-291");
        Customer customer3 = new Customer("Jessica", "Los Angeles", "Blabla 2", "00-000");
        Product product1 = new Product("Apple", 2);
        Product product2 = new Product("Yoghurt", 4);
        Product product3 = new Product("Pasta", 15);
        Product product4 = new Product("Orange juice", 10);

        ExtraFoodShop extraFoodShop = new ExtraFoodShop();
        GlutenFreeShop glutenFreeShop = new GlutenFreeShop();
        HealthyShop healthyShop = new HealthyShop();
        ShippingService shippingService = new ShippingService();

        OrderPosition orderPosition1 = new OrderPosition(product1, 5);
        OrderPosition orderPosition2 = new OrderPosition(product2, 3);
        OrderPosition orderPosition3 = new OrderPosition(product3, 2);
        OrderPosition orderPosition4 = new OrderPosition(product4, 6);

        extraFoodShop.addOrderPosition(orderPosition3);
        glutenFreeShop.addOrderPosition(orderPosition2);
        healthyShop.addOrderPosition(orderPosition1);
        healthyShop.addOrderPosition(orderPosition4);

        shippingService.addNewOrder(healthyShop, customer1, orderPosition1);
        shippingService.addNewOrder(extraFoodShop, customer2, orderPosition3);
        shippingService.addNewOrder(healthyShop, customer3, orderPosition4);
        shippingService.addNewOrder(glutenFreeShop, customer3, orderPosition2);

        System.out.println("HealthyShop order list:\n" + shippingService.getOrderListOfProducer(healthyShop));
        System.out.println("ExtraFoodShop order list:\n" + shippingService.getOrderListOfProducer(extraFoodShop));
        System.out.println("GlutenFoodShop order list:\n" + shippingService.getOrderListOfProducer(glutenFreeShop));

        shippingService.process(healthyShop);
        shippingService.process(extraFoodShop);

        System.out.println(shippingService.getActiveOrders().size());
    }
}
