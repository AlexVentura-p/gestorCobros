package com.admincobros;

import java.io.*;

public class EstadoCuenta {
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
              + "\nMonto inicial: "
              + cuenta.getMontoInicial()
              + "\nMonto actual: "
              + cuenta.getMonto();
      file.createNewFile();
      bf = new BufferedWriter(new FileWriter(file));
      bf.write(mensaje);
      System.out.println("El archivo se creo...");

      bf.flush();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    return null;
  }
}
