package Programacion.Curso2526.E.E9;

import java.io.IOException;

public class E9_Maquina {
    Bebidas[] bebidas;
    Monedas[] monedas;

    public void menu() throws IOException {
        Bebidas[] bebidas = new Bebidas[10];
        Monedas[] monedas = new Monedas[]{
                new Monedas(0.01, 0),
                new Monedas(0.02, 0),
                new Monedas(0.05, 0),
                new Monedas(0.10, 0),
                new Monedas(0.20, 0),
                new Monedas(0.50, 0),
                new Monedas(1.00, 0),
                new Monedas(2.00, 0)
        };

        Teclado teclado = new Teclado();
        boolean salir = false;

        while (! salir) {
            System.out.println("Introduzca una opcion:");
            System.out.println("1. Administrador");
            System.out.println("2. Usuario");
            System.out.println("0. Salir");
            int opcion = teclado.leerInt();

            switch (opcion) {
                case 1 -> {
                    System.out.println("Ha seleccionado Administrador");
                    System.out.println("Introduzca la contraseña:");
                    int contraseña = teclado.leerInt();
                    if (contraseña == 4567) {
                        boolean adminSalir = false;
                        while (! adminSalir) {
                            System.out.println("Introduzca una opcion:");
                            System.out.println("1. Añadir bebidas");
                            System.out.println("2. Retirar dinero");
                            System.out.println("3. Actualizar precios");
                            System.out.println("4. Lista de bebidas");
                            System.out.println("5. Lista de monedas");
                            System.out.println("0. Volver al menu de inicio");
                            int opcionAdministrador = teclado.leerInt();
                            switch (opcionAdministrador) {
                                case 1 -> {
                                    System.out.println("Ha seleccionado Añadir bebidas");
                                    System.out.println("Introduzca el nombre de la bebida:");
                                    String nombre = teclado.leerString();
                                    for (int i = 0; i < bebidas.length; i++) {
                                        if (bebidas[i] != null && bebidas[i].getNombre().equalsIgnoreCase(nombre)) {
                                            System.out.println("La bebida ya existe. Introduzca la cantidad a añadir:");
                                            int cantidad = teclado.leerInt();
                                            bebidas[i].setCantidad(bebidas[i].getCantidad() + cantidad);
                                            System.out.println("Cantidad actualizada.");
                                        }
                                    }
                                    System.out.println("Introduzca el precio de la bebida:");
                                    double precio = teclado.leerDouble();
                                    System.out.println("Introduzca la cantidad de la bebida:");
                                    int cantidad = teclado.leerInt();
                                    int indice = 0;
                                    for (int i = 0; i < bebidas.length; i++) {
                                        if (bebidas[i] == null) {
                                            indice = i;
                                        }
                                    }
                                    bebidas[indice] = new Bebidas(nombre, precio, cantidad);
                                }
                                case 2 -> {
                                    System.out.println("Ha seleccionado Retirar dinero");
                                    for (int i = 0; i < monedas.length; i++) {
                                        if (monedas[i] != null) {
                                            monedas[i].setCantidad(monedas[i].getCantidad() - monedas[i].getCantidad());
                                            monedas[i].setCantidad(5);
                                        }
                                    }
                                }
                                case 3 -> {
                                    System.out.println("Ha seleccionado Actualizar precios");
                                    System.out.println("Introduzca el nombre de la bebida a actualizar:");
                                    String nombreActualizar = teclado.leerString();
                                    for (int i = 0; i < bebidas.length; i++) {
                                        if (bebidas[i] != null && bebidas[i].getNombre().equalsIgnoreCase(nombreActualizar)) {
                                            System.out.println("Introduzca el nuevo precio:");
                                            double nuevoPrecio = teclado.leerDouble();
                                            bebidas[i].setPrecio(nuevoPrecio);
                                            System.out.println("Precio actualizado.");
                                        }
                                    }
                                }
                                case 4 -> {
                                    System.out.println("Ha seleccionado Lista de bebidas");
                                    for (int i = 0; i < bebidas.length; i++) {
                                        if (bebidas[i] != null) {
                                            bebidas[i].mostrar();
                                        }
                                    }
                                }
                                case 5 -> {
                                    System.out.println("Ha seleccionado Lista de monedas");
                                    for (int i = 0; i < monedas.length; i++) {
                                        if (monedas[i] != null) {
                                            monedas[i].mostrar();
                                        }
                                    }
                                }
                                case 0 -> {
                                    System.out.println("Volviendo al menu de inicio...");
                                    adminSalir = true;
                                }
                                default -> System.out.println("Opcion no valida.");
                            }
                        }
                    } else {
                        System.out.println("Contraseña incorrecta.");
                    }
                }
                case 2 -> {
                    System.out.println("Ha seleccionado Usuario");
                    System.out.println("Lista de bebidas disponibles: ");
                    for (int i = 0; i < bebidas.length; i++) {
                        if (bebidas[i] != null) {
                            bebidas[i].mostrar();
                        }
                    }
                    System.out.println("Introduzca el nombre de la bebida que desea comprar:");
                    String nombreBebida = teclado.leerString();
                    double precioBebida = 0;
                    boolean hayBebida = false;
                    for (int i = 0; i < bebidas.length; i++) {
                        if (bebidas[i] != null && bebidas[i].getNombre().equalsIgnoreCase(nombreBebida)) {
                            System.out.println("La bebida cuesta: " + bebidas[i].getPrecio() + "€");
                            precioBebida = bebidas[i].getPrecio();
                            if (bebidas[i].getCantidad() > 0) {
                                hayBebida = true;
                            }
                        }
                    }
                    double dineroTotal;
                    for (dineroTotal = 0; dineroTotal < precioBebida; ) {
                        System.out.println("Introduzca la cantidad de dinero que va a insertar: (1c, 2c, 5c, 10c, 20c, 50c, 1€ y 2€)");
                        String tipoMoneda = teclado.leerString();
                        if (tipoMoneda.equalsIgnoreCase("1c")) {
                            System.out.println("Introduce la cantidad de monedas de 1 centimo:");
                            int cantidad = teclado.leerInt();
                            dineroTotal += cantidad * 0.01;
                            for (int i = 0; i < monedas.length; i++) {
                                if (monedas[i].getValor() == 0.01) {
                                    monedas[i].setCantidad(monedas[i].getCantidad() + cantidad);
                                }
                            }
                        }
                        if (tipoMoneda.equalsIgnoreCase("2c")) {
                            System.out.println("Introduce la cantidad de monedas de 2 centimos:");
                            int cantidad = teclado.leerInt();
                            dineroTotal += cantidad * 0.02;
                            for (int i = 0; i < monedas.length; i++) {
                                if (monedas[i].getValor() == 0.02) {
                                    monedas[i].setCantidad(monedas[i].getCantidad() + cantidad);
                                }
                            }
                        }
                        if (tipoMoneda.equalsIgnoreCase("5c")) {
                            System.out.println("Introduce la cantidad de monedas de 5 centimos:");
                            int cantidad = teclado.leerInt();
                            dineroTotal += cantidad * 0.05;
                            for (int i = 0; i < monedas.length; i++) {
                                if (monedas[i].getValor() == 0.05) {
                                    monedas[i].setCantidad(monedas[i].getCantidad() + cantidad);
                                }
                            }
                        }
                        if (tipoMoneda.equalsIgnoreCase("10c")) {
                            System.out.println("Introduce la cantidad de monedas de 10 centimos:");
                            int cantidad = teclado.leerInt();
                            dineroTotal += cantidad * 0.10;
                            for (int i = 0; i < monedas.length; i++) {
                                if (monedas[i].getValor() == 0.10) {
                                    monedas[i].setCantidad(monedas[i].getCantidad() + cantidad);
                                }
                            }
                        }
                        if (tipoMoneda.equalsIgnoreCase("20c")) {
                            System.out.println("Introduce la cantidad de monedas de 20 centimos:");
                            int cantidad = teclado.leerInt();
                            dineroTotal += cantidad * 0.20;
                            for (int i = 0; i < monedas.length; i++) {
                                if (monedas[i].getValor() == 0.20) {
                                    monedas[i].setCantidad(monedas[i].getCantidad() + cantidad);
                                }
                            }
                        }
                        if (tipoMoneda.equalsIgnoreCase("50c")) {
                            System.out.println("Introduce la cantidad de monedas de 50 centimos:");
                            int cantidad = teclado.leerInt();
                            dineroTotal += cantidad * 0.50;
                            for (int i = 0; i < monedas.length; i++) {
                                if (monedas[i].getValor() == 0.50) {
                                    monedas[i].setCantidad(monedas[i].getCantidad() + cantidad);
                                }
                            }
                        }
                        if (tipoMoneda.equalsIgnoreCase("1€")) {
                            System.out.println("Introduce la cantidad de monedas de 1 euro:");
                            int cantidad = teclado.leerInt();
                            dineroTotal += cantidad * 1.00;
                            for (int i = 0; i < monedas.length; i++) {
                                if (monedas[i].getValor() == 1.00) {
                                    monedas[i].setCantidad(monedas[i].getCantidad() + cantidad);
                                }
                            }
                        }
                        if (tipoMoneda.equalsIgnoreCase("2€")) {
                            System.out.println("Introduce la cantidad de monedas de 2 euros:");
                            int cantidad = teclado.leerInt();
                            dineroTotal += cantidad * 2.00;
                            for (int i = 0; i < monedas.length; i++) {
                                if (monedas[i].getValor() == 2.00) {
                                    monedas[i].setCantidad(monedas[i].getCantidad() + cantidad);
                                }
                            }
                        }
                    }
                    double cambio;
                    if (dineroTotal >= precioBebida && hayBebida) {
                        cambio = dineroTotal - precioBebida;
                        System.out.println("Gracias por su compra. Su cambio es: " + cambio + "€");
                        for (int i = 0; i < bebidas.length; i++) {
                            if (bebidas[i] != null && bebidas[i].getNombre().equalsIgnoreCase(nombreBebida)) {
                                bebidas[i].setCantidad(bebidas[i].getCantidad() - 1);
                            }
                        }
                        boolean terminado = false;
                        while (! terminado) {
                            for (int i = monedas.length - 1; i >= 0; i--) {
                                if (monedas[i].getValor() <= cambio && monedas[i].getCantidad() > 0) {
                                    monedas[i].setCantidad(monedas[i].getCantidad() - 1);
                                    cambio -= monedas[i].getValor();
                                }
                                if (cambio <= 0) {
                                    terminado = true;
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}