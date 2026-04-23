package Programacion.Curso2526.M.M2.DAO;

import Programacion.Curso2526.M.M2.modelo.Coche;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOCocheImpl implements DAOCoche {
    private Connection conexion = null;

    public DAOCocheImpl(Connection con) {
        this.conexion = con;
    }

    @Override
    public boolean insertarCoche(Coche c) {
        try {
            PreparedStatement ps = conexion.prepareStatement("INSERT INTO BDPRUEBA1.COCHES (Matricula, MODELO, ANTIGUEDAD, PRECIO) VALUES (?,?,?,?)");
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
            PreparedStatement ps = conexion.prepareStatement("DELETE FROM BDPRUEBA1.COCHES WHERE Matricula=?");
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
            PreparedStatement ps = conexion.prepareStatement("UPDATE BDPRUEBA1.COCHES SET PRECIO=PRECIO*?");
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
    public double sumarPreciosCochesPorAntiguedad(int antiguedad) {
        double suma = 0;
        try {
            PreparedStatement ps = conexion.prepareStatement("SELECT SUM(precio) AS suma FROM BDPRUEBA1.COCHES WHERE ANTIGUEDAD=?");
            ps.setInt(1, antiguedad);
            ResultSet cocheAux = ps.executeQuery();
            if (cocheAux.next()) {
                suma = cocheAux.getDouble("suma");
            }
            return suma;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return suma;
        }
    }

    @Override
    public List<String> obtenerMatriculasPorMarca(String modelo) { //TOYOTA-YARIS
        List<String> matriculas = new ArrayList<>();
        String marca = modelo.split("-")[0]; //TOYOTA
        try (PreparedStatement ps = conexion.prepareStatement("SELECT Matricula FROM BDPRUEBA1.COCHES WHERE UPPER(MODELO) LIKE ?")) {
            ps.setString(1, marca.trim().toUpperCase() + "-%");
            try (ResultSet matriculaAux = ps.executeQuery()) {
                while (matriculaAux.next()) {
                    String matricula = matriculaAux.getString("Matricula");
                    matriculas.add(matricula);
                }
            }
            return matriculas;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return matriculas;
        }
    }
}