package com.admincobros;

import com.email.AvisoPagoAtrasado;
import com.email.EnvioCorreo;
import com.enums.CondicionCuenta;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
      String monto = input.nextLine();
      nuevaCuenta.setMontoInicial(new BigDecimal(monto));
      nuevaCuenta.setMonto(new BigDecimal(monto));
      System.out.println("Ingrese cuota: ");

      nuevaCuenta.setCuota(new BigDecimal(input.nextLine()));

      nuevaCuenta.setEstado(CondicionCuenta.ACTIVO);

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

  public void mostrarDatos(Cuenta cuenta) {
    MostrarCuenta mostrar = new MostrarCuenta();
    mostrar.mostrarDatosCuenta(cuenta);
  }
}
