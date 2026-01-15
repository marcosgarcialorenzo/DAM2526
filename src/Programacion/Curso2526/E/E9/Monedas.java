package Programacion.Curso2526.E.E9;

public class Monedas {
    double valor;
    int cantidad;

    public Monedas(double valor, int cantidad) {
        this.valor = valor;
        this.cantidad = cantidad;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void mostrar() {
        System.out.println("Moneda: " + valor + "€, Cantidad: " + cantidad);
    }
}