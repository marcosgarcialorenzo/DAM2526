package Programacion.Curso2526.E.E5;

public class Venta {
    String nombreProd;
    double precioCompra; //por unidad
    int cantComprada;

    void mostrar() {
        System.out.println("Producto:  " + nombreProd +
                " Cantidad: " + cantComprada + " Precio total: " +
                (cantComprada * precioCompra));
    }

    @Override
    public String toString() {
        return "Producto:  " + nombreProd +
                " Cantidad: " + cantComprada + " Precio total: " +
                (cantComprada * precioCompra);
    }
}