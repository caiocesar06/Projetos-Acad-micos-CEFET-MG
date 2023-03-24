import java.io.*;
import java.util.*;

public class PesquisaArquivo {
    public static void main(String[] args) {
        ArrayList<Integer> listaLinhas = new ArrayList<Integer>();
        Scanner ler = new Scanner(System.in);

        String nomeArgs = "";
        for(int i = 0; i < args.length - 1; i++) {
            nomeArgs += (args[i] + " ");
        }
        nomeArgs += args[args.length - 1];  

        System.out.println("Digite a palavra a ser procurada:");
        String palavra = ler.next();

        try (BufferedReader br = new BufferedReader(new FileReader(nomeArgs))) {
            int cont = 1;
            String linha = br.readLine();
            while(linha != null) {
                String[] dados = linha.split("[, ]");
                for(int i = 0; i < dados.length; i++)
                    if(palavra.toLowerCase().equals(dados[i].toLowerCase())){
                        listaLinhas.add(cont);
                    }
                cont++;
                linha = br.readLine();
            }
        } catch (IOException e) {
            System.err.println("Erro: Arquivo não encontrado!" + e.getMessage());
        }
        System.out.print("A palavra \"" + palavra + "\" aparece na(s) linha(s) ");
        for(int i = 0; i < listaLinhas.size() - 1; i++) {
            if(listaLinhas.get(i) == 1) {
                System.out.print(listaLinhas.get(i) + " (titulo), ");
            } else if(listaLinhas.get(i) == 2) {
                System.out.print(listaLinhas.get(i) + " (banda), ");
            } else {
                System.out.print(listaLinhas.get(i) + ", ");
            }
        }
        
        if(listaLinhas.get(listaLinhas.size() - 1) == 1) {
            System.out.print(listaLinhas.get(listaLinhas.size() - 1) + " (titulo).");
        } else if(listaLinhas.get(listaLinhas.size() - 1) == 2) {
            System.out.print(listaLinhas.get(listaLinhas.size() - 1) + " (banda).");
        } else {
            System.out.println(listaLinhas.get(listaLinhas.size() - 1) + ".");
        }

        ler.close();
    }
}