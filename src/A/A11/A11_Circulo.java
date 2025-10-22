package A.A11;

import java.io.IOException;

public class A11_Circulo {
    A5_Punto centro;
    double radio;

    public A11_Circulo(A5_Punto centro, double radio) {
        this.centro = centro;
        this.radio = radio;
    }

    public A11_Circulo(double radio) {
        this.centro = new A5_Punto(0, 0);
        this.radio = radio;
    }

    public static void main(String[] args) throws IOException {
        Teclado t = new Teclado();
        System.out.println("Introduce la coordenada x del centro del círculo 1:");
        int x1 = t.leerInt();
        System.out.println("Introduce la coordenada y del centro del círculo 1:");
        int y1 = t.leerInt();
        System.out.println("Introduce el radio del círculo 1:");
        double radio1 = t.leerDouble();
        System.out.println("Introduce el radio del círculo 2:");
        double radio2 = t.leerDouble();
        A5_Punto centro1 = new A5_Punto(x1, y1);
        A11_Circulo circulo1 = new A11_Circulo(centro1, radio1);
        A11_Circulo circulo2 = new A11_Circulo(radio2);

        circulo1.mostrarCirculo();
        circulo2.mostrarCirculo();
        circulo1.calcularPerimetro();
        circulo1.seTocan(circulo2);
        circulo1.moverCirculo(3);
        circulo1.mostrarCirculo();
    }

    void mostrarCirculo() {
        System.out.println("Centro: " + centro + ", Radio: " + radio);
    }

    double calcularPerimetro() {
        double perimetro = 2 * Math.PI * radio;
        System.out.println("Perímetro: " + perimetro);
        return perimetro;
    }

    boolean seTocan(A11_Circulo otroCirculo) {
        boolean seTocan = false;
        double distanciaCentros = centro.distanciaEntre2Puntos(otroCirculo.centro);
        double sumaRadios = this.radio + otroCirculo.radio;
        if (distanciaCentros > sumaRadios) {
            System.out.println("¿Se tocan los círculos? " + seTocan);
            return seTocan; // No se tocan
        } else {
            seTocan = true;
            System.out.println("¿Se tocan los círculos? " + seTocan);
            return seTocan; // Se tocan
        }
    }

    A11_Circulo moverCirculo(int incrementoX) { //, int incrementoY
        centro.moverX(incrementoX);
//        centro.moverY(incrementoY);
        return this;
    }
}