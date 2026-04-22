package Programacion.Curso2526.M.M3;

import java.io.IOException;
import java.util.List;

public interface DAOPersona {
    boolean anadirPersona(Persona p);

    boolean borrarPersona(int id);

    boolean modificarPersona(int id, Persona p);

    Persona buscarPersona(int id);

    List<Persona> obtenerTodasPersonas();

    void menu() throws IOException;
} 