package Programacion.Curso2526.M.Pizzeria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionH2 {
    private static final String URL = "jdbc:h2:~/CalculadoraBinaria";
    private static final String USER = "sa";
    private static final String PASSWORD = "";

    public static Connection getConexion() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}