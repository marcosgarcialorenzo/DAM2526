package Programacion.Curso2526.I.I6;

public class Usuario {
    String nombre;
    int identificador;
    int librosPrestados;
    int [] codigosLibrosPrestados = new int[5];

    public Usuario(int identificador, String nombre) {
        this.nombre = nombre;
        this.identificador = identificador;
        this.librosPrestados = 0;
        this.codigosLibrosPrestados = new int[5];
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public int getLibrosPrestados() {
        return librosPrestados;
    }

    public void setLibrosPrestados(int librosPrestados) {
        this.librosPrestados = librosPrestados;
    }

    public int[] getCodigosLibrosPrestados() {
        return codigosLibrosPrestados;
    }

    public void setCodigosLibrosPrestados(int[] codigosLibrosPrestados) {
        this.codigosLibrosPrestados = codigosLibrosPrestados;
    }
}