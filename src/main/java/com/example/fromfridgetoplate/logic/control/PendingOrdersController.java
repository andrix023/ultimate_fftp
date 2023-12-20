package com.example.fromfridgetoplate.logic.control;

import com.example.fromfridgetoplate.logic.bean.OrderBean;
import com.example.fromfridgetoplate.logic.bean.OrderListBean;
import com.example.fromfridgetoplate.logic.dao.OrderDAO;
import com.example.fromfridgetoplate.logic.model.Order;
import com.example.fromfridgetoplate.logic.model.OrderList;
import com.example.fromfridgetoplate.patterns.factory.DAOFactory;

import java.util.ArrayList;
import java.util.List;

public class PendingOrdersController {
    // Metodo per ottenere un OrderListBean con gli ordini pendenti
    public OrderListBean getPendingOrderListBean() {
        // Chiamata al DAO per ottenere la lista di ordini pendenti
        DAOFactory daoFactory = new DAOFactory();
        OrderDAO order_dao = daoFactory.getOrderDAO();
        OrderList orderList = order_dao.getPendingOrders();

        // Creazione di un nuovo OrderListBean
        OrderListBean orderListBean = new OrderListBean();

        // Creazione di una nuova lista vuota per i OrderBean
        List<OrderBean> orderBeans = new ArrayList<>();

        // Ottieni la lista degli ordini dall'OrderList
        List<Order> orders = orderList.getOrders();

        // Itera su ciascun ordine e converte ciascuno in OrderBean
        for (Order order : orders) {
            OrderBean orderBean = convertToOrderBean(order);
            orderBeans.add(orderBean);
        }

        // setta la lista di OrderBean nel OrderListBean
        orderListBean.setOrderBeans(orderBeans);


        return orderListBean;
    }



    private OrderBean convertToOrderBean(Order order) {
        OrderBean orderBean = new OrderBean();

        // Impostiamo i valori nel 'OrderBean usando i dati dall'istanza di Order
        orderBean.setOrderId(order.getOrderId());
        orderBean.setCustomerId(order.getCustomerId());
        //orderBean.setFoodItems(order.getItems()); //  getItems() restituisca una lista di food_item
        orderBean.setOrderTime(order.getOrderTime());

        return orderBean;
    }
    /**L'implementazione della bean ci assicura che tutti i dati rilevanti dell'ordine (orderId, customerId, foodItems, orderTime)
     * vengano trasferiti dall'entità Order al Bean OrderBean.
     * cosi facciamo una separazione tra la rappresentazione
     * dei dati nell'ambito della logica di business (cioè l'entità Order) e la trasmissione
     * dei dati tra la logica di business e la parte grafica (Bean OrderBean).**/



// main per provare se i dati sono giusti prima di passarli alla view
    public static void main(String[] args) {
        PendingOrdersController controller = new PendingOrdersController();
        OrderListBean orderListBean = controller.getPendingOrderListBean();

        for (OrderBean orderBean : orderListBean.getOrderBeans()) {
            // Stampa i dettagli di ogni OrderBean
            System.out.println("Order ID: " + orderBean.getOrderId());
            System.out.println("Customer ID: " + orderBean.getCustomerId());
            System.out.println("Order Time: " + orderBean.getOrderTime());
            //System.out.print("Food Items: ");
            // for (food_item item : orderBean.getFoodItems()) {
            //        System.out.print(item.getName() + ", "); // a food_item bisognerebbe aggiungere un metodo getName()
            //    }
            System.out.println("\n-------------------------------------");
        }
    }



}
