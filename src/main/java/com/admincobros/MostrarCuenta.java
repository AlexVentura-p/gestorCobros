package com.admincobros;

import java.util.Scanner;

public class MostrarCuenta {

  Scanner input = new Scanner(System.in);
  public void mostrarDatosCuenta(Cuenta cuenta) {
    System.out.println("\n*******Datos de la cuenta****** ");
    System.out.println("Numero cuente: " + cuenta.getNumeroCuenta());
    System.out.println("Nombre cliente: " + cuenta.getNombre());
    System.out.println("Correo cliente: " + cuenta.getCorreo());
    System.out.println("Dui cliente: " + cuenta.getDui());
    System.out.println("Producto: " + cuenta.getProducto());
    System.out.println("Monto deuda inicial: " + cuenta.getMontoInicial());
    System.out.println("Monto deuda actual: " + cuenta.getMonto());
    System.out.println("Cuota: " + cuenta.getCuota());
    System.out.println("Estado: " + cuenta.getEstado());
    System.out.println("*******Presione enter para volver a menu**********");
    String enter = input.nextLine();
  }
}
