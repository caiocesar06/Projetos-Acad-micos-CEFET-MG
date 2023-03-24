package ExtremamenteBásico;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        new Main();
    }

    public Main() {
        Scanner ler = new Scanner(System.in);
        System.out.println("X = " + (ler.nextInt() + ler.nextInt()));
        ler.close();
    }
}