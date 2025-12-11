package Programacion.Curso2526.E.E4;

import java.io.IOException;

public class E4_Biblioteca {
    String nombre;
    Usuario[] usuarios = new Usuario[100];
    Libros[] libros = new Libros[2000];

    public E4_Biblioteca(String nombre) {
        this.nombre = nombre;
        this.usuarios = new Usuario[100];
        this.libros = new Libros[2000];
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Usuario[] getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuario[] usuarios) {
        this.usuarios = usuarios;
    }

    public Libros[] getLibros() {
        return libros;
    }

    public void setLibros(Libros[] libros) {
        this.libros = libros;
    }

    void altaLibros() throws IOException {
        Teclado t = new Teclado();
        System.out.println("Introduce el titulo del libro:");
        String titulo = t.leerString();
        int posicionLibre = - 1;
        for (int i = 0; i < libros.length; i++) {
            if (libros[i] == null) {
                posicionLibre = i;
            }
        }
        libros[posicionLibre] = new Libros(titulo, posicionLibre, false);
        System.out.println("Libro añadido con exito.");
        System.out.println("Codigo del libro: " + posicionLibre);
        System.out.println();
    }

    void altaUsuario() throws IOException {
        Teclado t = new Teclado();
        System.out.println("Introduce el nombre del usuario:");
        String nombre = t.leerString();
        int posicionLibre = - 1;
        for (int i = 0; i < usuarios.length; i++) {
            if (usuarios[i] == null) {
                posicionLibre = i;
            }
        }
        usuarios[posicionLibre] = new Usuario(posicionLibre, nombre); //empieza a rellenar el array desde el final
        System.out.println("Usuario añadido con exito.");
        System.out.println("Identificador del usuario: " + posicionLibre);
        System.out.println();
    }

    void bajaUsuario() throws IOException {
        Teclado t = new Teclado();
        System.out.println("Introduce el identificador del usuario a eliminar:");
        int id = t.leerInt();
        for (int i = 0; i < usuarios.length; i++) {
            if (usuarios[i] != null && usuarios[i].getIdentificador() == id) {
                if (usuarios[i].getLibrosPrestados() > 0) {
                    System.out.println("El usuario tiene libros prestados. No se puede eliminar.");
                } else {
                    System.out.println("Usuario con nombre " + usuarios[i].nombre + " y identificador " + usuarios[i].getIdentificador() + " eliminado con exito.");
                    usuarios[i] = null;
                    System.out.println();
                }
            }
        }
    }

    void prestamoLibros() throws IOException {
        Teclado t = new Teclado();
        System.out.println("Introduce el identificador del usuario:");
        int id = t.leerInt();
        System.out.println("Introduce el codigo del libro a prestar:");
        int codigo = t.leerInt();
        for (int i = 0; i < libros.length; i++) {
            if (libros[i] != null && libros[i].getCodigo() == codigo) {
                if (libros[i].isPrestado()) {
                    System.out.println("El libro ya esta prestado.");
                } else {
                    for (int j = 0; j < usuarios.length; j++) {
                        if (usuarios[j] != null && usuarios[j].getIdentificador() == id) {
                            if (usuarios[j].getLibrosPrestados() < 5) {
                                libros[i].setPrestado(true);
                                usuarios[j].getCodigosLibrosPrestados()[usuarios[j].getLibrosPrestados()] = codigo;
                                usuarios[j].setLibrosPrestados(usuarios[j].getLibrosPrestados() + 1);
                                System.out.println("Libro prestado con exito.");
                                System.out.println();
                            } else {
                                System.out.println("El usuario ya tiene el maximo de libros prestados.");
                                System.out.println();
                            }
                        }
                    }
                }
            }
        }
    }

    void devolucionLibros() throws IOException {
        Teclado t = new Teclado();
        System.out.println("Introduce el identificador del usuario:");
        int id = t.leerInt();
        System.out.println("Introduce el codigo del libro a devolver:");
        int codigo = t.leerInt();
        for (int i = 0; i < libros.length; i++) {
            if (libros[i] != null && libros[i].getCodigo() == codigo) {
                for (int j = 0; j < usuarios.length; j++) {
                    if (usuarios[j] != null && usuarios[j].getIdentificador() == id) {
                        boolean encontrado = false;
                        for (int k = 0; k < usuarios[j].getLibrosPrestados(); k++) {
                            if (usuarios[j].getCodigosLibrosPrestados()[k] == codigo) {
                                encontrado = true;
                                for (int l = k; l < usuarios[j].getLibrosPrestados() - 1; l++) {
                                    usuarios[j].getCodigosLibrosPrestados()[l] = usuarios[j].getCodigosLibrosPrestados()[l + 1];
                                }
                                usuarios[j].getCodigosLibrosPrestados()[usuarios[j].getLibrosPrestados() - 1] = 0;
                                usuarios[j].setLibrosPrestados(usuarios[j].getLibrosPrestados() - 1);
                                libros[i].setPrestado(false);
                                System.out.println("Libro devuelto con exito.");
                                System.out.println();
                            }
                        }
                        if (! encontrado) {
                            System.out.println("El usuario no tiene prestado este libro.");
                            System.out.println();
                        }
                    }
                }
            }
        }
    }

    void consultaLibros() throws IOException {
        Teclado t = new Teclado();
        System.out.println("Introduce el codigo del libro a consultar:");
        int codigo = t.leerInt();
        for (int i = 0; i < libros.length; i++) {
            if (libros[i] != null && libros[i].getCodigo() == codigo) {
                System.out.println("Prestado: " + (libros[i].isPrestado() ? "Si" : "No"));
                if (libros[i].isPrestado()) {
                    for (int j = 0; j < usuarios.length; j++) {
                        if (usuarios[j] != null) {
                            for (int k = 0; k < usuarios[j].getLibrosPrestados(); k++) {
                                if (usuarios[j].getCodigosLibrosPrestados()[k] == codigo) {
                                    System.out.print("El libro con identificador " + codigo + " y titulo " + libros[i].getTitulo() + " esta ");
                                    System.out.println("siendo prestado al usuario con identificador: " + usuarios[j].getIdentificador() + " y con nommbre: " + usuarios[j].nombre);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    void consultaUsuarios() throws IOException {
        for (int i = 0; i < usuarios.length; i++) {
            if (usuarios[i] != null) {
                System.out.println("El usuario con identificador " + i + " y nombre " + usuarios[i].nombre + " tiene " + usuarios[i].getLibrosPrestados() + " libros prestados.");
                if (usuarios[i].getLibrosPrestados() > 0) {
                    System.out.print("Codigos de los libros prestados a " + usuarios[i].nombre + ": ");
                    for (int j = 0; j < usuarios[i].getLibrosPrestados(); j++) {
                        System.out.print(usuarios[i].getCodigosLibrosPrestados()[j] + " ");
                    }
                }
            }
        }
        System.out.println();
    }

    void consultaLibrosNoPrestados() throws IOException {
        System.out.println("Libros no prestados:");
        for (int i = 0; i < libros.length; i++) {
            if (libros[i] != null && ! libros[i].isPrestado()) {
                System.out.println("Codigo: " + libros[i].getCodigo() + ", Titulo: " + libros[i].getTitulo());
            }
        }
        System.out.println();
    }

    void consultaUsuariosOrdenadosPorLibros() throws IOException {
        //crear un array del mismo tamaño que el número de usuarios no null
        int contador = 0;
        for (int i = 0; i < usuarios.length; i++) {
            if (usuarios[i] != null) {
                contador++;
            }
        }
        int indice = 0;
        Usuario[] lista = new Usuario[contador];
        for (int i = 0; i < lista.length; i++) {
            if (usuarios[i] != null) {
                lista[i] = usuarios[indice];
                indice++;
            }
        }
        // ordenar los usuarios
        for (int i = 0; i < lista.length; i++) {
            for (int j = i + 1; j < lista.length; j++) {
                if (lista[i].getLibrosPrestados() < lista[j].getLibrosPrestados()) {
                    Usuario temp = lista[i];
                    lista[i] = lista[j];
                    lista[j] = temp;
                }
            }
        }
        //mostrar los usuarios
        for (int i = 0; i < lista.length; i++) {
            System.out.println("El usuario con identificador " + lista[i].getIdentificador() + " y nombre " + lista[i].nombre + " tiene " + lista[i].getLibrosPrestados() + " libros prestados.");
        }
    }

    void consultaUsuariosOrdenadosPorNombre() throws IOException {
        //crear un array del mismo tamaño que el número de usuarios no null
        int contador = 0;
        for (int i = 0; i < usuarios.length; i++) {
            if (usuarios[i] != null) {
                contador++;
            }
        }
        int indice = 0;
        Usuario[] lista = new Usuario[contador];
        for (int i = 0; i < lista.length; i++) {
            if (usuarios[i] != null) {
                lista[i] = usuarios[indice];
                indice++;
            }
        }
        //ordenar los usuarios por nombre
        Arrays
    }

    public void menu() throws IOException {
        Teclado t = new Teclado();
        int opcion;
        do {
            System.out.println("1. Alta de libro");
            System.out.println("2. Alta de usuario");
            System.out.println("3. Baja de usuario");
            System.out.println("4. Préstamo de libro");
            System.out.println("5. Devolución de libro");
            System.out.println("6. Consulta de libro");
            System.out.println("7. Consulta de usuarios");
            System.out.println("8. Consulta de libros no prestados");
            System.out.println("9. Consulta de usuarios ordenador por cantidad de libros");
            System.out.println("0. Salir");
            System.out.println("Elige una opción:");
            opcion = t.leerInt();
            switch (opcion) {
                case 1 -> altaLibros();
                case 2 -> altaUsuario();
                case 3 -> bajaUsuario();
                case 4 -> prestamoLibros();
                case 5 -> devolucionLibros();
                case 6 -> consultaLibros();
                case 7 -> consultaUsuarios();
                case 8 -> consultaLibrosNoPrestados();
                case 9 -> consultaUsuariosOrdenadosPorLibros();
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }

    public static void main(String[] args) throws IOException {
        E4_Biblioteca biblioteca = new E4_Biblioteca("Biblioteca Central");
        biblioteca.menu();
    }
}