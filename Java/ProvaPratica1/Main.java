import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Movel> listaMovelTxt = new ArrayList<Movel>();
        System.out.println("> QUESTAO 1 E 2 \n");
        int numRodas = 2;
        String fabricante = "Yamaha";
        int anoFabricacao = 2008;
        int velocidade = 145;

        Movel moto = new Movel(numRodas, fabricante, anoFabricacao, velocidade);

        System.out.println(moto);

        System.out.println("\n\n> QUESTAO 3 \n");
        lerDadosTxt(listaMovelTxt);
        for(Movel m : listaMovelTxt) {
            System.out.println("-------------------------------");
            System.out.println(m);
            System.out.println("\n");
        }
    }

    public static void lerDadosTxt(ArrayList<Movel> listaMovelTxt) {
        try (BufferedReader br = new BufferedReader(new FileReader("moveis.txt"))) {
            String linha = br.readLine();
            linha = br.readLine();
            while (linha != null) {
                String[] dados = linha.split(";");
                if(dados.length == 4) {
                    Movel m = new Movel(Integer.parseInt(dados[0]), dados[1], Integer.parseInt(dados[2]), Integer.parseInt(dados[3]));
                    listaMovelTxt.add(m);
                } else if(dados.length == 6) {
                    Esportivo e = new Esportivo(Integer.parseInt(dados[0]), dados[1], Integer.parseInt(dados[2]), Integer.parseInt(dados[3]), Integer.parseInt(dados[4]), Integer.parseInt(dados[5]));
                    listaMovelTxt.add(e);
                } else if(dados.length == 8) {
                    Carga c = new Carga(Integer.parseInt(dados[0]), dados[1], Integer.parseInt(dados[2]), Integer.parseInt(dados[3]), Integer.parseInt(dados[6]), Integer.parseInt(dados[7]));
                    listaMovelTxt.add(c);
                }

                linha = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}