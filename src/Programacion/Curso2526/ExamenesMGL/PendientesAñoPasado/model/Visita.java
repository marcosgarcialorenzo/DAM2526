package Programacion.Curso2526.ExamenesMGL.PendientesAñoPasado.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Objects;

@Data
public class Visita {
    int idPaciente;
    String idMedico;
    int numTurno;
    static int numVisitasHoy=0;

    public Visita(int idPaciente, String idMedico) {
        this.idPaciente = idPaciente;
        this.idMedico = idMedico;
        numTurno=++numVisitasHoy;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Visita visita = (Visita) o;
        return Objects.equals(idMedico, visita.idMedico);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idMedico);
    }
}
