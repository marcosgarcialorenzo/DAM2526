package Programacion.Curso2526.E.E5;

import java.util.Scanner;

public class Tienda {
    String nombre;
    /**
     * Los productos y los clientes que se dan de baja se ponen a null y
     * al darlos de alta se colocan en el primer null que se encuentre.
     */
    Producto productos[];
    Cliente clientes[];
    final static int MAXPRODUCTOS = 100;
    final static int MAXCLIENTES = 100;
    private Scanner sc = new Scanner(System.in);

    Tienda(String nombre) {
        this.nombre = nombre;
        productos = new Producto[MAXPRODUCTOS];
        clientes = new Cliente[MAXCLIENTES];
    }

    public void menuPrincipal() {
        Scanner sc = new Scanner(System.in);
        int respuesta;
        do {
            System.out.println("---------------------");
            System.out.println("Elija una opcion:");
            System.out.println("---------------------");
            System.out.println("1.- Alta de producto.");
            System.out.println("2.- Alta de clientes.");
            System.out.println("3.- Baja de producto.");
            System.out.println("4.- Baja de usuario");
            System.out.println("5.- Venta Producto.");
            System.out.println("6.- Modificar Producto.");
            System.out.println("7.- Consulta producto.");
            System.out.println("8.- Consulta cliente.");
            System.out.println("9.- Listado de productos.");
            System.out.println("10.-Listado clientes, con sus compras");
            System.out.println("0.- Fin de la aplicación.");
            System.out.println("---------------------");
            respuesta = sc.nextInt();
            switch (respuesta) {
                case 1 -> altaProducto();
                case 2 -> altaCliente();
                case 3 -> System.out.println("opc");
                case 4 -> System.out.println("opc");
                case 5 -> System.out.println("opc");
                case 6 -> System.out.println("opc");
                case 7 -> System.out.println("opc");
                case 8 -> System.out.println("opc");
                case 9 -> listarProducto();
                case 10 -> listadoClientes();
            }
        } while (respuesta != 0);
        System.out.println("Cerrando aplicacion.");
    }

    private void listadoClientes() {
        System.out.println("Listado de clientes:");
        int cont = 0;
        for (int i = 0; i < clientes.length; i++)
            if (clientes[i] != null) {
                //clientes[i].mostrar();
                System.out.println(clientes[i]);
                cont++;
            }
        if (cont == 0)
            System.out.println("No hay clientes");


    }

    private void listarProducto() {
        int cont = 0;
        for (int i = 0; i < productos.length; i++)
            if (productos[i] != null) {
                System.out.println(productos[i]);
                //                productos[i].mostrar();
                cont++;
            }
        if (cont == 0)
            System.out.println("No hay productos ");
    }

    private void altaCliente() {
        Cliente c = null;
        System.out.println("nombre Cliente");
        String nombre = sc.nextLine().toUpperCase();
        System.out.println("DNI  Cliente");
        String dir = sc.nextLine().toUpperCase();
        c = new Cliente(nombre, dir);
        if (buscarCliente(c) == - 1)
            if (anadirCliente(c))
                System.out.println("Cliente añadido");
            else
                System.out.println("No se puede añadir el cliente");
        else System.out.println("El cliente ya está dado de alta anteriormente");
    }

    private boolean anadirCliente(Cliente c) {
        boolean hayHueco = false;
        int posCliente = buscarCliente(c);
        int pos = buscarHuecoCliente();
        if (pos != - 1) {
            clientes[pos] = c;
            hayHueco = true;
        }
        return hayHueco;
    }

    private int buscarCliente(Cliente c) {
        int pos = - 1;
        for (int i = 0; i < clientes.length && pos == - 1; i++)
            if (clientes[i] != null && clientes[i].equals(c))
                pos = i;
        return pos;
    }

    private int buscarHuecoCliente() {
        int posHueco = - 1;
        for (int i = 0; i < clientes.length && posHueco == - 1; i++)
            if (clientes[i] == null)
                posHueco = i;
        return posHueco;
    }

    private void altaProducto() {
        Producto p = null;
        System.out.println("nombre Producto");
        String nombre = sc.nextLine();
        nombre = nombre.toUpperCase();
        System.out.println("Desea dar el precio (S/N");
        String darPrecio = sc.nextLine();
        if (darPrecio.toUpperCase().startsWith("S")) {
            System.out.println("Dar precio");
            String precioS = sc.nextLine();
            double precio = Double.parseDouble(precioS);
            System.out.println("Desea dar el stock (S/N)");
            String darStock = sc.nextLine();
            if (darStock.toUpperCase().startsWith("S")) {
                String stockS = sc.nextLine();
                int stock = Integer.parseInt(stockS);
                p = new Producto(nombre, precio, stock);
            } else
                p = new Producto(nombre, precio);
        } else // no quiso dar el precio
            p = new Producto(nombre);
        if (anadirProducto(p))
            System.out.println("Producto añadido");
        else System.out.println("No se ha podido añadir el producto");
    }

    private boolean anadirProducto(Producto p) {
        boolean hayHueco = false;
        int pos = buscarHuecoProducto();
        if (pos != - 1) {
            productos[pos] = p;
            hayHueco = true;
        }
        return hayHueco;
    }

    private int buscarHuecoProducto() {
        int posHueco = - 1;
        for (int i = 0; i < productos.length && posHueco == - 1; i++)
            if (productos[i] == null)
                posHueco = i;
        return posHueco;
    }

    public static void main(String[] args) {
        Tienda t = new Tienda("Hnos Pérez");
        t.menuPrincipal();
    }

}