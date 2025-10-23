package Programacion.A;

public class A6_Triangulo {
    A5_Punto v1;
    A5_Punto v2;
    A5_Punto v3;

    A6_Triangulo(A5_Punto p1, A5_Punto p2, A5_Punto p3) { //constructor con trs puntos
        v1 = p1;
        v2 = p2;
        v3 = p3;
    }

    A6_Triangulo(A5_Punto p1, A5_Punto p2) { //constructor con dos puntoa
        v1 = p1;
        v2 = p2;
        v3 = new A5_Punto(0,0);
    }

    double perimetro(A6_Triangulo t) {
        double resultado;
        double lado1 = v1.distanciaEntre2Puntos(v2);
        double lado2 = v2.distanciaEntre2Puntos(v3);
        double lado3 = v3.distanciaEntre2Puntos(v1);
        resultado = lado1 + lado2 + lado3;
        System.out.println("Perimetro del triangulo es: " + resultado);
        return resultado;
    }

    void mover(A6_Triangulo t, int incremento){
        v1.moverX(incremento);
        v1.moverY(incremento);
        v2.moverX(incremento);
        v2.moverY(incremento);
        v3.moverX(incremento);
        v3.moverY(incremento);
        System.out.println("Nuevas coordenadas del triangulo son: ");
        System.out.println("Vertice 1: "+v1);
        System.out.println("Vertice 2: "+v2);
        System.out.println("Vertice 3: "+v3);
    }

    boolean esEquilatetro(A6_Triangulo t){
        boolean resultado = false;
        double lado1 = v1.distanciaEntre2Puntos(v2);
        double lado2 = v2.distanciaEntre2Puntos(v3);
        double lado3 = v3.distanciaEntre2Puntos(v1);
        if (lado1 == lado2 && lado2 == lado3) {
            System.out.println("¿El triangulo es equilatero?: " + resultado);
            return resultado = true;
        } else {
            System.out.println("¿El triangulo es equilatero?: " + resultado);
            return resultado = false;
        }
    }

    public static void main(String[] args) {
        A5_Punto p1 = new A5_Punto(0, 0);
        A5_Punto p2 = new A5_Punto(1, 2);
        A5_Punto p3 = new A5_Punto(2, 0);

        A6_Triangulo t1 = new A6_Triangulo(p1, p2, p3);
        A6_Triangulo t2 = new A6_Triangulo(p1, p2);

        t1.perimetro(t1);
        t1.mover(t1, 1);
        t1.mover(t1, -1);
        t1.esEquilatetro(t1); // aqui deberia dar que es equilatero pero no no hace bien aunque los calculos esten bien

        t2.perimetro(t2);
        t2.mover(t2, 2);
        t2.mover(t2, -2);
        t2.esEquilatetro(t2);

    }


}
