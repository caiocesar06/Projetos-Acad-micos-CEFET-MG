import java.util.Scanner;

public class InOut {
	public static void main(String[] args) {
		String texto;
		Scanner entrada = new Scanner(System.in);
		System.out.println("Digite algo no teclado:");
		texto = entrada.nextLine();
		System.out.println("Voce digitou: " + texto);
	}
}