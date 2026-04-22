package Programacion.Curso2526.M.M3;

import java.io.IOException;
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
    public void menu() throws IOException {
        Teclado t = new Teclado();
        System.out.println("1. Dar de alta");
        System.out.println("2. Dar de baja");
        System.out.println("3. Modificar edad");
        System.out.println("4. Listado personas");
        System.out.println("5. Mostrar edad media");
        System.out.println("6. Listar personas en un rango de edad");
        System.out.println("Introduce una opción");
        int opcion = t.leerInt();
        switch (opcion) {
            case 1 -> {
                System.out.println("Ingrese el nombre del persona");
            }
        }

    }

    @Override
    public boolean anadirPersona(Persona p) {
        try {
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
            ps.setInt(3, p.id);
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
            ps.executeQuery();
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
            return null;
        }
    }
}