package com.example.fromfridgetoplate.logic.dao;

import com.example.fromfridgetoplate.logic.bean.RiderPrefBean;
import com.example.fromfridgetoplate.logic.model.Rider;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class RiderDAO {
    private Connection connection;

    public RiderDAO(Connection connection) {
        this.connection = connection;
    }

    // Metodo per ottenere i rider disponibili
    public List<Rider> getAvailableRiders(RiderPrefBean rpBean) {
        List<Rider> availableRiders = new ArrayList<>();
        CallableStatement cstmt = null;
        ResultSet rs = null;

        try {
            cstmt = connection.prepareCall("{CALL GetAvailableRiders(?)}");// la stored procedure ritornerà un result_set con
            // i riders operanti in quella città(indiciata da pBean.getCity())
            cstmt.setString(1, rpBean.getCity());

            rs = cstmt.executeQuery();

            while (rs.next()) {
                Rider rider = new Rider(
                        rs.getInt("Id"),
                        rs.getString("Email"),
                        rs.getString("U_Password"),
                        rs.getString("Nome"),
                        rs.getString("Cognome")
                );
                // non sono inizializzati dal costruttore, perchè quando
                // viene creato un rider, si suppone che quei campi potrebbero ancora non essere decisi al momento della creazione
                // rider.setAvailable(rs.getBoolean("isAvailable")); // questo sarà sempre true
                rider.setAssignedCity(rs.getString("assignedCity"));
                availableRiders.add(rider);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Gestione delle eccezioni
        } finally {

            closeQuietly(rs);
            closeQuietly(cstmt);
        }

        return availableRiders;
    }

    //public void updateA








    // Metodo per chiudere le risorse in modo sicuro
    void closeQuietly(AutoCloseable resource) {
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



