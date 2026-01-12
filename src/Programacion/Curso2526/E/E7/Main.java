package Programacion.Curso2526.E.E7;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Vehiculo v1 = new Vehiculo("1234-ABC");
        Vehiculo v2 = new Vehiculo("2345-BCD");
        Vehiculo v3 = new Vehiculo("3456-CDE");
        Vehiculo v4 = new Vehiculo("4567-DEF");
        Vehiculo v5 = new Vehiculo("5678-EFG");
        Vehiculo v6 = new Vehiculo("6789-FGH");
        Vehiculo v7 = new Vehiculo("7890-GHI");
        Vehiculo v8 = new Vehiculo("8901-HIJ");
        Vehiculo v9 = new Vehiculo("9012-IJK");
        Vehiculo v10 = new Vehiculo("0123-JKL");

        Vehiculo[] radar1 = new Vehiculo[100];
        Vehiculo[] radar2 = new Vehiculo[100];
        Denuncias[] multados = new Denuncias[100];
        E7_Radares radar = new E7_Radares();

        radar.obtenerRadar1(v1, radar1);
        Thread.sleep(30000);//300000 valores para distancia de 10 km
        radar.obtenerRadar2(v1, radar2);
        radar.obtenerRadar1(v2, radar1);
        Thread.sleep(25700);//257140
        radar.obtenerRadar2(v2, radar2);
        radar.obtenerRadar1(v3, radar1);
        Thread.sleep(24000);//240000
        radar.obtenerRadar2(v3, radar2);
        radar.obtenerRadar1(v4, radar1);
        Thread.sleep(22500);//225000
        radar.obtenerRadar2(v4, radar2);
        radar.obtenerRadar1(v5, radar1);
        Thread.sleep(21200);//212000
        radar.obtenerRadar2(v5, radar2);
        radar.obtenerRadar1(v6, radar1);
        radar.obtenerRadar2(v6, radar2);

        multados = radar.multar(radar1, radar2);
        for (int i = 0; i < multados.length; i++) {
            if (multados[i] != null) {
                multados[i].mostrarDenuncia();
            }
        }
    }
}