package Programacion.Curso2526.M.M1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Pizzeria {
    ArrayList<Pizza> pizzas;
    HashMap<Integer, Ingredientes> ingredientes;

    public Pizzeria() {
        pizzas = new ArrayList<>();
        ingredientes = new HashMap<>();

        ingredientes.put(1, new Ingredientes("Queso", 2.0));
        ingredientes.put(2, new Ingredientes("Tomate", 2.0));
        ingredientes.put(3, new Ingredientes("Bacon", 3.0));
        ingredientes.put(4, new Ingredientes("Salami", 3.0));
        ingredientes.put(5, new Ingredientes("Alcaparras", 1.0));
    }

    public static void main(String[] args) {
        Pizzeria p = new Pizzeria();
        p.anadirPizzas();

        System.out.println("Precio pizza 1 (normal): " + p.precioPizza(p.pizzas.get(0)) + " EUR");
        System.out.println("Precio pizza 2 (premium): " + p.precioPizza(p.pizzas.get(1)) + " EUR");

        Ingredientes queso = p.ingredientes.get(1);
        System.out.println("Numero de pizzas con " + queso.getNombre() + ": " + p.numPizzasConIngrediente(queso));
    }

    public double precioPizza(Pizza pizza) {
        double costeIngredientes = pizza.getIngredientes()
                .stream()
                .mapToDouble(Ingredientes::getPrecio)
                .sum();

        return costeIngredientes + pizza.getCosteBase();
    }

    public void anadirPizzas() {
        Pizza normal = new Pizza();
        normal.anadirIngredientes(Arrays.asList(1, 2, 4), ingredientes); // Queso, Tomate, Salami
        pizzas.add(normal);

        PizzaPremium premium = new PizzaPremium(1); // extrafina
        premium.anadirIngredientes(Arrays.asList(1, 2, 3, 4, 5), ingredientes);
        pizzas.add(premium);
    }

    public long numPizzasConIngrediente(Ingredientes ingrediente) {
        return pizzas.stream()
                .filter(p -> p.getIngredientes().contains(ingrediente))
                .count();
    }
}