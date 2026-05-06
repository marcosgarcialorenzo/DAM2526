package Programacion.Curso2526.ExamenesMGL.PendientesAñoPasado.dao;

import Programacion.Curso2526.ExamenesMGL.PendientesAñoPasado.model.Visita;

import java.util.List;

public interface VisitasHoyDAOItf {
    public void insertarVisita(Visita visita);
    public int anadirVisita(int idPaciente, String idMedico);
    public Visita siguienteTurno(String idMedico);
    public void eliminarVisita(Visita vSiguiente);
    public List<Visita> getVisitasHoy();
}