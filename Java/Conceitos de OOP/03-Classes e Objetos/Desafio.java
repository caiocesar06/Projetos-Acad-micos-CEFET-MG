import java.util.*;
import java.io.*;

class Aluno {
    private int codigo, grupo, subturma, orientador;
    private long matricula;
    private String nome;

    public Aluno(int codigo, long matricula, String nome, int grupo, int subturma, int orientador) {
        this.codigo = codigo;
        this.matricula = matricula;
        this.nome = nome;
        this.grupo = grupo;
        this.subturma = subturma;
        this.orientador = orientador;
    }

    public void print() {
        System.out.println(this.codigo + " - " + this.matricula + " - " + this.nome + " - " + this.grupo + " - " + this.subturma + " - " + this.orientador);
    }
}

public class Desafio {
    public static void main(String[] args) {
        File arquivo = new File("lista.csv");

        List <Aluno> lista = new ArrayList<Aluno>();

        try(BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha = br.readLine();
            linha = br.readLine();
            while(linha != null) {
                String[] dados = linha.split(";");

                int codigo = Integer.parseInt(dados[0]);
                long matricula = Long.parseLong(dados[1]);
                String nome = dados[2];
                int grupo = Integer.parseInt(dados[3]);
                int subturma = Integer.parseInt(dados[4]);
                int orientador = Integer.parseInt(dados[5]);

                Aluno aluno = new Aluno(codigo, matricula, nome, grupo, subturma, orientador);
                lista.add(aluno);

                linha = br.readLine();
            }
            System.out.println("Lista completa:");
            for(Aluno aluno : lista) {
                aluno.print();
            }
        } catch(IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}