package sesion01;

// COMENTAR UNA LÍNEA: CTRL + /
//  En una tienda el administrador quiere implementar una aplicación que
//  permita calcular el pago total que deberá de abonar el cliente. Sabiendo
//  que al comprar 2 productos el segundo tiene un 15% de descuento
//  (al monto resultante se debe incrementar el IGV)
//  Nota: Para todos los casos asuma que deberá de ingresar 2 productos.
//  Los valores son ingresados a través del teclado.
//  Escriba el algoritmo en java que permita atender el requerimiento.

import java.util.Scanner;

public class ejercicio01 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in); // Almacenar información escrita por teclado.

        double producto1, producto2, pagoTotal, montoDscto, subTotal;
        final double PORC_DESC = 0.15;
        final double IGV = 0.18;

        System.out.println("Ingrese precio de producto 1: ");
        producto1 = teclado.nextDouble();

        System.out.println("Ingrese precio de producto 2: ");
        producto2 = teclado.nextDouble();

        montoDscto = producto2 * PORC_DESC;
        subTotal = producto1 + producto2 - montoDscto;

        pagoTotal = subTotal * (IGV + 1);

        System.out.println("\nPrecio total es: " + pagoTotal);
    }
}