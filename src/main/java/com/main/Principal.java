package com.main;

import com.Bitacora;
import com.admincobros.Menu;
import java.util.logging.Logger;
import java.util.logging.Level;

public class Principal {
  static Logger logger = Logger.getLogger(Principal.class.getName());
  public static void main(String[] args) {

    //Bitacora bitacora = new Bitacora();
    Menu menu = new Menu();
    //bitacora.controlLog();
    menu.showMainMenu();
  }
}
