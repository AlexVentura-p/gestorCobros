package com;



import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.*;
import com.email.AvisoPagoAtrasado;
import com.admincobros.Actualizar;

public class Bitacora {
    private final static Logger LOG_RAIZ = Logger.getLogger("bitacora");
    private final static Logger LOG_EMAIL = Logger.getLogger("envioCorreo");
    private final static Logger LOG_UPDATE = Logger.getLogger("Actualizar");
    private final static Logger LOG_ADMIN = Logger.getLogger("administrarCuentas");
    private final static Logger LOG_VAL = Logger.getLogger("validarPago");
    private final static Logger LOG_STATUS = Logger.getLogger("estadoCuenta");
    private final static Logger LOG_MENU = Logger.getLogger("menu");



    private final static Logger LOGGER = Logger.getLogger("bitacora.Bitacora");
    public void controlLog(Logger LOGGER) {


        try {
            Handler consoleHandler = new ConsoleHandler();
            Handler fileHandler = new FileHandler("./bitacora.log", true);
            LOGGER.log(Level.INFO, "Bitacora inicializada");

            SimpleFormatter simpleFormatter = new SimpleFormatter();
            fileHandler.setFormatter(simpleFormatter);
            LOG_RAIZ.addHandler(consoleHandler);
            LOG_RAIZ.addHandler(fileHandler);
            LOG_EMAIL.addHandler(fileHandler);
            LOG_UPDATE.addHandler(fileHandler);
            LOG_ADMIN.addHandler(fileHandler);
            LOG_VAL.addHandler(fileHandler);
            LOG_STATUS.addHandler(fileHandler);
            LOG_MENU.addHandler(fileHandler);
            consoleHandler.setLevel(Level.ALL);
            fileHandler.setLevel(Level.ALL);

        }
        catch (Exception e)
        {
            LOGGER.log(Level.SEVERE,Bitacora.getStackTrace(e));
        }

    }

    private static String getStackTrace(Exception e) {
        StringWriter sWriter = new StringWriter();
        PrintWriter pWriter = new PrintWriter(sWriter);
        e.printStackTrace();
        return sWriter.toString();
    }
}
