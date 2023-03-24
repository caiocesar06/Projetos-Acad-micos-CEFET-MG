package Funções;

import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        new Main();
    }

    public Main() {
        Scanner ler = new Scanner(System.in);
        ArrayList<Integer> x = new ArrayList<Integer>();
        ArrayList<Integer> y = new ArrayList<Integer>();
        int qtd = ler.nextInt();
        ler.nextLine();
        for (int i = 0; i < qtd; i++) {
            setVariables(ler.nextLine(), x, y);
        }
        for (int i = 0; i < qtd; i++) {
            System.out.println(getWinner(rafaelFunction(x.get(i), y.get(i)), betoFunction(x.get(i), y.get(i)), carlosFunction(x.get(i), y.get(i))) + " ganhou");
        }
        ler.close();
    }

    public void setVariables(String XandY, ArrayList<Integer> varX, ArrayList<Integer> varY) {
        int numberX = Integer.parseInt(XandY.split(" ")[0]);
        int numberY = Integer.parseInt(XandY.split(" ")[1]);
        if (numberX >= 1 && numberX <= 100 && numberY >= 1 && numberY <= 100) {
            varX.add(numberX);
            varY.add(numberY);
        }
    }

    public float rafaelFunction(int x, int y) {
        return (float) (Math.pow(3 * x, 2) + Math.pow(y, 2));
    }

    public float betoFunction(int x, int y) {
        return (float) (2 * (Math.pow(x, 2)) + Math.pow(5 * y, 2));
    }

    public float carlosFunction(int x, int y) {
        return (float) ((-100 * x) + Math.pow(y, 3));
    }

    public String getWinner(float rafael, float beto, float carlos) {
        if (rafael > beto && rafael > carlos) {
            return "Rafael";
        } else if (beto > rafael && beto > carlos) {
            return "Beto";
        } else {
            return "Carlos";
        }
    }
}
