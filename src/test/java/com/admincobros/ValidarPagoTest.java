package com.admincobros;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.jupiter.api.Test;

class ValidarPagoTest {
  @Test
  void totalShouldIncrease10Percent() {
    var test1 = new ValidarPago();
    Cuenta cuenta = new Cuenta();
    cuenta.setMonto(new BigDecimal("1500"));
    ByteArrayInputStream in = new ByteArrayInputStream("no".getBytes());
    System.setIn(in);
    assertEquals("1650.00", test1.validarPago(cuenta).getMonto().toString());
    System.setIn(System.in);
  }

  @Test
  void totalShouldDecrease100() {
    var test1 = new ValidarPago();
    Cuenta cuenta = new Cuenta();
    cuenta.setMonto(new BigDecimal("1500.00"));
    cuenta.setMontoInicial(new BigDecimal("1500"));
    cuenta.setCuota(new BigDecimal("100.00"));
    System.out.println("Monto actual: " + cuenta.getMonto());
    System.out.println("Cuota: " + cuenta.getCuota());
    ByteArrayInputStream in = new ByteArrayInputStream("si".getBytes());
    System.setIn(in);
    assertEquals("1400.00", test1.validarPago(cuenta).getMonto().toString());
    System.out.println("Nuevo monto: " + cuenta.getMonto());
    System.setIn(System.in);
  }
}
