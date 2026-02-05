package Programacion.Curso2526.I.I6;

import java.io.*;
import java.io.IOException;
import java.util.Arrays;

public class I6_Biblioteca {
    String nombre;
    Usuario[] usuarios = new Usuario[100];
    Libros[] libros = new Libros[2000];

    public I6_Biblioteca(String nombre) {
        this.nombre = nombre;
        this.usuarios = new Usuario[100];
        this.libros = new Libros[2001];
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

    void cargarLibros() {
        String ruta = "src/Programacion/Curso2526/I/I6/Libros.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(";");
                String titulo = partes[0];
                int codigo = Integer.parseInt(partes[1]);
                boolean prestado = Boolean.parseBoolean(partes[2]);
                libros[codigo] = new Libros(titulo, codigo, prestado);
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
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
                                    System.out.println("siendo prestado al usuario con identificador: " + usuarios[j].getIdentificador() + " y con nombre: " + usuarios[j].nombre);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    void consultaUsuarios() throws IOException {
        System.out.println("Usuarios registrados:");
        for (int i = 0; i < usuarios.length; i++) {
            if (usuarios[i] != null) {
                System.out.println();
                System.out.println("Usuario: " + usuarios[i].nombre);
                System.out.println("Identificador: " + usuarios[i].getIdentificador());
                System.out.print("Cantidad de libros prestados: " + usuarios[i].getLibrosPrestados());
                if (usuarios[i].getLibrosPrestados() > 0) {
                    System.out.print(" [");
                    for (int j = 0; j < usuarios[i].getLibrosPrestados(); j++) {
                        System.out.print("(" + usuarios[i].getCodigosLibrosPrestados()[j] + ")");
                    }
                    System.out.println("]");
                }
                System.out.println();
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
        for (int i = 0; i < usuarios.length; i++) {
            if (usuarios[i] != null) {
                lista[indice] = usuarios[i];
                indice++;
            }
        }
        // ordenar los usuarios usando el método de la burbuja
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
        System.out.println();
        //crear un array del mismo tamaño que el número de usuarios no null
        int contador = 0;
        for (int i = 0; i < usuarios.length; i++) {
            if (usuarios[i] != null) {
                contador++;
            }
        }
        int indice = 0;
        Usuario[] lista = new Usuario[contador];
        for (int i = 0; i < usuarios.length; i++) {
            if (usuarios[i] != null) {
                lista[indice] = usuarios[i];
                indice++;
            }
        }
        //ordenar los usuarios por nombre
        Arrays.sort(lista, (u1, u2) -> u1.nombre.compareTo(u2.nombre));
        //mostrar los usuarios
        System.out.println("Usuarios ordenados por nombre:");
        for (int i = 0; i < lista.length; i++) {
            System.out.println();
            System.out.println("Usuario: " + lista[i].nombre);
            System.out.println("Identificador: " + lista[i].getIdentificador());
            System.out.print("Cantidad de libros prestados: " + lista[i].getLibrosPrestados());
            if (lista[i].getLibrosPrestados() > 0) {
                System.out.print(" [");
                for (int j = 0; j < lista[i].getLibrosPrestados(); j++) {
                    System.out.print("(" + lista[i].getCodigosLibrosPrestados()[j] + ")");
                }
                System.out.println("]");
            }
            System.out.println();
        }
        System.out.println();
    }

    void guardarLibros() {
        String ruta = "src/Programacion/Curso2526/I/I6/Libros.txt";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta))) {
            for (int i = 0; i < libros.length; i++) {
                if (libros[i] != null) {
                    bw.write(libros[i].getTitulo() + ";" + libros[i].getCodigo() + ";" + libros[i].isPrestado());
                    bw.newLine();
                }
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    void menu() throws IOException {
        Teclado t = new Teclado();
        int opcion;
        do {
            System.out.println("1. Alta de usuario");
            System.out.println("2. Baja de usuario");
            System.out.println("3. Préstamo de libro");
            System.out.println("4. Devolución de libro");
            System.out.println("5. Consulta de libro");
            System.out.println("6. Consulta de usuarios");
            System.out.println("7. Consulta de libros no prestados");
            System.out.println("8. Consulta de usuarios ordenador por cantidad de libros");
            System.out.println("9. Consulta de usuarios ordenador por nombre");
            System.out.println("0. Salir");
            System.out.println("Elige una opción:");
            opcion = t.leerInt();
            switch (opcion) {
                case 1 -> altaUsuario();
                case 2 -> bajaUsuario();
                case 3 -> prestamoLibros();
                case 4 -> devolucionLibros();
                case 5 -> consultaLibros();
                case 6 -> consultaUsuarios();
                case 7 -> consultaLibrosNoPrestados();
                case 8 -> consultaUsuariosOrdenadosPorLibros();
                case 9 -> consultaUsuariosOrdenadosPorNombre();
                case 0 -> {
                    System.out.println("Guardando libros...");
                    guardarLibros();
                    System.out.println("Saliendo...");
                }
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }
}