import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Funcionario {
    private int id;
    private String nome, email, senha, cargo;
    ArrayList<Funcionario> listaFuncionariosCsv = new ArrayList<Funcionario>();

    public Funcionario(int id, String nome, String email, String senha, String cargo) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.cargo = cargo;
    }

    public Funcionario() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCargo() {
        return this.cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String imprimirSenha() {
        String senha = "";
        for (int i = 0; i < this.senha.length(); i++) {
            senha += "*";
        }
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public ArrayList<Funcionario> getDadosArquivoToArrayList(String nomeArquivo) {
        try (BufferedReader lerArq = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha = lerArq.readLine();
            linha = lerArq.readLine();
            while (linha != null) {
                String[] dados = linha.split(";");

                if (dados.length == 5) {
                    Funcionario f = new Funcionario(Integer.parseInt(dados[0]), dados[1], dados[2], dados[3], dados[4]);
                    listaFuncionariosCsv.add(f);
                } else if (dados.length == 6) {
                    FuncionarioTurma ft = new FuncionarioTurma(Integer.parseInt(dados[0]), dados[1], dados[2], dados[3],
                            dados[4], dados[5]);
                    listaFuncionariosCsv.add(ft);
                } else if (dados.length == 7) {
                    FuncionarioSetor fs = new FuncionarioSetor(Integer.parseInt(dados[0]), dados[1], dados[2], dados[3],
                            dados[4], dados[6]);
                    listaFuncionariosCsv.add(fs);
                }

                linha = lerArq.readLine();
            }
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
        }
        return listaFuncionariosCsv;
    }

    public void getDadosFuncionario(ArrayList<Funcionario> listaFuncionarios) {
        Scanner ler = new Scanner(System.in);
        System.out.println("\nDigite o id do funcionario: ");
        int id = ler.nextInt();
        System.out.println("Digite o nome do funcionario: ");
        ler.nextLine();
        String nome = ler.nextLine();
        System.out.println("Digite o email do funcionario: ");
        String email = ler.nextLine();
        System.out.println("Digite a senha do funcionario: ");
        String senha = ler.nextLine();
        System.out.println("Digite o cargo do funcionario: ");
        String cargo = ler.nextLine();
        ler.close();
        Funcionario f = new Funcionario(id, nome, email, senha, cargo);
        listaFuncionarios.add(f);
    }

    public void getDadosFuncionarioTurma(ArrayList<Funcionario> listaFuncionarios) {
        Scanner ler = new Scanner(System.in);
        System.out.println("\nDigite o id do funcionario: ");
        int id = ler.nextInt();
        System.out.println("Digite o nome do funcionario: ");
        ler.nextLine();
        String nome = ler.nextLine();
        System.out.println("Digite o email do funcionario: ");
        String email = ler.nextLine();
        System.out.println("Digite a senha do funcionario: ");
        String senha = ler.nextLine();
        System.out.println("Digite o cargo do funcionario: ");
        String cargo = ler.nextLine();
        System.out.println("Digite a turma do funcionario: ");
        String turma = ler.nextLine();
        ler.close();
        FuncionarioTurma ft = new FuncionarioTurma(id, nome, email, senha, cargo, turma);
        listaFuncionarios.add(ft);
    }

    public void getDadosFuncionarioSetor(ArrayList<Funcionario> listaFuncionarios) {
        Scanner ler = new Scanner(System.in);
        System.out.println("\nDigite o id do funcionario: ");
        int id = ler.nextInt();
        System.out.println("Digite o nome do funcionario: ");
        ler.nextLine();
        String nome = ler.nextLine();
        System.out.println("Digite o email do funcionario: ");
        String email = ler.nextLine();
        System.out.println("Digite a senha do funcionario: ");
        String senha = ler.nextLine();
        System.out.println("Digite o cargo do funcionario: ");
        String cargo = ler.nextLine();
        System.out.println("Digite o setor do funcionario: ");
        String setor = ler.nextLine();
        ler.close();
        FuncionarioSetor fs = new FuncionarioSetor(id, nome, email, senha, cargo, setor);
        listaFuncionarios.add(fs);
    }

    @Override
    public String toString() {
        return String.format("Id: %d  -  Nome: %s  -  Email: %s  -  Senha: %s  -  Cargo: %s", this.id, this.nome, this.email, imprimirSenha(), this.cargo);
    }
}