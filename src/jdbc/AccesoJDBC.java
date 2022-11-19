package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class AccesoJDBC {

    public static final String DRIVER_SQLITE = "org.sqlite.JDBC";

    public static final String DBURL_SQLITE = "jdbc:sqlite:tablaTP.sqlite";

    // method to create JDBC connections
    public static Connection createConnection() {
        // Use DRIVER and DBURL to create a connection

        Connection conexion = null;
        try {
            Class.forName(DRIVER_SQLITE);

            conexion = DriverManager.getConnection(DBURL_SQLITE);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return conexion;
    }

    }
