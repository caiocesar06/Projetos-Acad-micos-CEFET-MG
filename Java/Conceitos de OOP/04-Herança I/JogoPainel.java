import java.awt.*;
import javax.swing.*;
import java.util.*;

public class JogoPainel extends JPanel implements Runnable {
    private Thread animacao;
    private int tempoEspera = 10;
    private boolean jogando = false;
    
    ArrayList<Movel> bolas = new ArrayList<Movel>();

    public JogoPainel() {
        setBackground(Color.WHITE);
        setFocusable(true);
        for(int i = 0; i < 10; i++) {
            Random random = new Random();
            Movel bola = new Movel(random.nextInt(450), random.nextInt(250), randomNegativo(), randomNegativo(), random.nextInt(100), 625, 445);
            bolas.add(bola);
        }
    }

    public void addBola() {
        Random random = new Random();
        Movel bola = new Movel(random.nextInt(450), random.nextInt(250), randomNegativo(), randomNegativo(), random.nextInt(100), 625, 445);
        bolas.add(bola);
    }

    public void removeBola() {
        bolas.remove(bolas.size() - 1);
    }

    public int randomNegativo() {
        Random rand = new Random();
        if(rand.nextInt(2) == 0) {
            return rand.nextInt(10);
        } else {
            return rand.nextInt(10) * -1;
        }
    }
    
    public void addNotify() {
        super.addNotify();
        iniciarJogo();
    }

    public void iniciarJogo() {
        if(animacao == null || !jogando) {
            animacao = new Thread(this);
            animacao.start();
        }
    }

    

    public void run() {
        jogando = true;
        while(jogando) {
            for(Movel bola : bolas) {
                bola.move();
            }
            try {
                Thread.sleep(tempoEspera);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.exit(0);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(Movel bola : bolas) {
            bola.paintComponent(g);
        }
    }
}