package Programacion.Curso2526.E.E7;

public class Denuncias {
    String matricula;
    int velocidad;
    int puntos;
    int importe;

    public Denuncias(String matricula, int velocidad, int puntos, int importe) {
        this.matricula = matricula;
        this.velocidad = velocidad;
        this.puntos = puntos;
        this.importe = importe;
    }

    void mostrarDenuncia() {
        System.out.println("Matricula: " + matricula);
        System.out.println("Velocidad: " + velocidad + " km/h");
        System.out.println("Puntos: " + puntos);
        System.out.println("Importe: " + importe + " euros");
        System.out.println("---------------------------");
    }
}