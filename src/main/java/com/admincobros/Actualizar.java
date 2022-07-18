package com.admincobros;

import com.enums.CondicionCuenta;
import java.math.BigDecimal;
import com.Bitacora;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Actualizar implements Update {
  Bitacora bitacora = new Bitacora();
  private final static Logger LOGGER = Logger.getLogger("Actualizar");
  public Cuenta actualizarCuenta(Cuenta cuenta) {
    Scanner input = new Scanner(System.in);

    System.out.println("Escoga una opcion: ");
    String answer = "";

    while (!answer.equals("x")) {
      try {
        System.out.println("\na: Cambiar correo ");
        System.out.println("b: Cambiar cuota ");
        System.out.println("c: Cambiar estado ");
        System.out.println("x: Volver menu anterior");
        answer = input.nextLine();
        switch (answer) {
          case "a":
            System.out.println("Correo actual: " + cuenta.getCorreo());
            System.out.print("Nuevo correo: ");
            cuenta.setCorreo(input.nextLine());
            LOGGER.log(Level.INFO,"Datos actualizados correctamente");
            bitacora.controlLog(LOGGER);
            break;
          case "b":
            System.out.println("Cuota actual: " + cuenta.getCuota());
            System.out.print("Nueva cuota: ");
            cuenta.setCuota(new BigDecimal(input.nextLine()));
            LOGGER.log(Level.INFO,"Datos actualizados correctamente");
            bitacora.controlLog(LOGGER);
            break;
          case "c":
            System.out.println("Estado actual: " + cuenta.getEstado());

            if (cuenta.getEstado() == CondicionCuenta.ACTIVO) {
              System.out.println("Cambiar estado a inactivo? si/(cualquier otra entrada para no)");
              answer = input.nextLine().toLowerCase().trim();
              if (answer.equals("si")) {
                cuenta.setEstado(CondicionCuenta.INACTIVO);
                LOGGER.log(Level.INFO,"Datos actualizados correctamente");
                bitacora.controlLog(LOGGER);
              }
            } else {
              System.out.println("Cambiar estado a activo? si/(cualquier otra entrada para no)");
              answer = input.nextLine().toLowerCase().trim();
              if (answer.equals("si")) {
                cuenta.setEstado(CondicionCuenta.ACTIVO);
                LOGGER.log(Level.INFO,"Datos actualizados correctamente");
                bitacora.controlLog(LOGGER);
              }
            }
            break;
          case "x":
            break;
        }
      } catch (Exception e) {
        input.nextLine();
        LOGGER.log(Level.WARNING,"Datos incorrectos");
        bitacora.controlLog(LOGGER);
      }
    }
    return cuenta;
  }
}
