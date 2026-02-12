package Programacion.Curso2526.ExamenesMGL.Evaluacion2.Ej1;

import java.io.*;

public class Ej1 {

    boolean validarClave(String s) throws Exception {
        boolean correcta = false;
        if (s.length() >= 6 && s.length() <= 10) {
            if (s.contains("A") || s.contains("B") || s.contains("C") || s.contains("D") || s.contains("E") || s.contains("F") || s.contains("G") || s.contains("H") || s.contains("I") || s.contains("X")) {
                if (s.contains("a") || s.contains("b") || s.contains("c") || s.contains("d") || s.contains("e") || s.contains("f") || s.contains("g") || s.contains("h") || s.contains("i") || s.contains("x")) {
                    if (s.contains("1") || s.contains("2") || s.contains("3") || s.contains("4") || s.contains("5") || s.contains("6") || s.contains("7") || s.contains("8") || s.contains("9")) {
                        correcta = true;
                    } else {
                        throw new Exception("CLAVE INCORRECTA");
                    }
                } else {
                    throw new Exception("CLAVE INCORRECTA");
                }
            } else {
                throw new Exception("CLAVE INCORRECTA");
            }
        } else {
            throw new Exception("CLAVE INCORRECTA");
        }
        return correcta;
    }

    void registro() throws Exception {
        String ruta = "E:\\DAM2526\\src\\Programacion\\Curso2526\\ExamenesMGL\\Evaluacion2\\Ej1\\Ej1.txt"; //comprobar ruta el ejecutar
        Ej1 obj = new Ej1();
        Teclado t = new Teclado();
        System.out.println("Introduce un nombre de usuario");
        String user = t.leerString();
        System.out.println("Introduce una clave");
        String clave = t.leerString();
        Usuario[] usuarios = new Usuario[100];
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) { // pasa el fichero a un array
            String linea;
            int i = 0;
            while ((linea = br.readLine()) != null) {
                for (i = 0; i < usuarios.length; i++) {
                    String[] partes = linea.split("#");
                    String nombre = partes[0];
                    String contraseña = partes[1];
                    usuarios[i] = new Usuario(nombre, contraseña);
                }
            }
        }
        boolean existe = false;
        for (int i = 0; i < usuarios.length; i++) { // comprueba si existe
            if (usuarios[i] != null) {
                if (user.equals(usuarios[i].getNombre())) {
                    System.out.println("El usuario ya existe en el fichero");
                    existe = true;
                }
            }
        }
        boolean fin = false;
        for (int i = 0; i < usuarios.length; i++) {
            if (existe = false) { // si el usuario no existe lo añade
                if (fin = true) {
                    if (usuarios[i] == null) {
                        usuarios[i] = new Usuario(user, clave);
                        existe = true;
                        fin = true;
                    }
                }
            }
        }

        if (obj.validarClave(clave)) {// mete en el fichero lo que hay en el array
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta))) {
                for (int i = 0; i < usuarios.length; i++) {
                    if (usuarios[i] != null) {
                        bw.write(usuarios[i].getNombre() + "#" + usuarios[i].getClave());
                        bw.newLine();
                    }
                }
            } catch (Exception e) {
                System.err.println("Error: " + e.getMessage());
            }
        }
    }

    boolean acceder() throws Exception {
        boolean accesoCorrecto = false;
        String ruta = "E:\\DAM2526\\src\\Programacion\\Curso2526\\ExamenesMGL\\Evaluacion2\\Ej1\\Ej1.txt";
        Ej1 obj = new Ej1();
        Teclado t = new Teclado();
        System.out.println("Introduce un nombre de usuario");
        String user = t.leerString();
        System.out.println("Introduce una clave");
        String clave = t.leerString();
        if (obj.validarClave(clave)) {
            try (BufferedReader br = new BufferedReader(new FileReader(ruta))) { //comprobar ruta el ejecutar
                String linea;
                boolean fin = false;
                while ((linea = br.readLine()) != null) {
                    String[] partes = linea.split("#");
                    if (partes[1].equals(clave) && partes[0].equals(user)) {
                        System.out.println("Acceso correcto");
                        fin = true;
                        accesoCorrecto = true;
                    }
                }
                if (fin = true) {
                    System.out.println("Acceso incorrecto");
                }
            }
        }
        return accesoCorrecto;
    }

    void menu() throws Exception {
        Teclado t = new Teclado();
        Ej1 obj = new Ej1();
        int opcion;
        do {
            System.out.println("1. Registro");
            System.out.println("2. Acceder");
            System.out.println("0. Salir");
            System.out.println("Elige una opción:");
            opcion = t.leerInt();
            switch (opcion) {
                case 1 -> registro();
                case 2 -> acceder();
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }

    public static void main(String[] args) throws Exception {
        Ej1 obj = new Ej1();
        obj.menu();
    }
}