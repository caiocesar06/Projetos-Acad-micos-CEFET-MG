//arquivo CalendarUser.java

import java.rmi.Naming;

import javax.swing.JOptionPane;

public class EchoUser
{
// constructor
public EchoUser() {}

public static void main(String args[])
{
  
  EchoInterface  remoteCal;
  String vai="", volta= "";
  try {
    remoteCal = (EchoInterface) Naming.lookup
    ("rmi:///EchoServer");
  
    do{
    vai = ""+ JOptionPane.showInputDialog("Digite uma mensagem ou exit para sair");
    volta = remoteCal.getEcho(vai);
    JOptionPane.showMessageDialog(null, volta);
    }while(!vai.equalsIgnoreCase("!exit"));
    
  }
  
  catch (Exception e) {
      e.printStackTrace();
    }
  
    System.out.println("Fim!");
    
    
  } // main

} // class CalendarUser

