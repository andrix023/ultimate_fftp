import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class SingletonConnector {
    private Connection connection;
    private static volatile SingletonConnector myConnector;

    private SingletonConnector() {
        try (InputStream is = new FileInputStream("src/main/resources/com/example/Properties/db_config.properties")) {
            Properties prop = new Properties();
            prop.load(is);
            String userConfig = prop.getProperty("USER");
            String passConfig = prop.getProperty("PASS");
            String dbUrlConfig = prop.getProperty("DB_URL");
            connection = DriverManager.getConnection(dbUrlConfig, userConfig, passConfig);
        } catch (IOException e) {
            // Log or handle the IOException appropriately
            e.printStackTrace();
        } catch (SQLException e) {
            // Log or handle the SQLException appropriately
            e.printStackTrace();
        }
    }

    public static SingletonConnector getInstance() {
        if (myConnector == null) {
            synchronized (SingletonConnector.class) {
                if (myConnector == null) {
                    myConnector = new SingletonConnector();
                }
            }
        }
        return myConnector;
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                // Log or handle the SQLException appropriately
                e.printStackTrace();
            }
        }
    }
}

