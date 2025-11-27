// AUTOR MARCOS GRACIA LORENZO
package Programacion.Curso2526.ExamenesMGL.Evaluacion1.Ej2;

public class Poligono {
    int[] arrayPuntos;

    public Poligono(int numVertices) {
        int[] arrayPuntos = new int[numVertices * 2]; // this.arrayPuntos = new int[numVertices * 2];
        for (int i = 0; i < arrayPuntos.length; i++) {
            arrayPuntos[i] = (int) (Math.random() * 100);
        }
    }

    public Poligono(int[] arrayPuntos) {
        this.arrayPuntos = arrayPuntos;
    }

    void mostrar() {
        int dos = 2;
        for (int i = 0; i < arrayPuntos.length; i += dos) {
            System.out.println("pto" + i + ":(" + arrayPuntos[i] + "," + arrayPuntos[i + 1] + ")");
        }
    }

    boolean puntoEsVertice(Punto p) {
        boolean resultado = false;
        int dos = 2;
        for (int i = 0; i < arrayPuntos.length; i += dos) {
            Punto poligonoPunto = new Punto(arrayPuntos[i], arrayPuntos[i + 1]);
            if (poligonoPunto.x == p.x && poligonoPunto.y == p.y) {
                resultado = true;
                return resultado;
            }
        }
        return resultado;
    }

    Punto verticeMasCercanoA00() {
        int dos = 2;
        Punto p0 = new Punto(0, 0);
        Punto puntoCercano = new Punto(0, 0);
        double distancia = 200.0;
        for (int i = 0; i < arrayPuntos.length; i += dos) {
            Punto poligonoPunto = new Punto(arrayPuntos[i], arrayPuntos[i + 1]);
            poligonoPunto.calcularDistancia(p0);
            if (poligonoPunto.calcularDistancia(p0) < distancia) {
                distancia = poligonoPunto.calcularDistancia(p0);
                puntoCercano = new Punto(arrayPuntos[i], arrayPuntos[i + 1]);
            }
        }
        return puntoCercano;
    }

    double perimetro() {
        int dos = 2;
        double resultado = 0.0;
        for (int i = 0; i < arrayPuntos.length - 2; i += dos) {
            Punto punto1 = new Punto(arrayPuntos[i], arrayPuntos[i + 1]);
            Punto punto2 = new Punto(arrayPuntos[i + 2], arrayPuntos[i + 3]);
            resultado += punto1.calcularDistancia(punto2);
        }
        return resultado;
    }

    double mayorArista() {
        int dos = 2;
        double resultado;
        double distancia = 0.0;
        for (int i = 0; i < arrayPuntos.length - 2; i += dos) {
            Punto punto1 = new Punto(arrayPuntos[i], arrayPuntos[i + 1]);
            Punto punto2 = new Punto(arrayPuntos[i + 2], arrayPuntos[i + 3]);
            resultado = punto1.calcularDistancia(punto2);
            if (resultado > distancia) {
                distancia = resultado;
            }
        }
        return distancia;
    }

    int[] puntosComunes(Poligono p) {
        int dos = 2;
        int[] resultado = new int[10];
        for (int i = 0; i < arrayPuntos.length; i += dos) {
            Punto poligonoPunto1 = new Punto(arrayPuntos[i], arrayPuntos[i + 1]);
            for (int j = 0; j < arrayPuntos.length; i += dos) {
                Punto poligonoPunto2 = new Punto(arrayPuntos[i], arrayPuntos[i + 1]);
                if (poligonoPunto1.x == poligonoPunto2.x && poligonoPunto1.y == poligonoPunto2.y) {
                    resultado[j] = (int) poligonoPunto1.x;
                    resultado[j + 1] = (int) poligonoPunto1.y;
                }
            }
        }
        return resultado;
    }

    public static void main(String[] args) {
        int[] array1 = {0, 5, 8, 1, 1, 5, -2, -5, 2, -6};
        int[] array2 = {0, 6, 8, 1, 5, 5, -8, -5, 4, -6};
        Poligono poligono = new Poligono(array1);
        Poligono poligono2 = new Poligono(array2);
        Punto p1 = new Punto(8.0, 1.0);
        poligono.mostrar();
        System.out.println(poligono.puntoEsVertice(p1));
        System.out.println(poligono.verticeMasCercanoA00());
        double perimetro = poligono.perimetro();
        System.out.println("El perimetro es: " + perimetro);
        double mayorArista = poligono.mayorArista();
        System.out.println("La longitud de la arista mas larga es: " + mayorArista);
//        poligono.puntosComunes(poligono2);
        Poligono test = new Poligono(3);
        test.mostrar();
    }
}