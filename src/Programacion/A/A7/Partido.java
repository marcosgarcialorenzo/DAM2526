package Programacion.A.A7;

public class Partido {
    Equipo equipolocal;
    Equipo equipovisitante;

    Partido(Equipo local, Equipo visitante) {
        equipolocal = local;
        equipovisitante = visitante;
    }

    void mostrarLocal() {
        System.out.println("Nombre del equipo: " + equipolocal.getNombre());
        System.out.println("Goles a favor: " + equipolocal.getGolesFavor());
        System.out.println("Goles en contra: " + equipolocal.getGolesContra());
        System.out.println("Puntos: " + equipolocal.getPuntos());
    }

    void mostrarVisitante() {
        System.out.println("Nombre del equipo: " + equipovisitante.getNombre());
        System.out.println("Goles a favor: " + equipovisitante.getGolesFavor());
        System.out.println("Goles en contra: " + equipovisitante.getGolesContra());
        System.out.println("Puntos: " + equipovisitante.getPuntos());
    }

    void jugarPartido() {
        int golesLocal = (int) (Math.random() * 11); //goles entre 0 y 10
        int golesVisitante = (int) (Math.random() * 11); //goles entre 0 y 10

        int golesFavorLocal = equipolocal.getGolesFavor() + golesLocal;
        int golesContraLocal = equipolocal.getGolesContra() + golesVisitante;
        int golesFavorVisitante = equipovisitante.getGolesFavor() + golesVisitante;
        int golesContraVisitante = equipovisitante.getGolesContra() + golesLocal;

        equipolocal.setGolesFavor(golesFavorLocal);
        equipolocal.setGolesContra(golesContraLocal);
        equipovisitante.setGolesFavor(golesFavorVisitante);
        equipovisitante.setGolesContra(golesContraVisitante);

        if (golesLocal > golesVisitante) {
            int puntosLocal = equipolocal.getPuntos() + 3;
            equipolocal.setPuntos(puntosLocal);
        } else if (golesLocal < golesVisitante) {
            int puntosVisitante = equipovisitante.getPuntos() + 3;
            equipovisitante.setPuntos(puntosVisitante);
        } else {
            int puntosLocal = equipolocal.getPuntos() + 1;
            int puntosVisitante = equipovisitante.getPuntos() + 1;
            equipolocal.setPuntos(puntosLocal);
            equipovisitante.setPuntos(puntosVisitante);
        }
    }

    void jugarPartidoPonderada() {
        int golesLocal = 0;
        int golesVisitante = 0;
        if (equipolocal.getPuntos() > equipovisitante.getPuntos()) { //el que tenga mas puntos en la liga tiene mas posibilidades de marcar gol
            golesLocal = golesLocal + ((int) (Math.random() * 11));
        } else if (equipolocal.getPuntos() < equipovisitante.getPuntos()) {
            golesVisitante = golesVisitante + ((int) (Math.random() * 11));
        }

        golesLocal = golesLocal + ((int) (Math.random() * 11));
        golesLocal = golesLocal +  ((int) (Math.random() * 11));//lo pongo dos veces para simular el doble de posibilidades porque es el local
        golesVisitante = golesVisitante + ((int) (Math.random() * 11));

    }
}