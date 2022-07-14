package com.admincobros;

import com.email.AvisoPagoAtrasado;
import com.email.EnvioCorreo;

import java.util.Scanner;

public class AdministrarCuentas {


  public Cuenta crearCuenta() {
    Scanner input = new Scanner(System.in);

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
        input.nextLine();
        System.out.println("Digite el estado de la cuenta: ");
        nuevaCuenta.setEstado(input.nextLine());

        System.out.println("Cuenta creada.");

        return nuevaCuenta;

      } catch (Exception ex) {
        System.out.println("Error. Dato no ingresado. Ingrese datos validos. " + ex.getMessage());
        return null;
      }
  }

  public void emailPagoAtrasado(String correo) {
    EnvioCorreo nuevoCorreo = new AvisoPagoAtrasado();
    nuevoCorreo.enviarCorreo(correo);
  }


  public Cuenta actualizarCuenta(Cuenta oldCuenta) {
    Update actualizar = new Actualizar();
    return actualizar.actualizarCuenta(oldCuenta);
  }

  public Cuenta validarPago(Cuenta cuenta) {
    ValidarPago validacion = new ValidarPago();
    return validacion.validarPago(cuenta);
  }

}
