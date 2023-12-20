package com.example.fromfridgetoplate.logic.bean;

import java.util.List;

public class OrderListBean {
    private List<OrderBean> orderBeans;

    // Costruttore
    public OrderListBean() {
    }

    // Metodo getter per ottenere la lista di OrderBean
    public List<OrderBean> getOrderBeans() {
        return orderBeans;
    }

    // Metodo setter per impostare la lista di OrderBean
    public void setOrderBeans(List<OrderBean> orderBeans) {
        this.orderBeans = orderBeans;
    }

    // Eventuali altri metodi utili per la gestione della lista di ordini,
    // come metodi per aggiungere o rimuovere ordini, ecc.
}