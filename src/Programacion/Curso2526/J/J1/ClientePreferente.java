package Programacion.Curso2526.J.J1;

import java.util.Vector;

public class ClientePreferente extends Cliente {
    Vector<Integer> descuentos;
    Vector<Producto> compras;
    Vector<Producto> carrito;

    public ClientePreferente(String nombre, String contrasena) {
        super(nombre, contrasena);
        this.compras = new Vector<>(5, 5);
        this.carrito = new Vector<>(5, 5);
        this.descuentos = new Vector<>(5, 5);
    }

    @Override
    boolean esClientePreferente (){
        return true;
    }

    @Override
    void mostrar() {
        System.out.println("Nombre de usuario: " + this.nombre);
        System.out.println("Contraseña: " + this.contrasena);
        System.out.println("Es cliente preferente");
        System.out.println();
    }
}