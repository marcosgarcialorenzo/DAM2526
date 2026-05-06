package Programacion.Curso2526.ExamenesMGL.PendientesAñoPasado.model;

import lombok.Data;

@Data
public class Medico {
    String idMedico;
    int horaInicio;
    int horaFin;
    int numPacientesAtendidos;
    public Medico(String idMedico, int horaInicio, int horaFin) {
        this.idMedico = idMedico;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        numPacientesAtendidos=0;
    }
    public Medico(String idMedico, int horaInicio, int horaFin, int numPacientesAtendidos) {
        this.idMedico = idMedico;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.numPacientesAtendidos = numPacientesAtendidos;
    }
}
