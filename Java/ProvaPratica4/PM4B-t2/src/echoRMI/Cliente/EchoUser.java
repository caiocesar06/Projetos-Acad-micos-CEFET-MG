package echoRMI.Cliente;
//arquivo CalendarUser.java

import java.rmi.Naming;

import javax.swing.JOptionPane;

import echoRMI.Server.EchoInterface;

public class EchoUser {

  // constructor
  public EchoUser() {}

  public static void main(String args[]) {

    echoRMI.Server.EchoInterface remoteCal;
    String vai = "", volta = "";
    try {
      remoteCal = (EchoInterface) Naming.lookup("rmi:///EchoServer");
      do {
        vai = "" + JOptionPane.showInputDialog("Digite a matricula ou exit para sair");
        volta = remoteCal.getEcho(vai);
        JOptionPane.showMessageDialog(null, volta);
      } while (!vai.equalsIgnoreCase("Exit"));
    }

    catch (Exception e) {
      e.printStackTrace();
    }

    System.out.println("Fim!");

  } // main

} // class CalendarUser
