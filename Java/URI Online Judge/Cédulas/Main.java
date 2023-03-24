package Cédulas;

import java.io.IOException;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) throws IOException{
        new Main();
    }

    public Main() {
        Scanner ler = new Scanner(System.in);
        int cedula100, cedula50, cedula20, cedula10, cedula5, cedula2, cedula1;
        int n = ler.nextInt();
        System.out.println(n);
        cedula100 = n / 100;
        n = n % 100;
        cedula50 = n / 50;
        n = n % 50;
        cedula20 = n / 20;
        n = n % 20;
        cedula10 = n / 10;
        n = n % 10;
        cedula5 = n / 5;
        n = n % 5;
        cedula2 = n / 2;
        n = n % 2;
        cedula1 = n;
        
        System.out.println(cedula100 + " nota(s) de R$ 100,00");
        System.out.println(cedula50 + " nota(s) de R$ 50,00");
        System.out.println(cedula20 + " nota(s) de R$ 20,00");
        System.out.println(cedula10 + " nota(s) de R$ 10,00");
        System.out.println(cedula5 + " nota(s) de R$ 5,00");
        System.out.println(cedula2 + " nota(s) de R$ 2,00");
        System.out.println(cedula1 + " nota(s) de R$ 1,00");
        ler.close();
    }
}

/*
 * import java.util.Scanner;
 * 
 * public class Main {
 *  
 *     public static void main(String[] args) throws IOException {
 *         new Main();
 *     }
 * 
 *     public Main(){
 *         int nota100, nota50, nota20, nota10, nota5, nota2, qtd;
 *         Scanner ler = new Scanner(System.in);
 *         qtd = ler.nextInt();
 * 
 *         System.out.println(qtd);
 * 
 *         nota100 = qtd/100;
 *         qtd = qtd%100;
 *         nota50 = qtd/50;
 *         qtd = qtd%50;
 *         nota20 = qtd/20;
 *         qtd = qtd%20;
 *         nota10 = qtd/10;
 *         qtd = qtd%10;
 *         nota5 = qtd/5;
 *         qtd = qtd%5;
 *         nota2 = qtd/2;
 *         qtd = qtd%2;
 * 
 *         System.out.println(nota100 + " nota(s) de R$ 100,00");
 *         System.out.println(nota50 + " nota(s) de R$ 50,00");
 *         System.out.println(nota20 + " nota(s) de R$ 20,00");
 *         System.out.println(nota10 + " nota(s) de R$ 10,00");
 *         System.out.println(nota5 + " nota(s) de R$ 5,00");
 *         System.out.println(nota2 + " nota(s) de R$ 2,00");
 *         System.out.println(qtd + " nota(s) de R$ 1,00");
 *     }
 *  
 * }
 */