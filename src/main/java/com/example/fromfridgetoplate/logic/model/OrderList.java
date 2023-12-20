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

        // Altri metodi utili per la gestione della lista di ordini
}
