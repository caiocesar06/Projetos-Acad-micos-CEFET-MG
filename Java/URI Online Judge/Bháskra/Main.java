package Bháskra;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        new Main();
    }

    public Main() {
        Scanner ler = new Scanner(System.in);
        String valores = ler.nextLine();
        double a = setValue(valores, 0);
        double b = setValue(valores, 1);
        double c = setValue(valores, 2);
        if(isSolvable(a, b, c)) {
            System.out.format("R1 = %.5f\n", getR1(a, b, c));
            System.out.format("R2 = %.5f\n", getR2(a, b, c));
        } else {
            System.out.println("Impossivel calcular");
        }
        ler.close();
    }

    public double setValue(String line, int index) {
        return Double.parseDouble(line.split(" ")[index]);
    }

    public double delta(double a, double b, double c) {
        return (b * b) - (4 * a * c);
    }

    public boolean isSolvable(double a, double b, double c) {
        return delta(a, b, c) >= 0 && 2 * a != 0;
    }

    public double getR1(double a, double b, double c) {
        return (-b + Math.sqrt(delta(a, b, c))) / (2 * a);
    }

    public double getR2(double a, double b, double c) {
        return (-b - Math.sqrt(delta(a, b, c))) / (2 * a);
    }
}