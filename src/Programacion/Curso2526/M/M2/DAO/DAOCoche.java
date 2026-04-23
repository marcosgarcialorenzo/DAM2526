package Programacion.Curso2526.M.M2.DAO;

import Programacion.Curso2526.M.M2.modelo.Coche;

import java.util.List;

public interface DAOCoche {
    boolean insertarCoche(Coche c);

    boolean eliminarCoche(int id);

    boolean actualizarPreciosCoches(Coche c);

    List<Coche> obtenerCoches(String modelo);

    double sumarPreciosCochesPorAntiguedad(Coche c);

    List<String> obtenerMatriculasPorMarca(String marca);
}