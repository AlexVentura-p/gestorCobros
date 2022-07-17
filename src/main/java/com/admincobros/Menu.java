package com.admincobros;

import com.Bitacora;

import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Menu {
    Bitacora bitacora = new Bitacora();
    private final static Logger LOGGER = Logger.getLogger("menu");
    public static HashMap<Integer, Cuenta> listaCuentas = new HashMap<>();
    public void showMenu(){

        Cuenta nueva = new Cuenta();
        nueva.setNumeroCuenta(123);
        nueva.setNombre("alex");
        nueva.setProducto("silla");
        nueva.setCorreo("2510282020@mail.utec.edu.sv");
        nueva.setMonto(1200);
        nueva.setCuota(12);
        nueva.setEstado("activo");

        listaCuentas.put(nueva.getNumeroCuenta(), nueva);

        Cuenta nueva2 = new Cuenta();
        nueva2.setNumeroCuenta(45);
        nueva2.setNombre("alex");
        nueva2.setProducto("mesa");
        nueva2.setCorreo("2510282020@mail.utec.edu.sv");
        nueva2.setMonto(100);
        nueva2.setCuota(12);
        nueva2.setEstado("activo");

        listaCuentas.put(nueva2.getNumeroCuenta(), nueva2);

        Scanner input = new Scanner(System.in);
        AdministrarCuentas admin = new AdministrarCuentas();
        String answer = "";
        System.out.println("Bienvenido");

        while (!answer.equals("x")) {

            System.out.println("\nIngrese numero cuenta a consultar o \"x\"para salir");
            answer = input.nextLine().toLowerCase().trim();

            if (!answer.equals("x")) {

                try {

                    if (listaCuentas.containsKey(Integer.valueOf(answer))) {
                        int numeroCuenta = Integer.parseInt(answer);
                        String optionAnswer = "";
                        while (!optionAnswer.equals("x")) {

                            System.out.println("Ingrese letra de accion a realizar: ");
                            System.out.println("a: Validar Pago");
                            System.out.println("b: Actualizar Cuenta");
                            System.out.println("c: Enviar correo de pago atrasado");
                            System.out.println("x: volver menu inicial.");
                            optionAnswer = input.nextLine().toLowerCase().trim();

                            switch (optionAnswer) {
                                case "a":
                                    Cuenta cuentaValidada = admin.validarPago(listaCuentas.get(numeroCuenta));
                                    listaCuentas.replace(cuentaValidada.getNumeroCuenta(), cuentaValidada);
                                    System.out.println("Validando pago...\n");
                                    break;
                                case "b":
                                    System.out.println("Actualizando datos...\n");
                                    Cuenta cuenta = admin.actualizarCuenta(listaCuentas.get(numeroCuenta));
                                    listaCuentas.replace(numeroCuenta, cuenta);
                                    break;
                                case "c":
                                    System.out.println("EnviandoCorreo..\n");
                                    admin.emailPagoAtrasado(listaCuentas.get(numeroCuenta).getCorreo());
                                    break;
                                case "x":
                                    System.out.println("Saliendo...\n");
                                    break;
                                default:
                                    System.out.println("opcion no valida.\n");
                            }
                        }

                    } else {
                        System.out.println("\nCuenta no existe, desea agregar cuenta?");
                        System.out.println("Digite si para crear o cualquier otra entrada para no.");
                        answer = input.nextLine().toLowerCase().trim();

                        switch (answer) {
                            case "si":
                                Cuenta nuevaCuenta = admin.CrearCuenta();
                                listaCuentas.put(nuevaCuenta.getNumeroCuenta(), nuevaCuenta);
                                break;
                        }
                    }

                } catch (Exception ex) {
                    LOGGER.log(Level.SEVERE,"Entrada no valida. ");
                    bitacora.controlLog(LOGGER);
                }
            }
        }

    }

}
