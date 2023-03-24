import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileManager {
    public ArrayList<Funcionario> listaFuncionarios;

    public FileManager() {
        listaFuncionarios = readCsv();
    }

    public ArrayList<Funcionario> readCsv() {
        ArrayList<Funcionario> list = new ArrayList<Funcionario>();
        try (BufferedReader br = new BufferedReader(new FileReader("./src/tabela.csv"))) {
            String linha = br.readLine();
            linha = br.readLine();
            while(linha != null) {
                String[] dados = linha.split(";");
                if(dados.length == 6) {
                    list.add(new FuncionarioTurma(dados[0], Integer.parseInt(dados[1]), dados[2], dados[3], dados[4], dados[5]));
                } else if(dados.length == 7) {
                    list.add(new FuncionarioSetor(dados[0], Integer.parseInt(dados[1]), dados[2], dados[3], dados[4], dados[6]));
                } else {
                    list.add(new Funcionario(dados[0], Integer.parseInt(dados[1]), dados[2], dados[3], dados[4]));
                }
                linha = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
