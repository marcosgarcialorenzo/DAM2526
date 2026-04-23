package Programacion.Curso2526.M.M2.ui;

import Programacion.Curso2526.M.M2.DAO.DAOCocheImpl;
import Programacion.Curso2526.M.M2.configuracion.ConexionBD;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import static Programacion.Curso2526.M.M2.servivcio.servicios.ejecutarMenu;

public class Main {
    public static void main(String[] args) {
        ConexionBD conexion = new ConexionBD();
        try (Connection con = conexion.getConexionBD()) {
            System.out.println("Conexión BD establecida");
            DAOCocheImpl dao = new DAOCocheImpl(con);
            ejecutarMenu(dao);
        } catch (SQLException | ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }
}