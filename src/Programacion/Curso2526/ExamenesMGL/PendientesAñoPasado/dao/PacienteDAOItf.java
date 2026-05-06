package Programacion.Curso2526.ExamenesMGL.PendientesAñoPasado.dao;

public interface PacienteDAOItf {
    public boolean cargarPacientes();

    public boolean existePaciente(int idPaciente);

    public void anadirPaciente(int idPaciente, String idMedico);

    public void guardarPacientes();

    public void anadirNumTurnoHoy();
}