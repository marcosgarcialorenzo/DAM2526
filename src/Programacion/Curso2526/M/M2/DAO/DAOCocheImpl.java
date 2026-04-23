package Programacion.Curso2526.M.M2.DAO;

import Programacion.Curso2526.M.M2.modelo.Coche;
import Programacion.Curso2526.M.M3.Persona;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
    public boolean eliminarCoche(String matricula) {
        try {
            PreparedStatement ps = conexion.prepareStatement("DELETE FROM BDPRUEBA1.COCHES WHERE matricula=?");
            ps.setString(1, matricula);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean actualizarPreciosCoches(double incremento) {
        try {
            PreparedStatement ps = conexion.prepareStatement("UPDATE BDPRUEBA1.COCHES SET precio=precio*?");
            ps.setDouble(1, incremento);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public List<Coche> obtenerCoches() {
        List<Coche> coches = new ArrayList<>();
        try {
            PreparedStatement ps = conexion.prepareStatement("SELECT * FROM BDPRUEBA1.COCHES ");
            ResultSet cocheAux = ps.executeQuery();
            while (cocheAux.next()) {
                String matricula = cocheAux.getString("Matricula");
                String modelo = cocheAux.getString("MODELO");
                int antiguedad = cocheAux.getInt("ANTIGUEDAD");
                double precio = cocheAux.getDouble("PRECIO");
                Coche c = new Coche(matricula, modelo, antiguedad, precio);
                coches.add(c);
            }
            return coches;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return coches;
        }
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