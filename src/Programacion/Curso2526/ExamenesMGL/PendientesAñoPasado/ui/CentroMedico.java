package Programacion.Curso2526.ExamenesMGL.PendientesAñoPasado.ui;

import Programacion.Curso2526.ExamenesMGL.PendientesAñoPasado.comun.Teclado;
import Programacion.Curso2526.ExamenesMGL.PendientesAñoPasado.dao.PacienteDAO;
import Programacion.Curso2526.ExamenesMGL.PendientesAñoPasado.dao.MedicoDAO;
import Programacion.Curso2526.ExamenesMGL.PendientesAñoPasado.model.Medico;
import Programacion.Curso2526.ExamenesMGL.PendientesAñoPasado.service.*;

import java.io.IOException;
import java.util.List;

public class CentroMedico {
    private static Teclado t = new Teclado();

    private static void mostrarMenu() {
        System.out.println("1-Apuntar paciente");
        System.out.println("2-Atender paciente");
        System.out.println("3-listar pacientes en espera");
        System.out.println("4-Mostrar Medico mas consultas");
        System.out.println("0-Salir");
    }

    private static void menu(CentroMedicoService servicioCentroMedico) throws IOException {
        int opcion;
        do {
            mostrarMenu();
            opcion = t.leerInt();
            switch (opcion) {
                case 1 -> acudePaciente(servicioCentroMedico);
                case 2 -> atenderPaciente(servicioCentroMedico);
                case 3 -> listarPacientesEspera(servicioCentroMedico);
                case 4 -> mostrarMedicoMasConsultas(servicioCentroMedico);
                case 0 -> System.out.println("Fin de la aplicación...");
                default -> System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
        } while (opcion != 0);
    }

    private static void acudePaciente(CentroMedicoService servicioCentroMedico) throws IOException {
        System.out.print("Introduzca el ID del paciente: ");
        int idPaciente = t.leerInt();
        System.out.println("Introduzca id Médico");
        String idMedico = t.leerString();
        /*1A-Rellenar el código para guardar los datos del paciente */
        int nTurno = servicioCentroMedico.anadirVisita(idPaciente, idMedico);
        if (nTurno >= 0) {
            System.out.println("El paciente será atendido. Su turno es " + nTurno);
        } else {
            System.out.println("El médico no puede atenderle hoy.");
        }
    }

    private static void atenderPaciente(CentroMedicoService servicioCentroMedico) throws IOException {
        System.out.println("Introduzca id Médico");
        String idMedico = t.leerString();
        /*2A-Rellenar el código para atención a un paciente utilizando los métodos de la clase de servicio*/
        int turno = servicioCentroMedico.medicoAtiende(idMedico);
        if (turno >= 0) {
            System.out.println("Se atiende al paciente con turno: " + turno);
        } else {
            System.out.println("No hay pacientes en espera para este médico.");
        }
    }

    private static void listarPacientesEspera(CentroMedicoService servicioCentroMedico) throws IOException {
        /*3A-Rellenar el código para mostrar los pacientes en espera  */
        System.out.println("Introduzca id Médico");
        String idMedico = t.leerString();
        List<String> visitas = servicioCentroMedico.listarVisitasHoy();
        System.out.println("\n--- Pacientes en espera para el médico " + idMedico + " ---");
        if (visitas.isEmpty()) {
            System.out.println("No hay pacientes en espera.");
        } else {
            for (String visita : visitas) {
                if (visita.contains(idMedico)) {
                    System.out.println(visita);
                }
            }
        }
    }

    private static void mostrarMedicoMasConsultas(CentroMedicoService servicioCentroMedico) {
        /*4A-Rellenar el código para mostrar el médico con más consultas atendidas en el año.*/
        List<Medico> medicos = servicioCentroMedico.getMedicosMasConsultas(2);
        if (medicos == null || medicos.isEmpty()) {
            System.out.println("No hay médicos para mostrar.");
        } else {
            System.out.println("\n--- Medicos que más atienden---");
            for (Medico m : medicos) {
                System.out.printf("ID: %s, %d %n", m.getIdMedico(), m.getNumPacientesAtendidos());
            }
        }
    }

    public static void main(String[] args) throws IOException {
        CentroMedicoService servicioCentroMedico = null;
        MedicoDAO medicoDAO = new MedicoDAO();
        PacienteDAO pacienteDAO = new PacienteDAO();
        try {
            servicioCentroMedico = new CentroMedicoService(medicoDAO, pacienteDAO);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        menu(servicioCentroMedico);
        servicioCentroMedico.guardarPacientes();
    }
}