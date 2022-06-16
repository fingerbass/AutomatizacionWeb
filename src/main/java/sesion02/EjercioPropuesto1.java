package sesion02;

import java.util.Scanner;

public class EjercioPropuesto1 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in); // Almacenar información escrita por teclado.
        double horaEntrada, horaSalida, totalHora, montoTotalhoras, montoTotalpagar, montoTotalDescuento;
        final double DESCUENTO = 0.8;
        final double IGV = 0.18;
        final double COBRO_HORA =5.5;
        System.out.println(" por favor Ingrese la hora de entrada: ");
        horaEntrada = teclado.nextDouble();
        System.out.println("POr favor Ingrese hora de Salida: ");
        horaSalida= teclado.nextDouble();
        totalHora = (horaSalida- horaEntrada);
        System.out.println("\n total de hora de estacionamiento : " + totalHora);
        montoTotalhoras= totalHora * COBRO_HORA;
        System.out.println("\n MONTO POR HORA: " + montoTotalhoras);
        montoTotalDescuento= montoTotalhoras - DESCUENTO;
        System.out.println("\n MONTO DE DESCUENTO: " + montoTotalDescuento);
        montoTotalpagar = montoTotalDescuento * (IGV + 1);
        System.out.println("\n Monto total a pagar estacionamiento: " + montoTotalpagar);

    }
}
