package com.cobros;

import lombok.Getter;
import lombok.Setter;

public class Cuenta {

  @Setter @Getter private int numeroCuenta;
  @Setter @Getter private String nombre;
  @Setter @Getter private int dui;
  @Setter @Getter private String producto;
  @Setter @Getter private double monto;
  @Setter @Getter private double cuota;
  @Setter @Getter private String estado;
  @Setter @Getter private String correo;

  public Cuenta() {}

  public Cuenta(
      int numeroCuenta,
      String nombre,
      int dui,
      String producto,
      double monto,
      double cuota,
      String estado,
      String correo) {
    this.numeroCuenta = numeroCuenta;
    this.nombre = nombre;
    this.dui = dui;
    this.producto = producto;
    this.monto = monto;
    this.cuota = cuota;
    this.estado = estado;
    this.correo = correo;
  }

}
