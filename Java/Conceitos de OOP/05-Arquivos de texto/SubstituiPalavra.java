import java.util.*;
import java.io.*;

public class SubstituiPalavra {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        String nomeArgs = "";
        for (int i = 0; i < args.length - 1; i++) {
            nomeArgs += (args[i] + " ");
        }
        nomeArgs += args[args.length - 1];

        File arquivoOriginal = new File(nomeArgs);
        File arquivoTemp = new File("temp.txt");

        System.out.println("Digite a palavra que queira trocar:");
        String palavraProc = ler.nextLine();

        System.out.println("\nDigite a palavra para substituir:");
        String palavraSubs = ler.nextLine();

        try (PrintWriter pw = new PrintWriter(arquivoTemp);
             BufferedReader br = new BufferedReader(new FileReader(arquivoOriginal))) {
            String linha = br.readLine();
            while (linha != null) {
                String[] dados = linha.split("[, ]");
                for (int j = 0; j < dados.length; j++) {
                    if (!dados[j].equals("")) {
                        for (int i = 0; i < dados.length; i++) {
                            if (palavraProc.toLowerCase().equals(dados[i].toLowerCase())) {
                                if (i == 0) {
                                    if (dados.length == 1) {
                                        dados[i] = palavraSubs.toUpperCase();
                                    } else {
                                        dados[i] = palavraSubs.substring(0, 1).toUpperCase()
                                                + palavraSubs.substring(1).toLowerCase();
                                    }
                                } else {
                                    dados[i] = palavraSubs;
                                }
                            }
                        }
                    } else {
                        dados[j] = ",";
                    }
                }
                String linhaNova = "";
                for (int i = 0; i < dados.length - 1; i++) {
                    if (dados[i + 1].equals(",")) {
                        linhaNova += dados[i] + ", ";
                    } else if (!dados[i].equals(",")) {
                        linhaNova += dados[i] + " ";
                    }
                }
                linhaNova += dados[dados.length - 1];
                pw.println(linhaNova);

                linha = br.readLine();
            }
            System.out.println("\nArquivo alterado com sucesso!");
        } catch (IOException e) {
            System.err.println("\nErro: Arquivo não encontrado!" + e.getMessage());
        } finally {
            arquivoOriginal.delete();
            arquivoTemp.renameTo(arquivoOriginal);
            ler.close();
        }
    }
}