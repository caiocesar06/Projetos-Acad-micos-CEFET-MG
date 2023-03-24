import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

public class EchoServer extends UnicastRemoteObject implements EchoInterface {

	public EchoServer() throws RemoteException {
	}

	@Override
	public String getEcho(String mensagem) throws RemoteException {
		// String retorno = !mensagem.equals("") ? 
		// 	"Você enviou:  " + mensagem : "Digite algo por favor!";
		// System.out.println(retorno);
		System.out.println(mensagem);
		return new Scanner(System.in).nextLine();
	}

	public static void main(String args[]) {
		EchoServer cal;
		try {
			cal = new EchoServer();
			LocateRegistry.createRegistry(1099);
			Naming.bind("rmi:///EchoServer", cal);
			System.out.println("Ready !");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
