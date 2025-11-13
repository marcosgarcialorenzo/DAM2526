package Programacion;

public class TestAlumno {
    int[] notas;
    private String nombre;

    public TestAlumno(String nombre) {
        this.nombre = nombre;
        notas = new int[5];
    }

    public TestAlumno(String nombre, int numNotas) {
        this.nombre = nombre;
        notas = new int[numNotas];
    }

    public static void main(String[] args) {
        TestAlumno a1 = new TestAlumno("Pepe");
        a1.generarNotasAleatorias();
        a1.mostrar();
        a1.cambiarNota(2, 8);
        a1.mostrar();
        double media = a1.calcularMedia();
        System.out.println("La nota media del alumno " + a1.getNombre() +
                " es " + media);

        TestAlumno a2 = new TestAlumno("Ana", 8);
        a2.generarNotasAleatorias();
        a2.mostrar();
        int mejNotaA2 = a2.mejorNota();
        a2.tieneAlgunSuspenso();
        System.out.println("La mejor nota de " + a2.getNombre() + " es " + mejNotaA2);
        System.out.println(a2.tieneUn10());
        System.out.println(a2.tieneAlgunSuspenso());
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    void generarNotasAleatorias() {
        for (int i = 0; i < notas.length; i++)
            notas[i] = (int) (Math.random() * 11);
    }

    void mostrar() {
        System.out.println("Nombre:" + nombre);
        System.out.print("Notas:");
        for (int nota : notas) {
            System.out.print(nota + ",");
        }
        System.out.println();
    }

    void cambiarNota(int posicion, int newNota) {
        notas[posicion] = newNota;
    }

    double calcularMedia() {
        double suma = 0;
        for (int i = 0; i < notas.length; i++)
            suma = suma + notas[i];
        suma = suma / notas.length;
        return suma;
    }

    int mejorNota() {
        int mejNota = -1;
        for (int nota : notas) {
            if (nota > mejNota) {
                mejNota = nota;
            }
        }
        return mejNota;
    }

    boolean tieneUn10() {
        for (int nota : notas) {
            if (nota == 10) {
                return true;
            }
        }
        return false;
    }

    boolean tieneAlgunSuspenso() {
        for (int nota : notas) {
            if (nota < 5) {
                return true;
            }
        }
        return false;
    }

    //    devuleve todos los numeros de los modulos (posicion del array) en los que hay un 10 como nota
    int[] posicionesNotaIgual10() {
        int contador = 0;
        for (int i = 0; i < notas.length; i++) { //cuenta cuántas notas valen 10
            if (notas[i] == 10) {
                contador++;
            }
        }

        int[] posiciones = new int[contador];
        int indice = 0;
        for (int i = 0; i < notas.length; i++) { //cuenta cuántas notas valen 10
            if (notas[i] == 10) {
                posiciones[indice++] = i;
            }
        }
        return posiciones;
    }
}