package A.A7;

public class TestPartido {
    public static void main(String[] args) {
        Equipo equipo1 = new Equipo("Real Madrid");
        Equipo equipo2 = new Equipo("Atletico de Madrid");
        Equipo equipo3 = new Equipo("FC Barcelona");

        Partido partido = new Partido(equipo1, equipo2);
        partido.jugarPartido();
        Partido partido2 = new Partido(equipo1, equipo3);
        partido2.jugarPartido();
        Partido partido3 = new Partido(equipo2, equipo3);
        partido3.jugarPartido();
        Partido partido4 = new Partido(equipo2, equipo1);
        partido4.jugarPartido();
        Partido partido5 = new Partido(equipo3, equipo1);
        partido5.jugarPartido();
        Partido partido6 = new Partido(equipo3, equipo2);
        partido6.jugarPartidoPonderada();

        System.out.println("Estadísticas de los equipos:");
        partido.mostrarLocal();
        System.out.println();
        partido3.mostrarLocal();
        System.out.println();
        partido5.mostrarLocal();
    }
}
