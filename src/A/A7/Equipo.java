package A.A7;

public class Equipo {
    private String nombre;
    private int puntos;
    private int golesFavor;
    private int golesContra;

    Equipo(String n) { //constructor que recibe el nombre del equipo
        nombre = n;
        puntos = 0;
        golesFavor = 0;
        golesContra = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getGolesContra() {
        return golesContra;
    }

    public void setGolesContra(int golesContra) {
        this.golesContra = golesContra;
    }

    public int getGolesFavor() {
        return golesFavor;
    }

    public void setGolesFavor(int golesFavor) {
        this.golesFavor = golesFavor;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }
}