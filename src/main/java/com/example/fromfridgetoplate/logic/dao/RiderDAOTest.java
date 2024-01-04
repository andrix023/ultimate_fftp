package com.example.fromfridgetoplate.logic.dao;

import com.example.fromfridgetoplate.logic.model.OrderList;
import com.example.fromfridgetoplate.logic.model.Rider;
import com.example.fromfridgetoplate.patterns.factory.DAOFactory;

import java.sql.Connection;
import java.util.List;



public class RiderDAOTest {
    public static void main(String[] args) {

        Connection connection = null;
        DAOFactory daoFactory = new DAOFactory();

        RiderDAO riderDao = daoFactory.getRidersDAO();


        try {
            // Ottieni la lista dei rider disponibili
            List<Rider> availableRiders = riderDao.getAvailableRiders();

            // Stampa i dettagli dei rider
            for (Rider rider : availableRiders) {
                System.out.println("Rider ID: " + rider.getId() +
                        ", Name: " + rider.getName() +
                        ", Surname: " + rider.getSurname() +
                        ", Assigned City: " + rider.getAssignedCity());
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Gestione delle eccezioni
        } finally {
            // Chiudi la connessione in modo sicuro
            riderDao.closeQuietly(connection);
        }
    }

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
