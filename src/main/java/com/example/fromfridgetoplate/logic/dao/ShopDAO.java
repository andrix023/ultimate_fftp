package com.example.fromfridgetoplate.logic.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class ShopDAO {
    public boolean saveShop(String email, String password, String name, String VATnumber, String address){
        Connection connection = SingletonConnector.getInstance().getConnection();

        try(CallableStatement cs = connection.prepareCall("{call registerShop(?,?,?,?,?)}")){
            cs.setString(1,email);
            cs.setString(2,password);
            cs.setString(3,name);
            cs.setString(4,VATnumber);
            cs.setString(5,address);
            cs.executeQuery();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return true; /*potrei farlo meglio, non sono neanche sicurissimo sia corretto far tornare un booleano*/
    }
}
