package Programacion.Curso2526.E.E7;

public class E7_Radares {
    Vehiculo[] radar1;
    Vehiculo[] radar2;
    Denuncias[] multados;

    public static long currentTimeMillis() {
        return System.currentTimeMillis();
    }

    public E7_Radares() {
        radar1 = new Vehiculo[100];
        radar2 = new Vehiculo[100];
        multados = new Denuncias[100];
    }

    Denuncias[] multar(Vehiculo[] radar1, Vehiculo[] radar2) {
        for (int i = 0; i < radar1.length; i++) {
            if (radar1[i] != null) {
                String matricula = radar1[i].getMatricula();
                for (int j = 0; j < radar2.length; j++) {
                    if (radar2[j] != null) {
                        if (matricula.equals(radar2[j].getMatricula())) {
                            long tiempoDePaso = radar2[j].getTiempoDePaso() - radar1[i].getTiempoDePaso();
                            tiempoDePaso = tiempoDePaso / 1000; // convertir a segundos
                            tiempoDePaso = tiempoDePaso / 3600; // convertir a horas
                            double velocidad = 10 / tiempoDePaso; // distancia entre radares es de 10 km
                            if (velocidad > 121 && velocidad < 150) {
                                for (int k = 0; k < multados.length; k++) {
                                    if (multados[k] != null) {
                                        multados[k].matricula = matricula;
                                        multados[k].velocidad = (int) velocidad;
                                        multados[k].puntos = 0;
                                        multados[k].importe = 100;
                                        return multados;
                                    }
                                }
                            }
                            if (velocidad >= 151 && velocidad < 170) {
                                for (int k = 0; k < multados.length; k++) {
                                    if (multados[k] != null) {
                                        multados[k].matricula = matricula;
                                        multados[k].velocidad = (int) velocidad;
                                        multados[k].puntos = 2;
                                        multados[k].importe = 300;
                                        return multados;
                                    }
                                }
                            }
                            if (velocidad >= 171 && velocidad < 180) {
                                for (int k = 0; k < multados.length; k++) {
                                    if (multados[k] != null) {
                                        multados[k].matricula = matricula;
                                        multados[k].velocidad = (int) velocidad;
                                        multados[k].puntos = 4;
                                        multados[k].importe = 400;
                                        return multados;
                                    }
                                }
                            }
                            if (velocidad >= 181 && velocidad < 190) {
                                for (int k = 0; k < multados.length; k++) {
                                    if (multados[k] != null) {
                                        multados[k].matricula = matricula;
                                        multados[k].velocidad = (int) velocidad;
                                        multados[k].puntos = 6;
                                        multados[k].importe = 500;
                                        return multados;
                                    }
                                }
                            }
                            if (velocidad >= 191) {
                                for (int k = 0; k < multados.length; k++) {
                                    if (multados[k] != null) {
                                        multados[k].matricula = matricula;
                                        multados[k].velocidad = (int) velocidad;
                                        multados[k].puntos = 6;
                                        multados[k].importe = 600;
                                        return multados;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    Vehiculo[] obtennerRadar1() {
        for (int i = 0; i < radar1.length; i++) {
            if (radar1[i] != null) {
                radar1[i].tiempoDePaso = System.currentTimeMillis();
                radar1[i].matricula = Vehiculo.getMatricula();
            }
        }
        return radar1;
    }

    Vehiculo[] obtennerRadar2() {
        for (int i = 0; i < radar2.length; i++) {
            if (radar2[i] != null) {
                radar2[i].tiempoDePaso = System.currentTimeMillis();
                radar2[i].matricula = Vehiculo.getMatricula();
            }
        }
        return radar2;
    }
}