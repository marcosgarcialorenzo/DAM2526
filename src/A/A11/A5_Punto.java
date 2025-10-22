package A.A11;


public class A5_Punto {
    int x;
    int y;

    public A5_Punto(int x, int y) { //constructor
        this.x = x;
        this.y = y;
    }

    public static void main(String[] args) {
        A5_Punto p1 = new A5_Punto(2, 3);
        A5_Punto p2 = new A5_Punto(7, 8);

        System.out.println("Distancia inicial: " + p1.distanciaEntre2Puntos(p2));

        p1.moverX(2);
        p1.moverY(-1);//queda (4,2)

        System.out.println("Nueva distancia: " + p1.distanciaEntre2Puntos(p2));
        System.out.println("Distancia al 0,0 del punto mas cercano: " + p1.distanciaAl0(p1, p2));
    }

    @Override
    public String toString() { //Return a string representation of the AccessibilityListenerList. para que no me mustre el hash code , y en su lugar me muestre las cordenadas del punto
        return "(" + x + ", " + y + ")";
    }

    void moverX(int incrementoX) {
        x += incrementoX;
    }

    void moverY(int incrementoY) {
        y += incrementoY;
    }

    double distanciaEntre2Puntos(A5_Punto punto) { //se usa math.pow para elevar al cuadrado y math.sqrt para raiz cuadrada
        double resultado;
        resultado = Math.sqrt(Math.pow((punto.x - this.x), 2) + Math.pow((punto.y - this.y), 2)); // esto es c²= raiz cuadrada((x1-x2)² + (y1-y2)²)
        return resultado;
    }

    A5_Punto distanciaAl0(A5_Punto punto, A5_Punto punto2) {
        double distancia1 = Math.sqrt(Math.pow((punto.x - 0), 2) + Math.pow((punto.y - 0), 2));
        double distancia2 = Math.sqrt(Math.pow((punto2.x - 0), 2) + Math.pow((punto2.y - 0), 2));
        if (distancia1 < distancia2) {
            return punto;
        } else {
            return punto2;
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
// ctrl + alt + L para formatear el codigo