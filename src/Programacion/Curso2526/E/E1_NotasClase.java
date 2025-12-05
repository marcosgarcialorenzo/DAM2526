package Programacion.Curso2526.E;

public class E1_NotasClase {
    int notas[][];

    public class Posicion {
        int alumno;
        int asignatura;

        Posicion(int a, int b) {
            alumno = a;
            asignatura = b;
        }
    }

    Posicion mejorNota() {
        int mejor = -1;
        int a = -1, s = -1;

        for (int i = 0; i < notas.length; i++) {
            for (int j = 0; j < notas[i].length; j++) {
                if (notas[i][j] > mejor) {
                    mejor = notas[i][j];
                    a = i;
                    s = j;
                }
            }
        }
        return new Posicion(a, s);
    }

    E1_NotasClase(int numAlumnos, int numNotas) {
        notas = new int[numAlumnos][numNotas];
        for (int i = 0; i < notas.length; i++)
            for (int j = 0; j < notas[i].length; j++)
                notas[i][j] = -1;
    }

    void mostrar() {
        for (int i = 0; i < notas.length; i++) {
            System.out.print("Alumno " + i + ":\t");
            for (int j = 0; j < notas[i].length; j++)
                System.out.print(notas[i][j] + " ");
            System.out.println();
        }
    }

    void ponerNota(int numAlumno, int numAsignatura, int nota) {
        if (numAlumno < notas.length && numAsignatura < notas[numAlumno].length)
            notas[numAlumno][numAsignatura] = nota;
    }

    void ponerTodasNotasAlumno(int numAlumno, int nota) {
        for (int i = 0; i < notas[numAlumno].length; i++)
            notas[numAlumno][i] = nota;
    }

    void ponerTodasNotasAsignaturas(int numAsig, int nota) {
        for (int i = 0; i < notas.length; i++)
            if (numAsig < notas[i].length)
                notas[i][numAsig] = nota;
    }

    double notaMedia(int numAlumno) {
        int suma = 0;
        int contador = 0;

        for (int i = 0; i < notas[numAlumno].length; i++)
            if (notas[numAlumno][i] != -1) {
                suma += notas[numAlumno][i];
                contador++;
            }

        return (contador == 0) ? 0 : (double) suma / contador;
    }

    double notaMediaClase() {
        int sumaMediClase = 0;
        int contadorMediaClase = 0;

        for (int i = 0; i < notas.length; i++)
            for (int j = 0; j < notas[i].length; j++)
                if (notas[i][j] != -1) {
                    sumaMediClase += notas[i][j];
                    contadorMediaClase++;
                }

        return (contadorMediaClase == 0) ? 0 : (double) sumaMediClase / contadorMediaClase;
    }

    int alumnoMejorMedia() {
        double mejor = -1;
        int pos = -1;

        for (int i = 0; i < notas.length; i++) {
            double m = notaMedia(i);
            if (m > mejor) {
                mejor = m;
                pos = i;
            }
        }
        return pos;
    }

    int asignaturaMasSuspensos() {
        int numAsignaturas = notas[0].length;
        int[] suspensos = new int[numAsignaturas];

        for (int i = 0; i < notas.length; i++) {
            for (int j = 0; j < numAsignaturas; j++) {
                if (notas[i][j] != -1 && notas[i][j] < 5)
                    suspensos[j]++;
            }
        }

        int max = -1;
        int pos = -1;
        for (int j = 0; j < numAsignaturas; j++) {
            if (suspensos[j] > max) {
                max = suspensos[j];
                pos = j;
            }
        }
        return pos;
    }

    public static void main(String[] args) {
        E1_NotasClase obj = new E1_NotasClase(5, 4);
        obj.ponerNota(3, 2, 3);
        obj.ponerTodasNotasAlumno(1, 0);
        obj.ponerTodasNotasAsignaturas(2, 5);
        obj.mostrar();
        obj.alumnoMejorMedia();
        obj.mejorNota();
        obj.asignaturaMasSuspensos();
        double media = obj.notaMedia(2);
        System.out.println("Media del alumno 2: " + media);

        System.out.println("Media de la clase: " + obj.notaMediaClase());
    }
}