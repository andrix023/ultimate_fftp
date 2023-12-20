package com.example.fromfridgetoplate.logic.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class SingletonConnector {
    private Connection connection;
    private static SingletonConnector myConnector;

    private SingletonConnector() {

        try (InputStream is = new FileInputStream("src/main/resources/com/example/Properties/db_config.properties")){
            Properties prop = new Properties();

            prop.load(is);

            String userConfig = prop.getProperty("USER");
            String passConfig = prop.getProperty("PASS");
            String dbUrlConfig = prop.getProperty("DB_URL");
            connection = DriverManager.getConnection(dbUrlConfig, userConfig, passConfig);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        catch(SQLException e) {
            e.getMessage();
        }
    }
    public static SingletonConnector getInstance(){
        if(myConnector == null){
            myConnector = new SingletonConnector();
        }
        return myConnector;
    }
    public Connection getConnection() {return connection;}
}
