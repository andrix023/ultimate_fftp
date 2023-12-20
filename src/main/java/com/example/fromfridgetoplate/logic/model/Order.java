package com.example.fromfridgetoplate.logic.model;

import java.time.LocalDateTime;
import java.util.List;

public class Order {

    private int orderId;

    private int customerId;

    private int retailerId;

    private int riderId;

    private String status; // "Pending", "Accepted", "Delivered"........altri?

    private List<FoodItem> foodItems; // Una lista degli ingredienti alimentari ordinati

    private LocalDateTime orderTime;

    private LocalDateTime deliveryTime;

    private boolean isAcceptedByRider;


    // Costruttore
    public Order(int orderId, int customerId, int retailerId, List<FoodItem> items, LocalDateTime orderTime, LocalDateTime deliveryTime) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.retailerId = retailerId;
        this.foodItems = items;
        this.orderTime = orderTime;
        this.status = "Pending";
        this.isAcceptedByRider = false;
    }

    // Metodi getter e setter
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

    public int getRetailerId() {
        return retailerId;
    }

    public void setRetailerId(int retailerId) {
        this.retailerId = retailerId;
    }

    public int getRiderId() {
        return riderId;
    }

    public void setRiderId(int riderId) {
        this.riderId = riderId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<FoodItem> getItems() {
        return foodItems;
    }

    public void setItems(List<FoodItem> items) {
        this.foodItems = items;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }

    public LocalDateTime getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(LocalDateTime deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public boolean isAcceptedByRider() {
        return isAcceptedByRider;
    }

    public void setAcceptedByRider(boolean acceptedByRider) {
        isAcceptedByRider = acceptedByRider;
    }


/** questi metodi che seguono son un pò dubbi, sopratutto acceptOrderByRider dovrebbe prendersi come paramentro l'entitò Rider e non solo l'id**/

    // Altri metodi, come per accettare l'ordine da parte del rider
    public void acceptOrderByRider(int riderId) {
        this.riderId = riderId;
        this.isAcceptedByRider = true;
        this.status = "in consegna";
    }



    // Metodo per aggiornare lo stato dell'ordine
    public void updateStatus(String status) {
        this.status = status;
    }



    // Esempio di metodo per calcolare il tempo stimato di consegna
    public void estimateDeliveryTime() {
        // Implementa la logica per calcolare il tempo di consegna
    }

    public void setIsAcceptedByRider(boolean isAcceptedByRider) {
    }


    // E altri metodi utili per la gestione dell'ordine


}
