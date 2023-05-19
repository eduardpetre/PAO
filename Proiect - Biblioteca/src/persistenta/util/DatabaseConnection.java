package persistenta.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String POSTGRES_JDBC_DRIVER = "org.postgresql.Driver";
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "123456";


    private Connection connection;

    private static volatile DatabaseConnection init;

    private DatabaseConnection() {
        try {
            Class.forName(POSTGRES_JDBC_DRIVER);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.out.println("Driverul pentru baza de date nu a fost gasit: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Nu se poate realiza conexiunea la baza de date: " + e.getMessage());
        }
        System.out.println("Conexiunea la baza de date s-a realizat cu succes!");
    }


    public static Connection getDatabaseConnection() {
        if (init == null) {
            synchronized (DatabaseConnection.class) {
                if (init == null) {
                    init = new DatabaseConnection();
                }
            }
        }
        return init.connection;
    }

}