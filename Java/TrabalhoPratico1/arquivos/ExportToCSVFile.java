package arquivos;
import java.io.*;
import java.util.*;

public class ExportToCSVFile { // Classe que exporta o vetor ordenado para um arquivo CSV

    public void ExportarCSV(Vector<String> vetorDeStrings, long duration, String filename ) {
        File csv = new File(filename); // Cria o arquivo CSV
        try {
            PrintWriter writer = new PrintWriter(csv);
            writer.println("Nomes ordenados"); // Cabeçalho do arquivo
            
            // Percorre o vetor e escreve os dados no arquivo
            for (int i = 0; i < vetorDeStrings.size(); i++) {
                writer.println(vetorDeStrings.get(i));
            }
            writer.println();

            // Escreve o tempo de execução no arquivo
            writer.println("Tempo de execução: " + duration + " milissegundos");
            
            writer.close();
        } catch (Exception e) { // Se der erro, exibe a mensagem
            System.out.println("Erro: " + e.getMessage());
        }
    }
}