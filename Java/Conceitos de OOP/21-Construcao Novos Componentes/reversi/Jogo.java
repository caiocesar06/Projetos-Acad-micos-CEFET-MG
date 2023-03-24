package reversi;

import javax.swing.JFrame;

public class Jogo extends JFrame {
    
    public Jogo() {
        super("Reversi");
        getContentPane().add(new Tabuleiro());
        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Jogo();
    }
}
