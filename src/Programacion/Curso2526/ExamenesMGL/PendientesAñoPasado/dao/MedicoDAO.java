package Programacion.Curso2526.ExamenesMGL.PendientesAñoPasado.dao;

import Programacion.Curso2526.ExamenesMGL.PendientesAñoPasado.comun.Datos;
import Programacion.Curso2526.ExamenesMGL.PendientesAñoPasado.db.H2Connection;
import Programacion.Curso2526.ExamenesMGL.PendientesAñoPasado.model.Medico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MedicoDAO implements MedicoDAOItf {
    Map<String, Integer> visitasMedicosHoy;

    public MedicoDAO() {
        visitasMedicosHoy = new HashMap<>();
        List<Medico> medicos = getTodosLosMedicos();
        for (Medico m : medicos) {
            visitasMedicosHoy.put(m.getIdMedico(), 0);
        }
    }

    public void insertMedico(Medico medico) {
        String sql = "INSERT INTO " + Datos.NOMBRETABLAMEDICOS +
                " (idMedico, horaInicio, horaFin, pacientesAtendidos) VALUES (?, ?, ?, ?)";
        try (Connection conn = H2Connection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, medico.getIdMedico());
            pstmt.setInt(2, medico.getHoraInicio());
            pstmt.setInt(3, medico.getHoraFin());
            pstmt.setInt(4, medico.getNumPacientesAtendidos());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            // Manejar la excepción de clave duplicada si es necesario
            if (e.getErrorCode() == 23505) { // Error code for duplicate key in H2
                // System.err.println("El médico con ID " + medico.getIdMedico() + " ya existe.");
            } else {
                e.printStackTrace();
            }
        }
    }

    public Medico getMedicoById(String idMedico) {
        /*1D-Rellenar el código para obtener el médico de idMedicode la BD*/
        String sql = "SELECT idMedico, horaInicio, horaFin, pacientesAtendidos FROM " + Datos.NOMBRETABLAMEDICOS + " WHERE idMedico = ?";
        try (Connection conn = H2Connection.getConnection();
             java.sql.PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, idMedico);
            java.sql.ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Medico(rs.getString("idMedico"),
                        rs.getInt("horaInicio"),
                        rs.getInt("horaFin"),
                        rs.getInt("pacientesAtendidos"));
            }
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean medicoAdmiteVisitas(String idMedico) {
    /*2D-Rellenar el código para que, sin consultar la BD, se devuelva si el paciente
     ya no puede admitir más visitas, porque el cupo de hoy está lleno o no
     */
        if (!visitasMedicosHoy.containsKey(idMedico)) {
            return false;
        }
        Medico medico = getMedicoById(idMedico);
        if (medico == null) {
            return false;
        }
        // Calcular cuántos pacientes puede atender este día
        int horasDisponibles = medico.getHoraFin() - medico.getHoraInicio();
        int capacidadDia = horasDisponibles * 4; // 4 pacientes por hora

        // Verificar si ya ha llegado al máximo
        return visitasMedicosHoy.get(idMedico) < capacidadDia;
    }

    public void anadirVisitaMedico(String idMedico) {
        /*3D-Rellenar el código para grabar en la BD que el médico ha atendido a un paciente más */
        String sql = "UPDATE " + Datos.NOMBRETABLAMEDICOS + " SET pacientesAtendidos = pacientesAtendidos + 1 WHERE idMedico = ?";
        try (Connection conn = H2Connection.getConnection();
             java.sql.PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, idMedico);
            pstmt.executeUpdate();
            // Actualizar también el registro en memoria
            if (visitasMedicosHoy.containsKey(idMedico)) {
                visitasMedicosHoy.put(idMedico, visitasMedicosHoy.get(idMedico) + 1);
            }
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Medico> getTodosLosMedicos() {
        /*4D-Rellenar el código para obtener todos los médicos de la BD*/
        List<Medico> medicos = new ArrayList<>();
        String sql = "SELECT idMedico, horaInicio, horaFin, pacientesAtendidos FROM " + Datos.NOMBRETABLAMEDICOS;
        try (Connection conn = H2Connection.getConnection();
             java.sql.Statement stmt = conn.createStatement();
             java.sql.ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                medicos.add(new Medico(rs.getString("idMedico"),
                        rs.getInt("horaInicio"),
                        rs.getInt("horaFin"),
                        rs.getInt("pacientesAtendidos")));
            }
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
        return medicos;
    }
}