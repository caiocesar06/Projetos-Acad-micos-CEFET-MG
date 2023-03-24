import java.util.ArrayList;
import java.util.Scanner;

// Os comentários do código são partes bugadas, onde eu simplesmente
// pesquisei muito e não consegui achar nenhuma solução.
// Se você descubrir alguma solução, por favor, me avise!

public class Main {
    public static void main(String[] args) {
        ArrayList<Funcionario> listaFuncionarios = new ArrayList<Funcionario>();
        Scanner ler = new Scanner(System.in);
        Funcionario f = new Funcionario();
        // boolean newFuncionario;
        // while (newFuncionario) {
            System.out.println("Escolha o tipo de funcionario:");
            System.out.println("1 - Funcionario");
            System.out.println("2 - Funcionario com turma");
            System.out.println("3 - Funcionario com setor");
            int escolha = ler.nextInt();
            switch (escolha) {
                case 1:
                    f.getDadosFuncionario(listaFuncionarios);
                    break;
                case 2:
                    f.getDadosFuncionarioTurma(listaFuncionarios);
                    break;
                case 3:
                    f.getDadosFuncionarioSetor(listaFuncionarios);
                    break;
                default:
                    System.out.println("Escolha invalida");
                    break;
            }

            // System.out.println("Deseja cadastrar outro funcionario? (1 - Sim / 2 - Nao)");
            // int escolha2 = ler.nextInt();
            // switch (escolha2) {
            //     case 1:
            //         newFuncionario = true;
            //         break;
            //     case 2:
            //         newFuncionario = false;
            //         break;
            //     default:
            //         System.out.println("Escolha invalida");
            //         break;
            // }
        // }

        // System.out.println("Deseja inserir os funcionarios do arquivo csv? (1 - Sim / 2 - Nao)");
        // int escolha3 = ler.nextInt();
        // switch (escolha3) {
        //     case 1:
                listaFuncionarios.addAll(new Funcionario().getDadosArquivoToArrayList("pessoal.csv"));
        //         break;
        //     case 2:
        //         break;
        //     default:
        //         System.out.println("Escolha invalida");
        //         break;
        // }
        // Imprimir ArrayList
        for (Funcionario funcionario : listaFuncionarios) {
            System.out.println(funcionario);
        }
        ler.close();
    }
}
