package A.A12;

public class Vehiculo {
    String matricula;
    int kilometraje;
    Persona propietario;

    Vehiculo(String matricula, int kilometraje, Persona propietario) {
        this.matricula = matricula;
        this.kilometraje = kilometraje;
        this.propietario = propietario;
    }
}