package Programacion.Curso2526.ExamenesMGL.PendientesAñoPasado.dao;

import Programacion.Curso2526.ExamenesMGL.PendientesAñoPasado.model.Visita;

import java.util.ArrayList;
import java.util.List;

public class VisitasHoyDAO implements VisitasHoyDAOItf {
    List<Visita> listaVisitas = new ArrayList<>();

    public void insertarVisita(Visita visita) {
        listaVisitas.add(visita);
    }

    public int anadirVisita(int idPaciente, String idMedico) {
        Visita v = new Visita(idPaciente, idMedico);
        insertarVisita(v);
        return v.getNumTurno();
    }

    public Visita siguienteTurno(String idMedico) {
        int posSiguiente = listaVisitas.indexOf(new Visita(0, idMedico));
        if (posSiguiente >= 0) {
            return listaVisitas.get(posSiguiente);
        } else {
            return null;
        }
    }

    public void eliminarVisita(Visita vSiguiente) {
        int posSiguiente = listaVisitas.indexOf(vSiguiente);
        if (posSiguiente >= 0) {
            listaVisitas.remove(posSiguiente);
        }
    }

    public List<Visita> getVisitasHoy() {
        return listaVisitas;
    }
}