package com.example.fromfridgetoplate.logic.dao;

import com.example.fromfridgetoplate.logic.model.Order;
import com.example.fromfridgetoplate.logic.model.OrderList;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDAO {
    private Connection connection;

    public OrderDAO(Connection connection) {
        this.connection = connection;
    }

    public OrderList getPendingOrders() {
        OrderList orderList = new OrderList();
        CallableStatement cstmt = null;
        ResultSet rs = null;

        try {
            cstmt = connection.prepareCall("{CALL GetPendingOrders()}");
            rs = cstmt.executeQuery();

            while (rs.next()) {

                Order order = new Order(
                        rs.getInt("orderId"),
                        rs.getInt("NegozioId"),
                        rs.getInt("CustomerId"),
                        new ArrayList<>(), //  gli 'Item' saramno gestiti poi in modo separato
                        rs.getTimestamp("orderTime").toLocalDateTime(),
                        rs.getTimestamp("deliveryTime").toLocalDateTime()
                );
                order.setStatus(rs.getString("status")); // questo serve solo per vedere se prende gli ordini pronti
                order.setIsAcceptedByRider(rs.getBoolean("isAcceptedByRider")); // da moddare
                // Impostare altri campi x futuro se serve
                orderList.addOrder(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Gestione delle eccezioni
        } finally {
            // Chiudi CallableStatement e ResultSet in modo sicuro
            closeQuietly(rs);
            closeQuietly(cstmt);
        }

        return orderList;
    }

    // Metodo per stampare le informazioni dell'ordine a schermo, solo per vedere se le retrieva corretly
    public void printOrders(OrderList orderList) {
        for (Order order : orderList.getOrders()) {
            System.out.println("OrderId: " + order.getOrderId() +
                    ", RivenditaId: " + order.getRetailerId() +
                    ", CustomerId: " + order.getCustomerId() +
                    ", Status: " + order.getStatus() +
                    ", OrderTime: " + order.getOrderTime() +
                    ", DeliveryTime: " + order.getDeliveryTime() +
                    ", IsAcceptedByRider: " + order.isAcceptedByRider());
        }
    }

    // Metodo dal china
    private void closeQuietly(AutoCloseable resource) {
        if (resource != null) {
            try {
                resource.close();
            } catch (Exception e) {
                // Log dell'eccezione silenziosa se necessario
                e.printStackTrace();
            }
        }
    }
}
