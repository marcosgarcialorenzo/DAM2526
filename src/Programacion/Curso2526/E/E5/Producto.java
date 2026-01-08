package Programacion.Curso2526.E.E5;

public class Producto {
    String nombre;
    double precio;
    int cantStock;

    Producto(String nombre) {
        this.nombre = nombre;
        precio = - 1;
        cantStock = 0;
    }

    Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
        cantStock = 0;
    }

    Producto(String nombre, double precio, int cant) {
        this.nombre = nombre;
        this.precio = precio;
        cantStock = cant;
    }

    void mostrar() {
        System.out.println(nombre + " tiene un precio de: " + precio + " y cuenta con " + cantStock + " de stock");
    }

    @Override
    public String toString() {
        String precioS = String.valueOf(precio);
        if (precio == - 1)
            precioS = "Precio no definido";
        return nombre + " tiene un precio de: " + precioS + " y cuenta con " + cantStock + " de stock";
    }
}