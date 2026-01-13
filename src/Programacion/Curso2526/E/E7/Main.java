package Programacion.Curso2526.E.E7;

public class Main {

    public static void main(String[] args) throws Exception {
        long base = System.currentTimeMillis();
        //velocidad = 36_000_000 / diffMs => diffMs = 36_000_000 / velocidad
        long diffNoMultar = 360_000;   // velocidad ~ 100 km/h (no multa)
        long diff130 = 276_923;        // ~130 km/h (121-150)
        long diff160 = 225_000;        // ~160 km/h (151-170)
        long diff175 = 205_714;        // ~175 km/h (171-180)
        long diff185 = 194_595;        // ~185 km/h (181-190)
        long diff200 = 180_000;        // ~200 km/h (>=191)

        Vehiculo[] radar1 = new Vehiculo[7];
        Vehiculo[] radar2 = new Vehiculo[7];
        // Vehículo 1: sin multa (velocidad baja)
        radar1[0] = new Vehiculo("CAR1", base);
        radar2[0] = new Vehiculo("CAR1", base + diffNoMultar);
        // Vehículo 2: 121-150
        radar1[1] = new Vehiculo("CAR2", base + 1000);
        radar2[1] = new Vehiculo("CAR2", base + 1000 + diff130);
        // Vehículo 3: 151-170
        radar1[2] = new Vehiculo("CAR3", base + 2000);
        radar2[2] = new Vehiculo("CAR3", base + 2000 + diff160);
        // Vehículo 4: 171-180
        radar1[3] = new Vehiculo("CAR4", base + 3000);
        radar2[3] = new Vehiculo("CAR4", base + 3000 + diff175);
        // Vehículo 5: 181-190
        radar1[4] = new Vehiculo("CAR5", base + 4000);
        radar2[4] = new Vehiculo("CAR5", base + 4000 + diff185);
        // Vehículo 6: >=191
        radar1[5] = new Vehiculo("CAR6", base + 5000);
        radar2[5] = new Vehiculo("CAR6", base + 5000 + diff200);
        // Vehículo 7: sin coincidencia en radar2 (no se multará)
        radar1[6] = new Vehiculo("CAR7", base + 6000);
        radar2[6] = null;

        Denuncias[] multasFinal = new Denuncias[100];
        E7_Radares radar = new E7_Radares();

        multasFinal = radar.multar(radar1, radar2);
        for (int i = 0; i < multasFinal.length; i++) {
            if (multasFinal[i] != null) {
                multasFinal[i].mostrarDenuncia();
            }
        }
    }
}