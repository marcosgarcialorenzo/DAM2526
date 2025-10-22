package B.B3;

public class B3_Seguro {

    B3_Seguro() {
    }

    public static void main(String[] args) {
        B3_Seguro seguro1 = new B3_Seguro();
        seguro1.calcularPrecio('h', 5, 'p'); // pequeño caso1
        seguro1.calcularPrecio('h', 2, 'p'); // pequeño caso2
        seguro1.calcularPrecio('m', 2, 'm'); // mediano caso1
        seguro1.calcularPrecio('h', 4, 'm'); // mediano caso2
        seguro1.calcularPrecio('h', 2, 'm'); // mediano caso3
        seguro1.calcularPrecio('m', 8, 'g'); // grande caso1
        seguro1.calcularPrecio('m', 1, 'g'); // grande caso2
        seguro1.calcularPrecio('h', 5, 'g'); // grande caso3
    }

    public double calcularPrecio(char sexo, double agnosTranscurridos, char tipoCoche) {
        double tarifaBase = 0;
        double descuento = 0;
        double precioFinal;

        switch (tipoCoche) {
            case 'p': // pequeño
                tarifaBase = 400;
                if (agnosTranscurridos >= 5) {
                    descuento = 0.15;
                } else {
                    descuento = 0.10;
                }
                break;
            case 'm': // mediano
                tarifaBase = 600;
                if (sexo == 'm') {
                    descuento = 0.16;
                } else if (sexo == 'h' && agnosTranscurridos >= 3) {
                    descuento = 0.17;
                } else if (agnosTranscurridos < 3) {
                    descuento = 0.10;
                }
                break;
            case 'g': // grande
                tarifaBase = 900;
                if (agnosTranscurridos >= 7) {
                    descuento = 0.20;
                } else if (sexo == 'm') {
                    descuento = 0.10;
                } else if (sexo == 'h') {
                    descuento = 0.08;
                }
                break;
        }
        precioFinal = tarifaBase - (tarifaBase * descuento);
        System.out.println("El precio final del seguro es: " + precioFinal + "€");
        return precioFinal;
    }
}
