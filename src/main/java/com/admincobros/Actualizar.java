package com.admincobros;

import com.Bitacora;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Actualizar implements Update {
  Bitacora bitacora = new Bitacora();
  private final static Logger LOGGER = Logger.getLogger("Actualizar");
  public Cuenta actualizarCuenta(Cuenta cuenta) {
    Scanner input = new Scanner(System.in);
    try {
      System.out.println("Ingrese el nuevo correo de cliente");
      cuenta.setCorreo(input.nextLine());
      System.out.println("Ingrese el nuevo nombre de producto: ");
      cuenta.setProducto(input.nextLine());
      System.out.println("Ingrese el nuevo Monto producto: ");
      cuenta.setMonto(input.nextDouble());
      System.out.println("Ingrese la nueva cuota: ");
      cuenta.setCuota(input.nextDouble());
      input.nextLine();
      System.out.println("Ingrese el nuevo estado de la cuenta: ");
      cuenta.setEstado(input.nextLine());
      LOGGER.log(Level.INFO,"Datos actualizados correctamente");
      bitacora.controlLog(LOGGER);
  }
  catch (Exception e)
  {
    LOGGER.log(Level.WARNING,"Datos incorrectos");
    bitacora.controlLog(LOGGER);
  }

    return cuenta;
  }
}
