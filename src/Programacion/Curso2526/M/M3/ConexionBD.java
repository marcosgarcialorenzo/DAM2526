package Programacion.Curso2526.M.M3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    private String usuario = "sa";
    private String password = "";
    private String urlBD = "jdbc:h2:~/test";
    private String ControladorBD = "org.h2.Driver"; //Será diferente para mysql, oracle, etc.+
    private Connection conexion = null;

    public Connection getConexionBD() throws SQLException, ClassNotFoundException {
        Class.forName(ControladorBD);
      if (conexion == null) {
        conexion = DriverManager.getConnection(urlBD, usuario, password);
      }
        return conexion;
    }
}