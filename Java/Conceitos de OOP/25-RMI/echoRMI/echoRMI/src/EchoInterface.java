import java.rmi.Remote;
import java.rmi.RemoteException;

public interface EchoInterface
       extends Remote
{
	String  getEcho(String mensagem)
		     throws RemoteException ;
}
