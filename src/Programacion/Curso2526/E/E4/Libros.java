package Programacion.Curso2526.E.E4;

public class Libros {
    String titulo;
    int codigo;
    boolean prestado;

    public Libros(String titulo, int codigo, boolean prestado) {
        this.titulo = titulo;
        this.codigo = codigo;
        this.prestado = false;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public boolean isPrestado() {
        return prestado;
    }

    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }
}