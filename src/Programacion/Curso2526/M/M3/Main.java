package Programacion.Curso2526.M.M3;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        System.out.println("Prueba conexión BD");
        ConexionBD conexion = new ConexionBD();
        try (Connection con = conexion.getConexionBD()) {
            System.out.println(con);
            DAOPersonaImpl dao = new DAOPersonaImpl(con);
            dao.anadirPersona(new Persona(1, "Rosa", 29));
            // dao.borrarPersona(5);
            dao.modificarPersona(1, new Persona(4, "Pepe2", 33));
            dao.obtenerTodasPersonas().stream().forEach(System.out::println);
            // System.out.println("Persona encontrada: "+dao.buscarPersona(1));

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}