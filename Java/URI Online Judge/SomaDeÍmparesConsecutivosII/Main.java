package SomaDeÍmparesConsecutivosII;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    ArrayList<Integer> resultados = new ArrayList<Integer>();

    public static void main(String[] args) throws IOException {
        new Main();
    }

    public Main() {
        Scanner ler = new Scanner(System.in);
        int n = ler.nextInt();
        ler.nextLine();
        int x;
        int y;
        for (int i = 0; i < n; i++) {
            String[] algarismos = ler.nextLine().split(" ");
            int soma = 0;
            x = Integer.parseInt(algarismos[0]);
            y = Integer.parseInt(algarismos[1]);
            int maior = x >= y ? x : y;
            int menor = x < y ? x : y;
            for (int j = menor + 1; j < maior; j++) {
                if (j % 2 != 0) {
                    soma += j;
                }
                
            }
            resultados.add(soma);
        }
        for (int resultado : resultados) {
            System.out.println(resultado);
        }
        ler.close();
    }
}