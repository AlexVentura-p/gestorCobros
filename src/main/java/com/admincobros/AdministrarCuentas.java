package com.admincobros;

import com.Bitacora;
import com.email.AvisoPagoAtrasado;
import com.email.EnvioCorreo;

import java.security.PrivateKey;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdministrarCuentas implements CreacionCuenta, Update {
  private final static Logger LOGGER = Logger.getLogger("administrarCuentas");
  Bitacora bitacora = new Bitacora();
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
        input.nextLine();
        System.out.println("Digite el estado de la cuenta: ");
        nuevaCuenta.setEstado(input.nextLine());

        cuenta = nuevaCuenta;
        LOGGER.log(Level.INFO,"Cuenta creada.");
        bitacora.controlLog(LOGGER);
        return cuenta;

      } catch (Exception ex) {
        LOGGER.log(Level.SEVERE,"Error. Dato no ingresado. Ingrese datos validos. " + ex.getMessage());
        bitacora.controlLog(LOGGER);
        return null;
      }
    }
    return null;
  }

  public void emailPagoAtrasado(String correo) {
    EnvioCorreo nuevoCorreo = new AvisoPagoAtrasado();
    nuevoCorreo.enviarCorreo(correo);
  }

  @Override
  public Cuenta actualizarCuenta(Cuenta oldCuenta) {
    Actualizar actualizar = new Actualizar();
    Cuenta cuentaActualizada = actualizar.actualizarCuenta(oldCuenta);
    return cuentaActualizada;
  }

  public Cuenta validarPago(Cuenta cuenta) {
    ValidarPago validacion = new ValidarPago();
    Cuenta cuentaValidada = validacion.validarPago(cuenta);

    return cuentaValidada;
  }

}
