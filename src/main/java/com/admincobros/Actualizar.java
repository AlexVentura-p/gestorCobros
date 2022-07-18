package com.admincobros;

import com.enums.CondicionCuenta;
import java.math.BigDecimal;
import java.util.Scanner;

public class Actualizar implements Update {

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
            System.out.println("Correo actualizado...");
            break;
          case "b":
            System.out.println("Cuota actual: " + cuenta.getCuota());
            System.out.print("Nueva cuota: ");
            cuenta.setCuota(new BigDecimal(input.nextLine()));
            System.out.println("Cuota actualizada...");
            break;
          case "c":
            System.out.println("Estado actual: " + cuenta.getEstado());

            if (cuenta.getEstado() == CondicionCuenta.ACTIVO) {
              System.out.println("Cambiar estado a inactivo? si/(cualquier otra entrada para no)");
              answer = input.nextLine().toLowerCase().trim();
              if (answer.equals("si")) {
                cuenta.setEstado(CondicionCuenta.INACTIVO);
                System.out.println("Estado actualizado...");
              }
            } else {
              System.out.println("Cambiar estado a activo? si/(cualquier otra entrada para no)");
              answer = input.nextLine().toLowerCase().trim();
              if (answer.equals("si")) {
                cuenta.setEstado(CondicionCuenta.ACTIVO);
                System.out.println("Estado actualizado...");
              }
            }
            break;
          case "x":
            break;
        }
      } catch (Exception e) {
        input.nextLine();
        System.out.println("Entrada incorrecta.\n");
      }
    }
    return cuenta;
  }
}
