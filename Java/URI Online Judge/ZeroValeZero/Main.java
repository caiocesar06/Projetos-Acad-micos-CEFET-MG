package ZeroValeZero;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public ArrayList<String> sumsWithoutZero;

    public static void main(String[] args) throws IOException {
        new Main();
    }

    public Main() {
        Scanner ler = new Scanner(System.in);
        sumsWithoutZero = new ArrayList<String>();
        String linha;
        do{
            linha = ler.nextLine();
            int n = setValues(true, Integer.parseInt(linha.split(" ")[0]), Integer.parseInt(linha.split(" ")[1]));
            int m = setValues(false, Integer.parseInt(linha.split(" ")[0]), Integer.parseInt(linha.split(" ")[1]));

            sumsWithoutZero.add(removeZero(sum(m, n)));
        } while(Integer.parseInt(linha.split(" ")[0]) != 0 && Integer.parseInt(linha.split(" ")[1]) != 0);

        for(String sum : sumsWithoutZero) {
            if(!sum.equals("")) {
                System.out.println(sum);
            }
        }
        ler.close();
    }

    public int setValues(boolean isN, int valueN, int valueM) {
        int n = 0;
        int m = 0;
        if (valueM >= 1 && valueM <= 999999999 && valueN >= 1 && valueN <= 999999999) {
            n = valueN >= valueM ? valueN : valueM;
            m = valueM <= valueN ? valueM : valueN;
        }
        if (isN)
            return n;
        else
            return m;
    }

    public int sum(int n, int m) {
        return n + m;
    }

    public String removeZero(int soma) {
        String somaString = soma + "";
        String somaSemZero = "";
        for (int i = 0; i < somaString.length(); i++) {
            if (somaString.charAt(i) != '0') {
                somaSemZero += somaString.charAt(i);
            }
        }
        return somaSemZero;
    }
}