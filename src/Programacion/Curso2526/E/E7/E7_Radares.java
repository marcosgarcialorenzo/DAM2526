package Programacion.Curso2526.E.E7;

public class E7_Radares {
    Vehiculo[] radar1;
    Vehiculo[] radar2;
    Denuncias[] multas;

    Denuncias[] multar(Vehiculo[] radar1, Vehiculo[] radar2) {
        Denuncias[] multados = new Denuncias[100];
        for (int i = 0; i < radar1.length; i++) {
            if (radar1[i] == null) {
                // nada
            } else {
                String matricula = radar1[i].getMatricula();
                for (int j = 0; j < radar2.length; j++) {
                    if (radar2[j] == null) {
                        // nada
                    } else {
                        if (matricula.equals(radar2[j].getMatricula())) {
                            long diffMs = radar2[j].getTiempoDePaso() - radar1[i].getTiempoDePaso();
                            if (diffMs > 0) { // evitar 0 o negativos
                                double hours = diffMs / 3_600_000.0; // ms -> horas (double)
                                double velocidad = 10.0 / hours; // distancia = 10 km

                                Denuncias nueva = null;
                                if (velocidad >= 121 && velocidad < 151) {
                                    nueva = new Denuncias(matricula, (int) velocidad, 0, 100);
                                } else if (velocidad >= 151 && velocidad < 171) {
                                    nueva = new Denuncias(matricula, (int) velocidad, 2, 300);
                                } else if (velocidad >= 171 && velocidad < 181) {
                                    nueva = new Denuncias(matricula, (int) velocidad, 4, 400);
                                } else if (velocidad >= 181 && velocidad < 191) {
                                    nueva = new Denuncias(matricula, (int) velocidad, 6, 500);
                                } else if (velocidad >= 191) {
                                    nueva = new Denuncias(matricula, (int) velocidad, 6, 600);
                                }

                                if (nueva != null) {
                                    boolean colocado = false;
                                    for (int k = 0; k < multados.length && !colocado; k++) {
                                        if (multados[k] == null) {
                                            multados[k] = nueva;
                                            colocado = true; // detenemos la búsqueda sin usar break
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return multados;
    }
}

//    Vehiculo[] obtenerRadar1(Vehiculo v, Vehiculo[] radar1) {
//        for (int i = 0; i < radar1.length; i++) {
//            if (radar1[i] != null) {
//                radar1[i].tiempoDePaso = System.currentTimeMillis();
//                radar1[i].matricula = v.getMatricula();
//            }
//        }
//        return radar1;
//    }
//
//    Vehiculo[] obtenerRadar2(Vehiculo v, Vehiculo[] radar2) {
//        for (int i = 0; i < radar2.length; i++) {
//            if (radar2[i] != null) {
//                radar2[i].tiempoDePaso = System.currentTimeMillis();
//                radar2[i].matricula = v.getMatricula();
//            }
//        }
//        return radar2;
//    }