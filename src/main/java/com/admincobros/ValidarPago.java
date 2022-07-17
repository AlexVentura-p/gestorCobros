package com.admincobros;

import com.Bitacora;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ValidarPago {
  Bitacora bitacora = new Bitacora();
  private final static Logger LOGGER = Logger.getLogger("validarPago");

  public Cuenta validarPago(Cuenta cuenta) {
    String opcion = "";
    Scanner entrada = new Scanner(System.in);
    System.out.println("El cliente efectuo el pago?");
    opcion = entrada.nextLine();
    if (opcion.equals("si")) {
      EstadoCuenta ec = new EstadoCuenta();
      ec.estadoCuenta(cuenta);
    } else if (!opcion.equals("si")) {
      double interes = 0.10;
      double nuevoMonto = cuenta.getMonto() + (cuenta.getMonto() * interes);
      cuenta.setMonto(nuevoMonto);
      LOGGER.log(Level.INFO,"Monto Actualizado. Monto incrementado en 10%");
      bitacora.controlLog(LOGGER);
    }
    return cuenta;
  }
}
