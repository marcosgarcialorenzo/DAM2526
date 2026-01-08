package Programacion.Curso2526.E.E5;

import java.util.Arrays;
import java.util.Objects;

public class Cliente {
    String nombre;
    String dni;
    Venta[] productosComprados;
    final static int MAXPRODSCOMPRADOS = 100;

    public Cliente(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
        productosComprados = new Venta[MAXPRODSCOMPRADOS];
    }

    void anadirVenta(Venta v) {

    }

    @Override
    public boolean equals(Object o) {
        if (o == null || this.getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(dni, cliente.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(dni);
    }

    void mostrar() {
        System.out.println("Cliente: " + nombre + " con DNI: " + dni);
        System.out.println("Productos comprados:");
        for (int i = 0; i < productosComprados.length; i++)
            if (productosComprados[i] != null)
                productosComprados[i].mostrar();
    }

    @Override
    public String toString() {
        int cont = 0;
        String resultado = "Cliente: " + nombre + " con DNI: " + dni + "\n" +
                "Productos comprados:\n";
        for (int i = 0; i < productosComprados.length; i++)
            if (productosComprados[i] != null) {
                resultado += productosComprados[i].toString() + "\n";
                cont++;
            }
        if (cont == 0)
            resultado += "No hay compras";
        return resultado;
    }
}