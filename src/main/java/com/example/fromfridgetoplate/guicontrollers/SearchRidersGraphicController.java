package com.example.fromfridgetoplate.guicontrollers;

import com.example.fromfridgetoplate.logic.bean.OrderListBean;
import com.example.fromfridgetoplate.logic.bean.RiderBean;
import com.example.fromfridgetoplate.logic.control.PendingOrdersController;
import com.example.fromfridgetoplate.logic.model.Rider;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;

import java.util.List;


public class SearchRidersGraphicController extends GenericGraphicController {

    @FXML
    private TableView<RiderBean> RidersTable;



    private RiderSelectionListener riderSelectionListener;

    public void setRiderSelectionListener(RiderSelectionListener listener) {
        this.riderSelectionListener = listener;
    }

    // Metodo chiamato quando un rider viene selezionato
    private void selectRider(Rider rider) {


        if (riderSelectionListener != null)
        {
            riderSelectionListener.onRiderSelected(rider); // cosi passo le info del rider al controller grafico pendingOrdersGraphicController
            // Chiudi la finestra di dialogo o esegui altre operazioni necessarie
        }


    }

    public void loadData() {
        // Chiama il controller applicativo per ottenere i dati
        PendingOrdersController pendingOrdersControl = new PendingOrdersController();
        //OrderListBean orderListBean = pendingOrdersControl.getPendingOrderListBean();
        List<RiderBean> AvailableRiders = pendingOrdersControl.getAvalaibleRiders();

        // Popola la TableView con i dati
        //RidersTable.setItems(FXCollections.observableArrayList(orderListBean.getOrderBeans()));// forse questo da rivedere per
        // evitare duplicazione di codice
        //updateUI(pendingOrders); ??
        System.out.println("check");
    }
}
