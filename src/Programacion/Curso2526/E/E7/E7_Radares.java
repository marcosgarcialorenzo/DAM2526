package Programacion.Curso2526.E.E7;

public class E7_Radares {
    Vehiculo[] radar1;
    Vehiculo[] radar2;
    Denuncias[] multas;
    //esto no funciona siempre da error de null pointer exception
    Denuncias[] multar(Vehiculo[] radar1, Vehiculo[] radar2) {
        Denuncias[] multados = new Denuncias[100];
        for (int i = 0; i < radar1.length; i++) {
            if (radar1[i] != null) {
                String matricula = radar1[i].getMatricula();
                for (int j = 0; j < radar2.length; j++) {
                    if (radar2[j] != null) {
                        if (matricula.equals(radar2[j].getMatricula())) {
                            long tiempoDePaso = radar2[j].getTiempoDePaso() - radar1[i].getTiempoDePaso();
                            tiempoDePaso = tiempoDePaso / 1000; // convertir a segundos
                            tiempoDePaso = tiempoDePaso / 3600; // convertir a horas
                            double velocidad = 1 / tiempoDePaso; // distancia entre radares es de 10 km en el enunciado para probarlo lo he bajado a 1 km
                            if (velocidad >= 121 && velocidad < 151) {
                                for (int k = 0; k < multados.length; k++) {
                                    if (multados[k] != null) {
                                        Denuncias nueva = new Denuncias(matricula, (int) velocidad, 0, 100);
                                        multados[k] = nueva;
                                    }
                                }
                            }
                            if (velocidad >= 151 && velocidad < 171) {
                                for (int k = 0; k < multados.length; k++) {
                                    if (multados[k] != null) {
                                        Denuncias nueva = new Denuncias(matricula, (int) velocidad, 2, 300);
                                        multados[k] = nueva;
                                    }
                                }
                            }
                            if (velocidad >= 171 && velocidad < 181) {
                                for (int k = 0; k < multados.length; k++) {
                                    if (multados[k] != null) {
                                        Denuncias nueva = new Denuncias(matricula, (int) velocidad, 4, 400);
                                        multados[k] = nueva;

                                    }
                                }
                            }
                            if (velocidad >= 181 && velocidad < 191) {
                                for (int k = 0; k < multados.length; k++) {
                                    if (multados[k] != null) {
                                        Denuncias nueva = new Denuncias(matricula, (int) velocidad, 6, 500);
                                        multados[k] = nueva;

                                    }
                                }
                            }
                            if (velocidad >= 191) {
                                for (int k = 0; k < multados.length; k++) {
                                    if (multados[k] != null) {
                                        Denuncias nueva = new Denuncias(matricula, (int) velocidad, 6, 600);
                                        multados[k] = nueva;
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

    Vehiculo[] obtenerRadar1(Vehiculo v, Vehiculo[] radar1) {
        for (int i = 0; i < radar1.length; i++) {
            if (radar1[i] != null) {
                radar1[i].tiempoDePaso = System.currentTimeMillis();
                radar1[i].matricula = v.getMatricula();
            }
        }
        return radar1;
    }

    Vehiculo[] obtenerRadar2(Vehiculo v, Vehiculo[] radar2) {
        for (int i = 0; i < radar2.length; i++) {
            if (radar2[i] != null) {
                radar2[i].tiempoDePaso = System.currentTimeMillis();
                radar2[i].matricula = v.getMatricula();
            }
        }
        return radar2;
    }
}