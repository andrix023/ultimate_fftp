package com.example.fromfridgetoplate.patterns.factory;

import com.example.fromfridgetoplate.logic.dao.OrderDAO;
import com.example.fromfridgetoplate.logic.dao.SingletonConnector;

public class DAOFactory {
        public  OrderDAO getOrderDAO() {
            return new OrderDAO(SingletonConnector.getInstance().getConnection());
        }

        // Altri metodi per gli altri DAo
}
