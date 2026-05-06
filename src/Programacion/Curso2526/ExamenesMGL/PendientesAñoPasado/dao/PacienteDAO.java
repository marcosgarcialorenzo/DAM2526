package Programacion.Curso2526.ExamenesMGL.PendientesAñoPasado.dao;

import Programacion.Curso2526.ExamenesMGL.PendientesAñoPasado.model.Paciente;
import Programacion.Curso2526.ExamenesMGL.PendientesAñoPasado.comun.Datos;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PacienteDAO {
    List<Paciente> pacientes = new ArrayList<>();

    /**
     * return false si hay problemas en el fichero
     */
    public boolean cargarPacientes() {
        /*1C-Rellenar el código para guardar lo leído del fichero en la lista */
        return true;
    }

    public void guardarPacientes() {
        /*2C-Rellenar el código para guardar la lista de pacientes en el fichero*/
    }

    public void añadirVisita(int idPaciente, String idMedico) {
        int pos = pacientes.indexOf(new Paciente(idPaciente, idMedico, 0));
      if (pos >= 0) {
        pacientes.get(pos).setVecesAtendido(pacientes.get(pos).getVecesAtendido() + 1);
      } else {
        pacientes.add(new Paciente(idPaciente, idMedico, 1));
      }
    }

    public boolean existePaciente(int idPaciente) {
        return pacientes.contains(new Paciente(idPaciente, "", 0));
    }

    public boolean existePaciente(int idPaciente, String idMedico) {
        //No podemos utilizar el contains porque el equals de paciente compara también el idMedico
        return pacientes.stream().filter(p -> p.getIdPaciente() == idPaciente && p.getIdMedico() == idMedico).count() > 0;
    }

}