package com.example.fromfridgetoplate.guicontrollers;


import com.example.fromfridgetoplate.logic.bean.OrderListBean;
import com.example.fromfridgetoplate.logic.control.PendingOrdersController;
import com.example.fromfridgetoplate.logic.model.Order;

import java.util.List;

public class PendingOrdersGraphicController {
    public void loadData() {
        // Chiama il controller applicativo per ottenere i dati
        PendingOrdersController pendingOrdersControl = new PendingOrdersController();
        OrderListBean orderListBean = pendingOrdersControl.getPendingOrderListBean();


        //updateUI(pendingOrders); ??
    }

    private void updateUI(List<Order> orders) {
        // Aggiorna gli elementi della UI (ad esempio, una ListView) con gli ordini
    }
}
