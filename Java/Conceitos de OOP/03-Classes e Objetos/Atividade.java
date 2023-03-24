import java.util.Scanner;

class Aluno {
    public int matricula, grupo, subturma;
    public String nome, senha;

    public Aluno(int matricula, String nome, int grupo, int subturma, String senha) {
        this.matricula = matricula;
        this.nome = nome;
        this.grupo = grupo;
        this.subturma = subturma;
        this.senha = senha;
    }

    public void imprimirSenha() {
        for(int i = 0; i < this.senha.length(); i++) {
            System.out.print('*');
        }
    }
}

public class Atividade {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        Aluno[] aluno = new Aluno[3];
        int[] matr = new int[3],
              grup = new int[3],
              subt = new int[3];
        String[] nom = new String[3],
                 sen = new String[3];
        int contAlunos = 1;
        for(int i = 0; i < 3; i++) {
            System.out.println("~~ Insira os dados do aluno " + contAlunos + " ~~");
            System.out.print("Matricula: ");
            matr[i] = ler.nextInt();

            ler.nextLine();
            System.out.print("Nome: ");
            nom[i] = ler.nextLine();

            System.out.print("Grupo: ");
            grup[i] = ler.nextInt();

            System.out.print("Subturma: ");
            subt[i] = ler.nextInt();

            ler.nextLine();
            System.out.print("Senha: ");
            sen[i] = ler.nextLine();

            aluno[i] = new Aluno(matr[i], nom[i], grup[i], subt[i], sen[i]);
            System.out.println("\n\n");
            contAlunos++;
        }
        ler.close();
        int cont = 1;
        for(int i = 0; i < 3; i++) {
            System.out.println("/================ Dados do aluno " + cont + " ===================/");
            System.out.printf("Matricula: %d\t\tNome: %s\n", aluno[i].matricula, aluno[i].nome);
            System.out.printf("Grupo: %d\t\tSubTurma: %d\n", aluno[i].grupo, aluno[i].subturma);
            System.out.print("Senha: ");
            aluno[i].imprimirSenha();
            System.out.println("\n\n");
            cont++;
        }
    }
}