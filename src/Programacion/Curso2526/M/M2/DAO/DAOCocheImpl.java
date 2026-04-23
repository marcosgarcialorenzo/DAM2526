package Programacion.Curso2526.M.M2.DAO;

import Programacion.Curso2526.M.M2.modelo.Coche;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class DAOCocheImpl implements DAOCoche {
    private Connection conexion = null;

    @Override
    public boolean insertarCoche(Coche c) {
        try {
            PreparedStatement ps = conexion.prepareStatement("INSERT INTO BDPRUEBA1.COCHES (matricula, modelo, antiguedad, precio) VALUES (?,?,?,?)");
            ps.setString(1, c.getMatricula());
            ps.setString(2, c.getModelo());
            ps.setInt(3, c.getAntiguedad());
            ps.setDouble(4, c.getPrecio());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean eliminarCoche(int id) {
        return false;
    }

    @Override
    public boolean actualizarPreciosCoches(Coche c) {
        return false;
    }

    @Override
    public List<Coche> obtenerCoches(String modelo) {
        return List.of();
    }

    @Override
    public double sumarPreciosCochesPorAntiguedad(Coche c) {
        return 0;
    }

    @Override
    public List<String> obtenerMatriculasPorMarca(String marca) {
        return List.of();
    }
}