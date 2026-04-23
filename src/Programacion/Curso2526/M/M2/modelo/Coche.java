package Programacion.Curso2526.M.M2.modelo;

import lombok.Data;

@Data
public class Coche {
    String matricula;
    String modelo;
    int antiguedad;
    double precio;

    public Coche(String matricula, String modelo, int antiguedad, double precio) {
        this.matricula = matricula;
        this.modelo = modelo;
        this.antiguedad = antiguedad;
        this.precio = precio;
    }
}