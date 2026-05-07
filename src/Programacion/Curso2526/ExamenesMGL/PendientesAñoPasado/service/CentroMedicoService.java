package Programacion.Curso2526.ExamenesMGL.PendientesAñoPasado.service;

import Programacion.Curso2526.ExamenesMGL.PendientesAñoPasado.comun.Datos;
import Programacion.Curso2526.ExamenesMGL.PendientesAñoPasado.dao.*;
import Programacion.Curso2526.ExamenesMGL.PendientesAñoPasado.model.*;

import java.util.ArrayList;
import java.util.List;

public class CentroMedicoService {
    private PacienteDAO pacienteDao;
    private MedicoDAOItf medicoDAO;
    private VisitasHoyDAO visitasHoyDAO;

    public CentroMedicoService(MedicoDAO medicoDAO, PacienteDAO clientesDAO) throws Exception {
        this.medicoDAO = medicoDAO;
        visitasHoyDAO = new VisitasHoyDAO();
        this.pacienteDao = clientesDAO;
        if (! pacienteDao.cargarPacientes()) {
            throw new Exception("Error en fichero de pacientes");
        }
    }

    /**
     * @return turno siguiente
     */
    public int medicoAtiende(String idMedico) {
        Medico medico = medicoDAO.getMedicoById(idMedico);
        if (medico == null) {
            return - 1;
        }
        Visita vSiguiente = visitasHoyDAO.siguienteTurno(idMedico);
        if (vSiguiente == null) {
            return - 1;
        }
        // Incrementar el contador de pacientes atendidos del médico en la BD
        medicoDAO.anadirVisitaMedico(idMedico);
        // Eliminar el turno de la lista de espera
        visitasHoyDAO.eliminarVisita(vSiguiente);

        return vSiguiente.getNumTurno();
    }

    public List<String> listarVisitasHoy() {
        /*4B-Rellenar el código para devolver la lista de médicos (2) con más consultas.
         * El cálculo se tiene que realizar procesando lo que devuelve el DAO */
        List<String> visitasAux = new ArrayList<>();
        List<Visita> visitas = visitasHoyDAO.getVisitasHoy();
        if (visitas != null) {
            for (Visita v : visitas) {
                visitasAux.add(v.toString());
            }
        }
        return visitasAux;
    }

    public List<Medico> getMedicosMasConsultas(int numMedicos) {
        List<Medico> allMedicos = medicoDAO.getTodosLosMedicos();
        if (allMedicos == null || allMedicos.isEmpty()) {
            return new ArrayList<>();
        }

        // Ordenar por numero de pacientes atendidos en orden descendente
        allMedicos.sort((m1, m2) -> Integer.compare(m2.getNumPacientesAtendidos(), m1.getNumPacientesAtendidos()));

        // Retornar los primeros numMedicos
        if (allMedicos.size() <= numMedicos) {
            return allMedicos;
        }
        return allMedicos.subList(0, numMedicos);
    }

    public void guardarPacientes() {
        pacienteDao.guardarPacientes();
        System.out.println("Pacientes guardados en " + Datos.NOMBREFICHERO);
    }

    public int anadirVisita(int idPaciente, String idMedico) {
        if (! medicoDAO.medicoAdmiteVisitas(idMedico)) {
            return - 1;
        }
        pacienteDao.añadirVisita(idPaciente, idMedico);
        int turno = visitasHoyDAO.anadirVisita(idPaciente, idMedico);
        return turno;
    }

    public boolean existePaciente(int idPaciente, String idMedico) {
        return pacienteDao.existePaciente(idPaciente, idMedico);
    }

    public boolean existePaciente(int idPaciente) {
        return pacienteDao.existePaciente(idPaciente);
    }
}