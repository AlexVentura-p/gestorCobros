package com.admincobros;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

class ValidarPagoTest {
    @Test
    void totalShouldIncrease10Percent(){
        var test1 = new ValidarPago();
        Cuenta cuenta = new Cuenta();

        cuenta.setMonto(1500);
        ByteArrayInputStream in = new ByteArrayInputStream("no".getBytes());
        System.setIn(in);
        assertEquals(1650,test1.validarPago(cuenta).getMonto());
        System.setIn(System.in);

    }
}