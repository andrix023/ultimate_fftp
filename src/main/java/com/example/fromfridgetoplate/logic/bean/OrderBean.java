package com.example.fromfridgetoplate.logic.bean;


import com.example.fromfridgetoplate.logic.model.FoodItem;

import java.time.LocalDateTime;
import java.util.List;

public class OrderBean {
    private int orderId;
    private int customerId;
    private List<FoodItem> foodItems; // food_item alias ingrediente, ancora da definire
    private LocalDateTime orderTime;

    // Costruttore
    public OrderBean() {
        // Costruttore di default
    }

    // Metodi getter e setter per ciascun campo
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public List<FoodItem> getFoodItems() {
        return foodItems;
    }

    public void setFoodItems(List<FoodItem> foodItems) {
        this.foodItems = foodItems;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }

    // Altri metodi utili
}
