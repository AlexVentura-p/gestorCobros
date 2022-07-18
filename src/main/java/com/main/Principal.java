package com.main;

import com.admincobros.Menu;

import java.util.logging.Logger;
import java.util.logging.Level;

public class Principal {
  static Logger logger = Logger.getLogger(Principal.class.getName());
  public static void main(String[] args) {


    Menu menu = new Menu();
    menu.showMainMenu();
  }
}
