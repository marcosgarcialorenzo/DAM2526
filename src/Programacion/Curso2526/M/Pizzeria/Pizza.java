package Programacion.Curso2526.M.Pizzeria;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Pizza {
    private static final int MAX_INGREDIENTES_BASICA = 4;
    private ArrayList<Ingrediente> ingredientes;

    public Pizza() {
        this.ingredientes = new ArrayList<>();
    }

    public List<Ingrediente> getIngredientes() {
        return new ArrayList<>(ingredientes);
    }

    public double getCosteBase() {
        return 0.0;
    }

    protected int getMaxIngredientes() {
        return MAX_INGREDIENTES_BASICA;
    }

    public int anadirIngredientes(List<Integer> codigos, HashMap<Integer, Ingrediente> catalogo) {
        int noAnadidos = 0;
        for (Integer codigo : codigos) {
            if (ingredientes.size() >= getMaxIngredientes()) {
                noAnadidos++;
                continue;
            }
            Ingrediente ingrediente = catalogo.get(codigo);
            if (ingrediente != null) {
                ingredientes.add(ingrediente);
            } else {
                // Código no válido => no se añade.
                noAnadidos++;
            }
        }
        return noAnadidos;
    }
}
