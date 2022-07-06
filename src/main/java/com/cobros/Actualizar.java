package com.cobros;

import java.util.Scanner;

public class Actualizar {

    public Cuenta actualizarCuenta(Cuenta cuenta) {
        Scanner input = new Scanner(System.in);
            System.out.println("Ingrese el nuevo correo de cliente");
            cuenta.setCorreo(input.nextLine());
            System.out.println("Ingrese el nuevo nombre de producto: ");
            cuenta.setProducto(input.nextLine());
            System.out.println("Ingrese el nuevo Monto producto: ");
            cuenta.setMonto(input.nextDouble());
            System.out.println("Ingrese la nueva cuota: ");
            cuenta.setCuota(input.nextDouble());
            input.nextLine();
            System.out.println("Ingrese el nuevo estado de la cuenta: ");
            cuenta.setEstado(input.nextLine());
            System.out.println("Datos actualizados correctamente");

            return cuenta;

    }
}