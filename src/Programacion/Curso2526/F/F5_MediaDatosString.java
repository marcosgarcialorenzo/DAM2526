package Programacion.Curso2526.F;

public class F5_MediaDatosString {

    double mediaDatosString(String datos) {
        String[] partes = datos.split(":");
        int contadorNotas= 0;
        double suma = 0;

        for (int i = 0; i<partes.length;i++){
            if (i % 2 !=0){
                suma += Double.parseDouble(partes[i]);
                contadorNotas++;
            }
        }
        double media = suma / contadorNotas;
        return  media;
    }

    public static void main(String[] args) {
        String cadena = "Juan:3:Ana Maria:8:Pedro:9";
        F5_MediaDatosString programa = new F5_MediaDatosString();
        double media = programa.mediaDatosString(cadena);
        System.out.println("La media de las notas es: " + media);
    }
}