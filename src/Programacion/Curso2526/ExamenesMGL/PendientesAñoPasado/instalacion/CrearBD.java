package Programacion.Curso2526.ExamenesMGL.PendientesAñoPasado.instalacion;

import Programacion.Curso2526.ExamenesMGL.PendientesAñoPasado.comun.Datos;
import Programacion.Curso2526.ExamenesMGL.PendientesAñoPasado.dao.MedicoDAO;
import Programacion.Curso2526.ExamenesMGL.PendientesAñoPasado.db.H2Connection;
import Programacion.Curso2526.ExamenesMGL.PendientesAñoPasado.model.Medico;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author josema
 * En esta clase creamos la BD la primera vez que ejecutamos la aplicación.
 */
public class CrearBD {
    public static void crearTablaMedicos() {
        String sql = "CREATE TABLE IF NOT EXISTS " + Datos.NOMBRETABLAMEDICOS + " (" +
                "idMedico VARCHAR(6) PRIMARY KEY," +
                "horaInicio INT DEFAULT 0," +
                "horaFin INT DEFAULT 0," +
                "pacientesAtendidos INT DEFAULT 0)";
        try (Connection conn = H2Connection.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabla medicos creada o ya existente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void cargarDatosInicialesMedicos() {
        // Solo inserta si la tabla está vacía o si quieres re-insertar
        // Esto es para propósitos de prueba. En una aplicación real, los datos
        // se manejarían de forma diferente.
        MedicoDAO medicoDAO = new MedicoDAO();
        if (medicoDAO.getTodosLosMedicos().isEmpty()) { // Verificar si hay películas de algún tipo
            medicoDAO.insertMedico(new Medico("C00001", 10, 14));
            medicoDAO.insertMedico(new Medico("C00002", 12, 15));
            medicoDAO.insertMedico(new Medico("T00001", 10, 13));
            medicoDAO.insertMedico(new Medico("T00002", 10, 12));
            medicoDAO.insertMedico(new Medico("C00003", 15, 19));
            medicoDAO.insertMedico(new Medico("E00001", 10, 14));
            medicoDAO.insertMedico(new Medico("C00004", 16, 22));
        }
    }

    private static void eliminarTablaBD() {
        String sql = "DROP TABLE IF EXISTS " + Datos.NOMBRETABLAMEDICOS;
        try (Connection conn = H2Connection.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabla Medicos eliminada.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("Inicio instalación");
        crearTablaMedicos();
        cargarDatosInicialesMedicos();
        //eliminarTablaBD();
    }
}