package com.admincobros;

import com.Bitacora;
import com.email.AvisoPagoAtrasado;
import com.email.EnvioCorreo;
import com.enums.CondicionCuenta;
import java.math.BigDecimal;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdministrarCuentas {
    private final static Logger LOGGER = Logger.getLogger("administrarCuentas");
    Bitacora bitacora = new Bitacora();

    public Cuenta crearCuenta(int nuevoNumeroCuenta) {
    Scanner input = new Scanner(System.in);

    try {
      Cuenta nuevaCuenta = new Cuenta();
      System.out.println("Nueva cuenta a crear: numero " + nuevoNumeroCuenta);
      nuevaCuenta.setNumeroCuenta(nuevoNumeroCuenta);
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

        LOGGER.log(Level.INFO,"Cuenta creada.");
        bitacora.controlLog(LOGGER);
        return nuevaCuenta;

    } catch (Exception ex) {
        LOGGER.log(Level.SEVERE,"Error. Dato no ingresado. Ingrese datos validos. " + ex.getMessage());
        bitacora.controlLog(LOGGER);
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
