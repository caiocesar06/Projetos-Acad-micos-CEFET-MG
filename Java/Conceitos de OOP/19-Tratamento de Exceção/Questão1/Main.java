package Questão1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        CalculadoraDePares calculadora = new CalculadoraDePares();
        Scanner ler = new Scanner(System.in);
        try {
            int escolha;
            int x;
            int y;
            do {
                System.out.println(">> Calculadora");
                System.out.println("1 - Soma               2 - Subtração");
                System.out.println("3 - Multiplicação      4 - Divisão");
                System.out.print("Sua escolha: ");
                escolha = ler.nextInt();

                System.out.print("\nValor X: ");
                x = ler.nextInt();
                System.out.print("\nValor Y: ");
                y = ler.nextInt();

                switch (escolha) {
                    case 1:
                        System.out.println("Valor da soma: " + calculadora.somar(x, y));
                        return;
                    case 2:
                        System.out.println("Valor da subtração: "+ calculadora.subtrair(x, y));
                        return;
                    case 3:
                        System.out.println("Valor da multiplicação: " + calculadora.multiplicar(x, y));
                        return;
                    case 4:
                        System.out.println("Valor da divisão: " + calculadora.dividir(x, y));
                        return;
                    default:
                        System.err.println("Valor inválido!\n\n\n");
                        return;
                } 
            } while (escolha < 1 || escolha > 4);
            
        } catch (NaoParException e) {
            System.err.println("");
            e.printStackTrace();
        } finally {
            ler.close();
        }
    }
}