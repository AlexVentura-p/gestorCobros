package com.admincobros;

import java.math.BigDecimal;
import java.util.Scanner;

public class ValidarPago {

  public Cuenta validarPago(Cuenta cuenta) {
    String opcion = "";
    Scanner entrada = new Scanner(System.in);
    System.out.println("El cliente efectuo el pago?");
    opcion = entrada.nextLine();
    if (opcion.equals("si")) {
      cuenta.setMonto(cuenta.getMonto().subtract(cuenta.getCuota()));
      EstadoCuenta ec = new EstadoCuenta();
      ec.estadoCuenta(cuenta);
    } else {
      BigDecimal interes = new BigDecimal("0.10");
      cuenta.setMonto(cuenta.getMonto().add(cuenta.getMonto().multiply(interes)));
      System.out.println("Monto Actualizado. Monto incrementado en 10%");
    }
    return cuenta;
  }
}
