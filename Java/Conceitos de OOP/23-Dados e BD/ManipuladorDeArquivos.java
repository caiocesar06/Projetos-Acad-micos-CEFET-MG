import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManipuladorDeArquivos {
    static List<String> buscaLinhasEmArquivo(String caminho) throws FileNotFoundException {
        Scanner leitor = new Scanner(new File(caminho));
        List<String> lista = new ArrayList<String>();

        while (leitor.hasNextLine()) {
            lista.add(leitor.nextLine());
        }
        return lista;
    }

    static void gravaLinhasEmArquivo(String caminho, List<String> lista) throws IOException {

        FileWriter fileWriter = new FileWriter(caminho);
        PrintWriter printWriter = new PrintWriter(fileWriter);

        for (String linha : lista) {
            printWriter.print(linha + System.lineSeparator());
        }

        printWriter.close();
    }




}
