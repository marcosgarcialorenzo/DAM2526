package Programacion.Curso2526.A.A9;

import java.io.IOException;

public class Personaje {
    String nombre;
    int posicionX;
    int posicionY;
    double vida;
    double fuerza;
    Arma arma1;
    Arma arma2;

    public Personaje(String nombre, int posicionX, int posicionY, double vida, double fuerza, Arma arma1, Arma arma2) {
        this.nombre = nombre;
        this.posicionX = posicionX;
        this.posicionY = posicionY;
        this.vida = vida;
        this.fuerza = fuerza;
        this.arma1 = arma1;
        this.arma2 = arma2;
    }

    //    void moverPersonaje() throws IOException { /// aqui usar el metodo mover de A5_Punto en vez de esto que supongo que ira mejor y asi no dara fallo
//        String direccion;
//        int casillas;
//        Programacion.Curso2425.Teclado t = new Programacion.Curso2425.Teclado();
//        System.out.println("Introduce el eje de movimiento (x o y): ");
//        direccion = t.leerString();
//        System.out.println("Introduce el numero de casillas a mover: ");
//        casillas = t.leerInt();
//        if (direccion.equals("x")) {
//            posicionX.moverX(casillas);
//        } else if (direccion.equals("y")) {
//            moverY(casillas);
//        } else {
//            System.out.println("Direccion no valida");
//        }
//    }
    void moverX(int incrementoX) throws IOException {
        int x = getPosicionX();
        x = x + (incrementoX);
    }

    void moverY(int incrementoY) throws IOException {
        int y = posicionY;
        y += incrementoY;
    }

    void cambiarArma(Arma armaNueva) {
        if (arma1 != null && arma2 != null) {
            arma1 = armaNueva;
            System.out.println("El arma 1 ha sido sustituida por " + armaNueva.getNombre());
            Arma armaAux = null;
            armaAux = arma2;
            arma2 = arma1;
            arma1 = armaAux;
        } else {
            System.out.println("El personaje no tiene dos armas, no se puede sustituir ninguna.");
        }
    }

    void mostrarEstado() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Posicion: (" + posicionX + ", " + posicionY + ")");
        System.out.println("Vida: " + vida);
        System.out.println("Fuerza: " + fuerza);
        if (arma1 != null) {
            System.out.println("Arma 1: " + arma1.getNombre());
        } else {
            System.out.println("Arma 1: Ninguna");
        }
        if (arma2 != null) {
            System.out.println("Arma 2: " + arma2.getNombre());
        } else {
            System.out.println("Arma 2: Ninguna");
        }
    }

    double calcularFuerza() {
        double fuerza1 = 0.0;
        double fuerza2 = 0.0;
        if (arma1 != null) {
            fuerza1 = ((arma1.getAumentoFuerza() * fuerza) / 100.0);
        }
        if (arma2 != null) {
            fuerza2 = ((arma2.getAumentoFuerza() * fuerza) / 100.0);
        }
        double fuerzaTotal;
        fuerzaTotal = fuerza + fuerza1 + fuerza2;
        return fuerzaTotal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPosicionX() {
        return posicionX;
    }

    public void setPosicionX(int posicionX) {
        this.posicionX = posicionX;
    }

    public int getPosicionY() {
        return posicionY;
    }

    public void setPosicionY(int posicionY) {
        this.posicionY = posicionY;
    }

    public double getVida() {
        return vida;
    }

    public void setVida(double vida) {
        this.vida = vida;
    }

    public double getFuerza() {
        return fuerza;
    }

    public void setFuerza(double fuerza) {
        this.fuerza = fuerza;
    }

    public Arma getArma1() {
        return arma1;
    }

    public void setArma1(Arma arma1) {
        this.arma1 = arma1;
    }

    public Arma getArma2() {
        return arma2;
    }

    public void setArma2(Arma arma2) {
        this.arma2 = arma2;
    }
}
