package Programacion.Curso2526.M.M2.configuracion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    private Connection conexion = null;

    public Connection getConexionBD() throws SQLException, ClassNotFoundException {
        String controladorBD = "org.h2.Driver"; //Será diferente para mysql, oracle, etc.+
        Class.forName(controladorBD);
        if (conexion == null) {
            String usuario = "sa";
            String password = "";
            String urlBD = "jdbc:h2:~/test";
            conexion = DriverManager.getConnection(urlBD, usuario, password);
        }
        return conexion;
    }
}