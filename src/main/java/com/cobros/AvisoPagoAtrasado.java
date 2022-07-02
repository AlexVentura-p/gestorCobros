package com.cobros;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import lombok.Getter;
import lombok.Setter;

public class AvisoPagoAtrasado implements EnvioCorreo {
  @Getter @Setter private String correoEmpresa = "trabajouml2021@gmail.com";
  @Getter @Setter private String passwordCorreoEmpresa = "jtvvbnzseosalorh";
  @Getter @Setter private String host = "smtp.gmail.com";
  @Getter @Setter private String puerto = "587";
  @Getter @Setter String text = "";

  public void enviarCorreo(String destinatario) {

    Properties propiedades = new Properties();

    propiedades.put("mail.smtp.auth", "true");
    propiedades.put("mail.smtp.starttls.enable", "true");
    propiedades.put("mail.smtp.host", host);
    propiedades.put("mail.smtp.port", puerto);

    Session session =
        Session.getInstance(
            propiedades,
            new javax.mail.Authenticator() {
              @Override
              protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(correoEmpresa, passwordCorreoEmpresa);
              }
            });

    Message mensaje = prepararMensaje(session, correoEmpresa, destinatario);

    try {
      Transport.send(mensaje);
      System.out.println("Enviado.\n");
    } catch (MessagingException e) {
      System.out.println("Error." + e.getMessage() + " Mensaje no enviado.");
    }
  }

  private Message prepararMensaje(Session session, String correoEmisor, String destinatario) {

    try {
      Message mensaje = new MimeMessage(session);
      mensaje.setFrom(new InternetAddress(correoEmisor));
      mensaje.setRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
      mensaje.setSubject("Recordatorio de pago");

      if (text.equals("")) {
        text =
            """
              Estimado.
              Le informamos que el pago del correspondiente mes cuenta con retraso.
              Pedimos de la manera más cordial posible realizarlo antes que sus servicios sean
              indefinidamente descontinuados.
              """;
      }

      mensaje.setText(text);
      return mensaje;
    } catch (Exception e) {
      Logger.getLogger(AvisoPagoAtrasado.class.getName()).log(Level.SEVERE, null, e);
    }
    return null;
  }
}
