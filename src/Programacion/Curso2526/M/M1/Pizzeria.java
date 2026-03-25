package Programacion.Curso2526.M.M1;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Pizzeria {
    ArrayList<Pizza> pizzas;
    HashMap<Integer, Ingrediente> ingredientes;

    public Pizzeria(HashMap<Integer, Ingrediente> ingredientes) {
        pizzas = new ArrayList<>();
        this.ingredientes = ingredientes;
    }

    public static void main(String[] args) {
        try (Connection con = ConexionH2.getConexion()) {
            IngredienteDAO dao = new IngredienteDAO(con);
            HashMap<Integer, Ingrediente> catalogo = dao.cargarCatalogo();
            Pizzeria p = new Pizzeria(catalogo);
            p.anadirPizzas();
            System.out.println("Precio pizza 1 (normal): " + p.precioPizza(p.pizzas.get(0)) + " EUR");
            System.out.println("Precio pizza 2 (premium): " + p.precioPizza(p.pizzas.get(1)) + " EUR");
            Ingrediente queso = p.ingredientes.get(1);
            System.out.println("Numero de pizzas con " + queso.getNombre() + ": " + p.numPizzasConIngrediente(queso));
        } catch (SQLException e) {
            System.err.println("Error de BD: " + e.getMessage());
        }
    }

    public double precioPizza(Pizza pizza) {
        double costeIngredientes = pizza.getIngredientes()
                .stream()
                .mapToDouble(Ingrediente::getPrecio)
                .sum();
        return costeIngredientes + pizza.getCosteBase();
    }

    public void anadirPizzas() {
        Pizza normal = new Pizza();
        normal.anadirIngredientes(Arrays.asList(1, 2, 4), ingredientes);
        pizzas.add(normal);
        PizzaPremium premium = new PizzaPremium(1);
        premium.anadirIngredientes(Arrays.asList(1, 2, 3, 4, 5), ingredientes);
        pizzas.add(premium);
    }

    public long numPizzasConIngrediente(Ingrediente ingrediente) {
        return pizzas.stream()
                .filter(p -> p.getIngredientes().contains(ingrediente))
                .count();
    }
}