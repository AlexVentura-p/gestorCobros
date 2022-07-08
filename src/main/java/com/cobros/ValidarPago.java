package com.cobros;

import java.util.Scanner;

public class ValidarPago {

  public Cuenta validarPago(Cuenta cuenta) {
    String opcion = "";
    Scanner entrada = new Scanner(System.in);
    System.out.println("El cliente efectuo el pago?");
    opcion = entrada.nextLine();
    if (opcion.equals("si")) {
      EstadoCuenta ec = new EstadoCuenta();
      ec.estadoCuenta(cuenta.getNumeroCuenta());
    } else if (!opcion.equals("si")) {
      double interes = 0.10;
      double nuevoMonto = cuenta.getMonto() + (cuenta.getMonto() * interes);
      cuenta.setMonto(nuevoMonto);
      System.out.println("Monto Actualizado. Monto incrementado en 10%");
    }
    return cuenta;
  }
}
