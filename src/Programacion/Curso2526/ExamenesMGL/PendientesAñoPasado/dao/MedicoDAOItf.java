package Programacion.Curso2526.ExamenesMGL.PendientesAñoPasado.dao;

import Programacion.Curso2526.ExamenesMGL.PendientesAñoPasado.model.Medico;

import java.util.List;

public interface MedicoDAOItf {

    public void insertMedico(Medico medico);

    public Medico getMedicoById(String idMedico);

    public void anadirVisitaMedico(String idMedico);

    public List<Medico> getTodosLosMedicos();

    public boolean medicoAdmiteVisitas(String idMedico);
}