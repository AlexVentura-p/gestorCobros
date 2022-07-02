package com.cobros;


import java.util.Scanner;

public class AdministrarCuentas implements CreacionCuenta {

  @Override
  public Cuenta CrearCuenta() {
    Scanner input = new Scanner(System.in);
    Cuenta cuenta = null;

    while (cuenta == null) {

      try {
        Cuenta nuevaCuenta = new Cuenta();
        System.out.println("Ingrese numero cuenta: ");
        nuevaCuenta.setNumeroCuenta(input.nextInt());
        input.nextLine();
        System.out.println("Ingrese nombre cliente: ");
        nuevaCuenta.setNombre(input.nextLine());
        System.out.println("Ingrese DUI sin guiones: ");
        nuevaCuenta.setDui(input.nextInt());
        input.nextLine();
        System.out.println("Ingrese correo de cliente");
        nuevaCuenta.setCorreo(input.nextLine());
        System.out.println("Ingrese nombre producto: ");
        nuevaCuenta.setProducto(input.nextLine());
        System.out.println("Ingrese Monto producto: ");
        nuevaCuenta.setMonto(input.nextDouble());
        System.out.println("Ingrese cuota: ");
        nuevaCuenta.setCuota(input.nextDouble());
        nuevaCuenta.setEstado("Pendiente.");

        cuenta = nuevaCuenta;
        System.out.println("Cuenta creada.");

        return cuenta;

      } catch (Exception ex) {
        System.out.println("Error. Dato no ingresado. Ingrese datos validos. " + ex.getMessage());
        return null;
      }
    }
    return null;
  }

  public void emailPagoAtrasado(String correo) {
    EnvioCorreo nuevoCorreo = new AvisoPagoAtrasado();
    nuevoCorreo.enviarCorreo(correo);
  }
}
