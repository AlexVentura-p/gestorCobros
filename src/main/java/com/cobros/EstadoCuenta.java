package com.cobros;

import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.util.Map;

public class EstadoCuenta extends Principal {
    Cuenta c = new Cuenta();
    File file = new File("recibo.txt");
    BufferedWriter bf = null;

    public Cuenta estadoCuenta(int numeroCuenta) {

        try {

            Cuenta cuenta = listaCuentas.get(numeroCuenta);
            String mensaje = "Gracias por su pago" + "******************" + "\nCuenta: "
                    + cuenta.getNumeroCuenta() + "\nNombre: " + cuenta.getNombre() + "\nDui: " + cuenta.getDui() + "\nProducto: "
                    + cuenta.getProducto() + "\nCuota: " + cuenta.getCuota() + "\nMonto: " + cuenta.getMonto();
            file.createNewFile();
            bf = new BufferedWriter(new FileWriter(file));
            bf.write(mensaje);
            System.out.println("El archivo se creo...");

            bf.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return c;
    }


}
