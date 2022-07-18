package com.admincobros;

public class MostrarCuenta {
  public void mostrarDatosCuenta(Cuenta cuenta) {
    System.out.println("\n*******Datos de la cuenta****** ");
    System.out.println("Numero cuente: " + cuenta.getNumeroCuenta());
    System.out.println("Nombre cliente: " + cuenta.getNombre());
    System.out.println("Correo cliente: " + cuenta.getCorreo());
    System.out.println("Dui clienta: " + cuenta.getDui());
    System.out.println("Producto: " + cuenta.getProducto());
    System.out.println("Monto inicial: " + cuenta.getMontoInicial());
    System.out.println("Monto actual: " + cuenta.getMonto());
    System.out.println("Cuota: " + cuenta.getCuota());
    System.out.println("Estado: " + cuenta.getEstado());
    System.out.println("************************************\n");
  }
}
