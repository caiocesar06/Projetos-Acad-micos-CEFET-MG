package echoRMI.Server;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import echoRMI.Cliente.Pessoal;

public class EchoServer extends UnicastRemoteObject implements EchoInterface {

	private static ArrayList<Pessoal> pessoal = initArrayList();

	public EchoServer() throws RemoteException { }

	@Override
	public String getEcho(String mensagem) throws RemoteException {
		String retorno = "";
		
		if(mensagem.equalsIgnoreCase("Exit")) return "Você está saindo...";

		if(!mensagem.equals("")) {
				for (Pessoal p : pessoal) {
					try {
						if(p.getMatricula() == Integer.parseInt(mensagem)) {
							retorno = p.getNome() + "";
							break;				
						} else {
							retorno = "Número de matrícula não cadastrado";
						}
					} catch (NumberFormatException e) {
						retorno = "Por favor, digite um número";
					}
				}
		} else {
			retorno = "Digite algo por favor";
		}
		System.out.println("Chegou no servidor: " + retorno);
		return retorno;
	}

	public static void main(String args[]) {
		EchoServer cal;
		try {
			cal = new EchoServer();
			LocateRegistry.createRegistry(1099);
			Naming.bind("rmi:///EchoServer", cal);
			System.out.println("Server Ready!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static ArrayList<Pessoal> initArrayList() {
		ArrayList<Pessoal> lista = new ArrayList<Pessoal>();
		try (BufferedReader br = new BufferedReader(new FileReader("echoRMI/Server/tabela.csv"))) {
		  String linha = br.readLine();
		  linha = br.readLine();
		  while (linha != null) {
			String[] dados = linha.split(";");
			
			switch(dados.length) {
				case 7:
					lista.add(new Pessoal(dados[0], Integer.parseInt(dados[1]), dados[2], dados[3], dados[4], "", dados[6]));
					break;
				case 6:
					lista.add(new Pessoal(dados[0], Integer.parseInt(dados[1]), dados[2], dados[3], dados[4], dados[5], ""));
					break;
				case 5:
					lista.add(new Pessoal(dados[0], Integer.parseInt(dados[1]), dados[2], dados[3], dados[4], "", ""));
					break;
				default:
					break;
			}

			linha = br.readLine();
		  }
		} catch (IOException e) {
		  System.err.println("Erro ao ler o arquivo: ");
		  e.printStackTrace();
		}
		return lista;
	  }
}
