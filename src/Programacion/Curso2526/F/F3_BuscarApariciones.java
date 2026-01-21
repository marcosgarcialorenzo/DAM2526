package Programacion.Curso2526.F;

public class F3_BuscarApariciones {
    static int numApariciones(String s1, String s2) {
        int indice = 0;
        int contador = 0;
        while ((indice = s1.indexOf(s2, indice)) != - 1) {
            contador++;
            indice++;
        }
        return contador;
    }

    public static void main(String[] args) {
        String s1 = "hxxhola adios hhola";
        String s2 = "h";
        int numAparciones = F3_BuscarApariciones.numApariciones(s1, s2);

        /*while (s1.indexOf(s2, indice) !=-1){ //Busco la palabra del s2 en la posicion indicada del s1
            indice = s1.indexOf(s2, indice);
            contador++;
            indice++;}*/

        System.out.println("La palabra aparece una cantidad total de " + numAparciones);
    }
}