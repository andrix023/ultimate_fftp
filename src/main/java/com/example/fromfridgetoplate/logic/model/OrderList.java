package com.example.fromfridgetoplate.logic.model;

import java.util.ArrayList;
import java.util.List;

public class OrderList {

    private List<Order> orders;

    public OrderList() {
            orders = new ArrayList<>();
        }

    public void addOrder(Order order) {
            orders.add(order);
        }
    public List<Order> getOrders() {
            return orders;
        }


    public void sortByOrderTime() {
        int n = orders.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (orders.get(j).getOrderTime().isAfter(orders.get(j + 1).getOrderTime())) {
                    // Scambia orders[j+1] e orders[j]
                    Order temp = orders.get(j);
                    orders.set(j, orders.get(j + 1));
                    orders.set(j + 1, temp);
                }
            }
        }
    }
}
