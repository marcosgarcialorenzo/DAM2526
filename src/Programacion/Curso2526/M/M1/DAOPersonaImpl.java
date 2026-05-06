package Programacion.Curso2526.M.M1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOPersonaImpl implements DAOPersona {
    private Connection conexion = null;

    public DAOPersonaImpl(Connection con) {
        this.conexion = con;
    }

    @Override
    public boolean anadirPersona(Persona p) {
        try {
            //noinspection SqlResolve
            PreparedStatement ps = conexion.prepareStatement("INSERT INTO BDPRUEBA1.TABLA1PRUEBA (nombre, numero) VALUES (?,?)");
            ps.setString(1, p.nombre);
            ps.setInt(2, p.edad);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean borrarPersona(int id) {
        try {
            PreparedStatement ps = conexion.prepareStatement("DELETE FROM BDPRUEBA1.TABLA1PRUEBA WHERE id=?");
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean modificarPersona(int id, Persona p) {
        try {
            PreparedStatement ps = conexion.prepareStatement("UPDATE BDPRUEBA1.TABLA1PRUEBA SET nombre=?, numero=? WHERE id=?");
            ps.setString(1, p.nombre);
            ps.setInt(2, p.edad);
            ps.setInt(3, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public Persona buscarPersona(int id) {
        try {
            PreparedStatement ps = conexion.prepareStatement("SELECT * FROM BDPRUEBA1.TABLA1PRUEBA WHERE id=?");
            ps.setInt(1, id);
            ResultSet personaAux = ps.executeQuery();
            if (personaAux.next()) {
                String nombre = personaAux.getString("nombre");
                int edad = personaAux.getInt("numero");
                Persona p = new Persona(id, nombre, edad);
                return p;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Persona> obtenerTodasPersonas() {
        List<Persona> personas = new ArrayList<>();
        try {
            PreparedStatement ps = conexion.prepareStatement("SELECT * FROM BDPRUEBA1.TABLA1PRUEBA ");
            ResultSet personaAux = ps.executeQuery();
            while (personaAux.next()) {
                String nombre = personaAux.getString("nombre");
                int edad = personaAux.getInt("numero");
                int id = personaAux.getInt("id");
                Persona p = new Persona(id, nombre, edad);
                personas.add(p);

            }
            return personas;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return personas;
        }
    }

    @Override
    public List<Persona> obtenerPersonasPorRangoEdad(int edadMin, int edadMax) {
        List<Persona> personas = new ArrayList<>();
        try {
            PreparedStatement ps = conexion.prepareStatement(
                    "SELECT * FROM BDPRUEBA1.TABLA1PRUEBA WHERE numero BETWEEN ? AND ? ORDER BY numero");
            ps.setInt(1, edadMin);
            ps.setInt(2, edadMax);
            ResultSet personaAux = ps.executeQuery();
            while (personaAux.next()) {
                String nombre = personaAux.getString("nombre");
                int edad = personaAux.getInt("numero");
                int id = personaAux.getInt("id");
                personas.add(new Persona(id, nombre, edad));
            }
            return personas;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return personas;
        }
    }
}
