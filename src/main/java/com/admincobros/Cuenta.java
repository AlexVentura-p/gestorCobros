package com.admincobros;

import com.enums.CondicionCuenta;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Cuenta {

  @Setter @Getter private int numeroCuenta;
  @Setter @Getter private String nombre;
  @Setter @Getter private int dui;
  @Setter @Getter private String producto;
  @Getter private BigDecimal monto;
  @Getter private BigDecimal cuota;
  @Setter @Getter private CondicionCuenta estado;
  @Setter @Getter private String correo;
  @Getter private BigDecimal montoInicial;

  public void setMonto(BigDecimal monto) {
    this.monto = monto.setScale(2, RoundingMode.HALF_EVEN);
  }

  public void setMontoInicial(BigDecimal montoInicial){
    this.montoInicial = montoInicial.setScale(2, RoundingMode.HALF_EVEN);
  }

  public void setCuota(BigDecimal cuota){
    this.cuota = cuota.setScale(2,RoundingMode.HALF_EVEN);
  }

  public Cuenta() {}

  public Cuenta(
      int numeroCuenta,
      String nombre,
      int dui,
      String producto,
      String montoInicial,
      String cuota,
      String correo) {
    this.numeroCuenta = numeroCuenta;
    this.nombre = nombre;
    this.dui = dui;
    this.producto = producto;
    this.setMonto(new BigDecimal(montoInicial));
    this.setMontoInicial(new BigDecimal(montoInicial));
    this.setCuota(new BigDecimal(cuota));
    this.correo = correo;
    this.estado = CondicionCuenta.ACTIVO;
  }
}
