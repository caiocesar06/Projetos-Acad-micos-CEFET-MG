import java.util.Scanner;

public class Questao1D {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        float peso, altura, IMC;

        System.out.print("Digite o peso (kg): ");
        peso = ler.nextFloat();

        System.out.print("Digite a altura (m): ");
        altura = ler.nextFloat();

        ler.close();

        IMC = peso / (altura * altura);

        System.out.println("\nValor do IMC: " + IMC);
        if(IMC < 18.5)
            System.out.println("MAGREZA");
        if(IMC >= 18.5 && IMC <= 24.9)
            System.out.println("NORMAL");
        if(IMC >= 25.0 && IMC <= 29.9)
            System.out.println("SOBREPESO");
        if(IMC >= 30.0)
            System.out.println("OBESIDADE");
    }
}