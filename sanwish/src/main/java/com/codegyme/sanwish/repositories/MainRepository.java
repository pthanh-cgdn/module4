package com.codegyme.sanwish.repositories;

import com.codegyme.sanwish.models.Order;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class MainRepository {
    static private List<Order> orders = new ArrayList<>();
    static{
        orders.add(new Order(1, new String[]{"Tomato"}));
        orders.add(new Order(2, new String[]{"Tomato","Mustard"}));
    }
    public void save(String[] condiments) {
        Order order = new Order(condiments);
        order.setId(orders.get(orders.size()-1).getId() + 1);
        orders.add(order);
    }

    public List<Order> getAll() {
        return orders;
    }
}
