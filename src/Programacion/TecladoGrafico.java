package Programacion;

import javax.swing.JOptionPane;

public class TecladoGrafico {
    public int leerInt(String texto){
        int num=0;
        num=Integer.parseInt(JOptionPane.showInputDialog(texto));
        return num;
    }
    double leerDouble(String texto){
        double num=Double.parseDouble(JOptionPane.showInputDialog(texto));
        return num;
    }
    String leerString(String texto){
        String t=JOptionPane.showInputDialog(texto);
        return t;
    }
    void mostrarMsg(String texto){
        JOptionPane.showMessageDialog(null,texto);
    }
    int botonSeleccion(String opciones[]){
        Object botones[]= new Object[opciones.length];
        for (int i=0; i<opciones.length; i++)
            botones[i]=opciones[i];
        int opc = JOptionPane.showOptionDialog(
                null,  //componente padre
                "Seleccione opcion",  //mensaje
                "Selector de opciones", //titulo de la ventana
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,    // null para icono por defecto.
                botones,   // null para YES, NO y CANCEL
                botones[0]);  //opcion por defecto

        return opc;
    }
    int menuSeleccion(String opciones[]){
        Object opcionesObj[]= new Object[opciones.length];
        for (int i=0; i<opciones.length; i++)
            opcionesObj[i]=opciones[i];
        Object opc = JOptionPane.showInputDialog(
                null,
                "Seleccione opcion",
                "Selector de opciones",
                JOptionPane.PLAIN_MESSAGE,
                null,  // null para icono defecto
                opcionesObj,
                opcionesObj[0]);

        //System.out.println("El usuario ha elegido "+opc);
        int i=0;
        while (opc!= opcionesObj[i]) i++;

        return i;
    }
    public static void main (String a[]){
        TecladoGrafico t= new TecladoGrafico();
        int n= t.leerInt("Dar numero");
        System.out.println("Numero leido:"+ n);
        double d= t.leerDouble("Dar numero real");
        System.out.println("Numero leido:"+ d);
        String s= t.leerString("Dar String");
        System.out.println("String leido:"+ s);
        t.mostrarMsg("Se acabo \n fin");

        String msgs[]={"cero","uno", "dos", "tres"};
        n=t.botonSeleccion(msgs);
        System.out.println("Opcion elegida:"+n);

        String msgs2[]={"opc00","opc01", "opc02"};
        n=t.menuSeleccion(msgs2);
        System.out.println("Opcion elegida:"+n);

    }
}