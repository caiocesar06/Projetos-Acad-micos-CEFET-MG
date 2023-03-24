import java.util.Scanner;

public class Questao1A {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num;
        boolean valido = false;
        
        do {
            System.out.print("Escreva um numero inteiro de 5 digitos: ");
            num = scan.nextInt();

            if(Integer.toString(num).length() != 5)
                System.out.println("Escreva um numero valido!\n\n");
            else
                valido = true;
        }while(!valido);
        scan.close();

        System.out.print(num / 10000 + "   ");
        System.out.print((num % 10000) / 1000 + "   ");
        System.out.print((num % 1000) / 100 + "   ");
        System.out.print((num % 100) / 10 + "   ");
        System.out.println(num % 10 + "   ");
    }
}

// FELIPE GAY