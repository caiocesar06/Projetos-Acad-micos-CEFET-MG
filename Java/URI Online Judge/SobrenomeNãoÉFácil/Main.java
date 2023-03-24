package SobrenomeNãoÉFácil;

import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public ArrayList<Character> vogais;
    public ArrayList<String> sobrenomes;

    public static void main(String[] args) throws IOException {
        new Main();
    }

    public Main() {
        Scanner ler = new Scanner(System.in);
        setVogais();
        setSobrenomes(ler);
        for (String sobrenome : sobrenomes) {
            if (testeTamanho(sobrenome, 42) && testeCapitalizado(sobrenome)) {
                if (testeConsoantesConsecutivas(sobrenome)) {
                    System.out.println(sobrenome + " nao eh facil");
                } else {
                    System.out.println(sobrenome + " eh facil");
                }
            }
        }
        ler.close();
    }

    public void setVogais() {
        vogais = new ArrayList<Character>();
        vogais.add('A');
        vogais.add('E');
        vogais.add('I');
        vogais.add('O');
        vogais.add('U');
        vogais.add('a');
        vogais.add('e');
        vogais.add('i');
        vogais.add('o');
        vogais.add('u');
    }

    public void setSobrenomes(Scanner ler) {
        sobrenomes = new ArrayList<String>();
        int n = ler.nextInt();
        ler.nextLine();
        for (int i = 0; i < n; i++) {
            sobrenomes.add(ler.nextLine());
        }
    }

    public boolean testeTamanho(String sobrenome, int tamanhoMax) {
        if (sobrenome.length() <= tamanhoMax)
            return true;
        return false;
    }

    public boolean testeCapitalizado(String sobrenome) {
        if (sobrenome.charAt(0) >= 65 && sobrenome.charAt(0) <= 90)
            return true;
        return false;
    }

    public boolean testeConsoantesConsecutivas(String sobrenome) {
        int contConsoantes = 0;
        for (int i = 0; i < sobrenome.length(); i++) {
            if (vogais.contains(sobrenome.charAt(i))) {
                contConsoantes = 0;
            } else {
                contConsoantes++;
                if (contConsoantes >= 3) {
                    return true;
                }
            }
        }
        return false;
    }
}