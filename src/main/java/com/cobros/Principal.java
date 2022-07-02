package com.cobros;

import java.util.HashMap;
import java.util.Scanner;

public class Principal {
  static HashMap<Integer, Cuenta> listaCuentas = new HashMap<>();


  public static void main(String[] args) {

    Scanner input = new Scanner(System.in);
    AdministrarCuentas admin = new AdministrarCuentas();
    String answer = "";

    System.out.println("Bienvenido");

    while (!answer.equals("x")) {

      System.out.println("\nIngrese numero cuenta a consultar o \"x\"para salir");
      answer = input.nextLine().toLowerCase().trim();

      if (!answer.equals("x")) {

        try {

          if (listaCuentas.containsKey(Integer.valueOf(answer))) {
            int numeroCuenta = Integer.parseInt(answer);
            String optionAnswer = "";
            while (!optionAnswer.equals("x")) {

              System.out.println("Ingrese letra de accion a realizar: ");
              System.out.println("a: Validar Pago");
              System.out.println("b: Actualizar Cuenta");
              System.out.println("c: Enviar correo de pago atrasado");
              System.out.println("x: volver menu inicial.");
              optionAnswer = input.nextLine().toLowerCase().trim();

              switch (optionAnswer) {
                case "a":
                  System.out.println("Validando pago...\n");
                  break;
                case "b":
                  System.out.println("Actualizando datos...\n");
                  break;
                case "c":
                  System.out.println("EnviandoCorreo..\n");
                  admin.emailPagoAtrasado(listaCuentas.get(numeroCuenta).getCorreo());
                  break;
                case "x":
                  System.out.println("Saliendo...\n");
                  break;
                default:
                  System.out.println("opcion no valida.\n");
              }
            }

          } else {
            System.out.println("\nCuenta no existe, desea agregar cuenta?");
            System.out.println("Digite si para crear o cualquier otra entrada para no.");
            answer = input.nextLine().toLowerCase().trim();

            switch (answer) {
              case "si":
                Cuenta nuevaCuenta = admin.CrearCuenta();
                listaCuentas.put(nuevaCuenta.getNumeroCuenta(), nuevaCuenta);
                break;
            }
          }

        } catch (Exception ex) {
          System.out.println("\nEntrada no valida. ");
        }
      }
    }
  }
}
