package com.admincobros;

import com.enums.CondicionCuenta;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Scanner;
import com.Bitacora;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Menu {
    Bitacora bitacora = new Bitacora();
    private final static Logger LOGGER = Logger.getLogger("menu");
    public static HashMap<Integer, Cuenta> listaCuentas = new HashMap<>();
    @Getter @Setter private AdministrarCuentas admin;
    @Getter @Setter private Scanner input;

    public void showMainMenu() {

    agregarDatosTemporales();

    input = new Scanner(System.in);
    admin = new AdministrarCuentas();

    String answer = "";
    System.out.println("Bienvenido");

    while (!answer.equals("x")) {

      System.out.println("\nIngrese numero cuenta a consultar o \"x\"para salir");
      answer = input.nextLine().toLowerCase().trim();

      if (!answer.equals("x")) {
          showAccountOptionsMenu(answer);
      }
    }
  }


  private void showAccountOptionsMenu(String answer){
      try {

          if (listaCuentas.containsKey(Integer.valueOf(answer))) {

              int numeroCuenta = Integer.parseInt(answer);
              String optionAnswer = "";
              while (!optionAnswer.equals("x")) {

                  System.out.println("Ingrese letra de accion a realizar: ");
                  System.out.println("a: Validar Pago");
                  System.out.println("b: Actualizar Cuenta");
                  System.out.println("c: Enviar correo de pago atrasado");
                  System.out.println("d: Mostrar datos de la cuenta");
                  System.out.println("x: volver menu inicial.");
                  optionAnswer = input.nextLine().toLowerCase().trim();

                  switch (optionAnswer) {
                      case "a":
                          Cuenta cuentaValidada = admin.validarPago(listaCuentas.get(numeroCuenta));
                          listaCuentas.replace(cuentaValidada.getNumeroCuenta(), cuentaValidada);
                          System.out.println("Validando pago...\n");
                          break;
                      case "b":
                          Cuenta cuenta = admin.actualizarCuenta(listaCuentas.get(numeroCuenta));
                          listaCuentas.replace(numeroCuenta, cuenta);
                          break;
                      case "c":
                          System.out.println("EnviandoCorreo..\n");
                          admin.emailPagoAtrasado(listaCuentas.get(numeroCuenta).getCorreo());
                          break;
                      case "d":
                          admin.mostrarDatos(listaCuentas.get(numeroCuenta));
                          break;
                      case "x":
                          System.out.println("Saliendo...\n");
                          break;
                      default:
                          System.out.println("opcion no valida.\n");
                  }
              }

          } else {
              int nuevoNumeroCuenta = Integer.valueOf(answer);
              System.out.println("\nCuenta no existe, desea agregar cuenta?");
              System.out.println("Digite si para crear o cualquier otra entrada para no.");
              answer = input.nextLine().toLowerCase().trim();

              switch (answer) {
                  case "si":
                      Cuenta nuevaCuenta = admin.crearCuenta(nuevoNumeroCuenta);
                      listaCuentas.put(nuevaCuenta.getNumeroCuenta(), nuevaCuenta);
                      break;
              }
          }

      } catch (Exception ex) {
          LOGGER.log(Level.SEVERE,"Entrada no valida. ");
          bitacora.controlLog(LOGGER);
      }
  }

    private void agregarDatosTemporales(){
        Cuenta nueva = new Cuenta();
        nueva.setNumeroCuenta(123);
        nueva.setNombre("alex");
        nueva.setDui(987654321);
        nueva.setProducto("silla");
        nueva.setCorreo("2510282020@mail.utec.edu.sv");
        nueva.setMontoInicial(new BigDecimal(1200));
        nueva.setMonto(new BigDecimal(1200));
        nueva.setCuota(new BigDecimal(12));
        nueva.setEstado(CondicionCuenta.ACTIVO);

        listaCuentas.put(nueva.getNumeroCuenta(), nueva);

        Cuenta nueva2 = new Cuenta();
        nueva2.setNumeroCuenta(45);
        nueva2.setNombre("alex");
        nueva2.setDui(123456789);
        nueva2.setProducto("mesa");
        nueva2.setCorreo("2510282020@mail.utec.edu.sv");
        nueva2.setMontoInicial(new BigDecimal(100));
        nueva2.setMonto(new BigDecimal(100));
        nueva2.setCuota(new BigDecimal(12));
        nueva2.setEstado(CondicionCuenta.ACTIVO);

        listaCuentas.put(nueva2.getNumeroCuenta(), nueva2);
    }

}
