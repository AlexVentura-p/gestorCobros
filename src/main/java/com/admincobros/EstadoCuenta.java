package com.admincobros;

import com.Bitacora;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EstadoCuenta {
  Bitacora bitacora = new Bitacora();
  private final static Logger LOGGER = Logger.getLogger("estadoCuenta");
  Cuenta c = new Cuenta();
  File file = new File("recibo.txt");
  BufferedWriter bf = null;

  public Cuenta estadoCuenta(Cuenta cuenta) {

    try {

      String mensaje =
          "Gracias por su pago"
              + "******************"
              + "\nCuenta: "
              + cuenta.getNumeroCuenta()
              + "\nNombre: "
              + cuenta.getNombre()
              + "\nDui: "
              + cuenta.getDui()
              + "\nProducto: "
              + cuenta.getProducto()
              + "\nCuota: "
              + cuenta.getCuota()
              + "\nMonto: "
              + cuenta.getMonto();
      file.createNewFile();
      bf = new BufferedWriter(new FileWriter(file));
      bf.write(mensaje);
      LOGGER.log(Level.INFO,"El archivo se creo...");
      bitacora.controlLog(LOGGER);
      bf.flush();
    } catch (IOException e) {
      LOGGER.logp(Level.SEVERE,EstadoCuenta.class.getName(),"estadoCuenta","fallo de ejecucion",e);
      bitacora.controlLog(LOGGER);
      throw new RuntimeException(e);

    }
    return c;
  }
}
