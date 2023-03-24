import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Jogo {
    public static void main(String[] args) {
        new Jogo();
    }

    public Jogo() {
        JogoPainel jogoPainel = new JogoPainel();
        JFrame jogo = new JFrame("Tutorial");
        jogoPainel.setLayout(null);

        jogo.add(jogoPainel);
        jogo.pack();
        jogo.setSize(640, 580);
        jogoPainel.setBackground(new Color(240, 240, 240));
        jogo.setResizable(false);
        jogo.setVisible(true);
        jogo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton botaoAdd = new JButton("Adicionar");
        botaoAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jogoPainel.addBola();
            }
        });
        botaoAdd.setBounds(200, 490, 95, 30);
        botaoAdd.setBackground(new Color(100, 180, 100));
        botaoAdd.setForeground(Color.WHITE);
        botaoAdd.setFocusable(false);
        jogoPainel.add(botaoAdd);

        JButton botaoRemove = new JButton("Remover");
        botaoRemove.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jogoPainel.removeBola();
            }
        });
        botaoRemove.setBounds(320, 490, 95, 30);
        botaoRemove.setBackground(new Color(180, 100, 100));
        botaoRemove.setForeground(Color.WHITE);
        botaoRemove.setFocusable(false);
        jogoPainel.add(botaoRemove);
    }
}