import java.awt.*;
import javax.swing.*;
import java.util.*;

public class Movel extends JPanel {
    private int largura;
    private int altura;
    private int x, y, velocidadeX, velocidadeY, diametroBola;
    private Color cor;

    Random rand = new Random();

    public Movel(int x, int y, int velocidadeX, int velocidadeY, int diametroBola, int largura, int altura) {
        this.x = x;
        this.y = y;
        this.velocidadeX = velocidadeX;
        this.velocidadeY = velocidadeY;
        this.setDiametroBola(diametroBola);
        this.setLargura(largura);
        this.setAltura(altura);

        cor = new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255));
    }

    public void setDiametroBola(int diametroBola) {
        if(diametroBola >= 0) {
            this.diametroBola = diametroBola;
        } else {
            System.out.println("Erro: Diametro da bola negativo.\n");
        }
    }
    
    public void setLargura(int largura) {
        if(largura >= 0) {
            this.largura = largura;
        } else {
            System.out.println("Erro: Largura negativa.\n");
        }
    }

    public void setAltura(int altura) {
        if(altura >= 0) {
            this.altura = altura;
        } else {
            System.out.println("Erro: Altura negativa");
        }
    }

    public void move() {
        if(x >= this.largura - diametroBola || x <= 0) {
            velocidadeX *= -1;
        }
        if(y >= this.altura - diametroBola || y <= 0) {
            velocidadeY *= -1;
        }
        x += velocidadeX;
        y += velocidadeY;
    }

    public void paintComponent(Graphics g) {
        g.setColor(cor);
        g.fillOval(x, y, diametroBola, diametroBola);
    }
}