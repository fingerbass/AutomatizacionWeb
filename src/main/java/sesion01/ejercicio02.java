package sesion01;

// Un estacionamiento de autos cobra por hora S/.5.5, calcular
// el monto total que deberá de abonar el cliente luego de permanecer en el
// estacionamiento cierta cantidad de horas  (al monto resultante se debe
// incrementar el IGV y un descuento del 8%)
//
// Los valores son ingresados a través del teclado.
//
// Escriba el algoritmo en java que permita atender el requerimiento del área usuaria.

import java.util.Scanner;

public class ejercicio02 {
    public static void main(String[] args) {
        Scanner calcular = new Scanner(System.in);
        double cantHoras, subtotal, total, montodescuento, pagototal;
        final double prec_hora = 5.5;
        final double desc_porc = 0.08;
        final double IGV = 0.18;
        System.out.println("ingrese la cantidad de horas: ");
        cantHoras = calcular.nextDouble();

        total = prec_hora * cantHoras;
        montodescuento = total * desc_porc;
        subtotal = total - montodescuento;
        pagototal = subtotal * (IGV + 1);
        System.out.println("\nPrecio total es: " + pagototal);
    }
}
