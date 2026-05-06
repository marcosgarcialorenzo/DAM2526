package Programacion.Curso2526.ExamenesMGL.PendientesAñoPasado.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.Objects;

@AllArgsConstructor
@ToString
@Data
public class Paciente {
    int idPaciente;
    String idMedico;
    int vecesAtendido;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Paciente paciente = (Paciente) o;
        return idPaciente == paciente.idPaciente && Objects.equals(idMedico, paciente.idMedico);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPaciente, idMedico);
    }
}
