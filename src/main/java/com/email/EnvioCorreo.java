package com.email;

public interface EnvioCorreo {

  String correoEmpresa = "trabajouml2021@gmail.com";
  String passwordCorreoEmpresa = "jtvvbnzseosalorh";
  String host = "smtp.gmail.com";
  String puerto = "587";

  void enviarCorreo(String destinatario);
}
