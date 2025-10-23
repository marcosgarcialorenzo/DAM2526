package Programacion.A.A12;

public class A12_Seguro {
    Vehiculo vehiculo;
    double prima;

    A12_Seguro(Vehiculo vehiculo, double prima) {
        this.vehiculo = vehiculo;
        this.prima = prima;
    }

    public static void main(String[] args) {
        Persona persona1 = new Persona("Juan", 22);
        Persona persona2 = new Persona("Carlos", 30);
        Persona persona3 = new Persona("David", 80);

        Vehiculo vehiculo1 = new Vehiculo("5776-CNS", 160000, persona1);
        Vehiculo vehiculo2 = new Vehiculo("5892-ABR", 260000, persona2);
        Vehiculo vehiculo3 = new Vehiculo("5656-KVN", 15000, persona3);

        A12_Seguro seguro1 = new A12_Seguro(vehiculo2, 1000.0);
        A12_Seguro seguro2 = new A12_Seguro(vehiculo2, 1200.0);
        A12_Seguro seguro3 = new A12_Seguro(vehiculo3, 1500.0);

        seguro1.mostrarDatos();
        seguro2.subirPorKm();
        seguro3.subirPorEdad();
    }

    void mostrarDatos() {
        System.out.println("Matrícula: " + vehiculo.matricula);
        System.out.println("Kilometraje: " + vehiculo.kilometraje);
        System.out.println("Edad del propietario: " + vehiculo.propietario.edad);
    }

    double subirPorKm() {
        if (vehiculo.kilometraje > 150000) {
            prima += prima * 0.10;
        } else if (vehiculo.kilometraje > 200.000) {
            prima += prima * 0.12;
        }
        return prima;
    }

    double subirPorEdad() {
        if (vehiculo.propietario.edad < 23) {
            prima += prima * 0.15;
        } else if (vehiculo.propietario.edad > 65) {
            prima += prima * 0.05;
        }
        return prima;
    }
}