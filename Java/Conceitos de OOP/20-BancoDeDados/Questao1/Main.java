import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    String entrada = "tabela.csv";
    String saida = "lista.csv";

    String cabecalho;

    List<Pessoal> ListaPessoal = new ArrayList<Pessoal>();

    public Main() {
        try {
            //Carrega do arquivo de entrada
            List<String> listaEntrada = ManipuladorDeArquivos.buscaLinhasEmArquivo(entrada);
            cabecalho = listaEntrada.remove(0); // remove cabeçalho            
            carregaPessoal(listaEntrada);

           //Salva no arquivo de saida
            List<String> listaSaida = converteListaPessoas2String();
            listaSaida.add(0, cabecalho);
            ManipuladorDeArquivos.gravaLinhasEmArquivo(saida, listaSaida);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<String> converteListaPessoas2String() {
        List<String> lista = new ArrayList<String>();

        for (Pessoal pessoa : ListaPessoal) {
            lista.add(pessoa.toString());
        }

        return lista;
    }

    private void carregaPessoal(List<String> lista) {
        Pessoal pessoa;

        String cargo;
        int matricula;
        String nome, email, senha;
        String turma = "", setor = "";

        for (String linha : lista) {

            String palavras[] = linha.split(";", -1);
            if (palavras.length < 5) {
                System.err.println("Linha mal formada: " + linha);
                continue;
            }
            cargo = palavras[0];
            matricula = Integer.parseInt(palavras[1]);
            nome = palavras[2];
            email = palavras[3];
            senha = palavras[4];

            if (palavras[5].length() != 0) { // Aluno
                turma = palavras[5];
                pessoa = new Aluno(cargo, matricula, nome, email, senha, turma);
            } else if (palavras[6].length() != 0) { // Administrativo
                setor = palavras[6];
                pessoa = new Administrativo(cargo, matricula, nome, email, senha, setor);
            } else { // Professor
                pessoa = new Professor(cargo, matricula, nome, email, senha);
            }
            ListaPessoal.add(pessoa);

        }
    }

    public static void main(String[] args) {
        new Main();
    }

}
