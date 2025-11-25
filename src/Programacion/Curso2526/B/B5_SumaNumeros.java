package Programacion.Curso2526.B;

public class B5_SumaNumeros {
    public static void main(String[] args) {
        B5_SumaNumeros s = new B5_SumaNumeros();
        System.out.println(s.suma(13, 28));
    }

    public int suma(int valor1, int valor2) {
        int valorfinal = 0;
        int i = valor1 + 1;
        while (i < valor2) {
            if (i % 10 == 3 || i % 10 == 5)
                valorfinal += i;
            i++;
        }
        return valorfinal;
    }
}