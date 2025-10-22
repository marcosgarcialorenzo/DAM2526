package A;

public class A10_Rectangulo {
    A5_Punto esquinaSuperiorIzquierda;
    A5_Punto esquinaInferiorDerecha;

    public A10_Rectangulo(A5_Punto esquinaSuperiorIzquierda, A5_Punto esquinaInferiorDerecha) {
        this.esquinaSuperiorIzquierda = esquinaSuperiorIzquierda;
        this.esquinaInferiorDerecha = esquinaInferiorDerecha;
    }

    public static void main(String[] args) {
        A5_Punto esquinaSupIzq = new A5_Punto(3, 5);
        A5_Punto esquinaInfDer = new A5_Punto(8, 1);
        A10_Rectangulo rectangulo = new A10_Rectangulo(esquinaSupIzq, esquinaInfDer);
        rectangulo.mostrarRectangulo();
        rectangulo.calcularPerimetro();
    }

    A5_Punto calcularEsquinasSuperiorDerecha() {
        A5_Punto esquinaSuperiorDerecha = new A5_Punto(esquinaInferiorDerecha.getX(), esquinaSuperiorIzquierda.getY());

        return esquinaSuperiorDerecha;
    }

    A5_Punto calcularEsquinasInferiorIzquierda() {
        A5_Punto esquinaInferiorIzquierda = new A5_Punto(esquinaSuperiorIzquierda.getX(), esquinaInferiorDerecha.getY());
        return esquinaInferiorIzquierda;
    }

    void mostrarRectangulo() {
        System.out.println("Esquina Superior Izquierda: " + esquinaSuperiorIzquierda);
        System.out.println("Esquina Superior Derecha: " + calcularEsquinasSuperiorDerecha());
        System.out.println("Esquina Inferior Izquierda: " + calcularEsquinasInferiorIzquierda());
        System.out.println("Esquina Inferior Derecha: " + esquinaInferiorDerecha);
    }

    double calcularPerimetro () {
        double largo = esquinaInferiorDerecha.getX() - esquinaSuperiorIzquierda.getX();
        double alto = esquinaSuperiorIzquierda.getY() - esquinaInferiorDerecha.getY();
        double perimetro = 2 * (largo + alto);
        System.out.println("Perimetro del rectangulo: " + perimetro);
        return perimetro;
    }
}