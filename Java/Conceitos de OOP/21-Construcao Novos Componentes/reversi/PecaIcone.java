package reversi;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class PecaIcone extends JButton {
    
    private static int tamanho = 64;
    private Estado estado;
    private Image i1, i2;

    public PecaIcone() {
        super();
        setContentAreaFilled(false);
        estado = Estado.VAZIO;
        i1 = new ImageIcon(getClass().getResource("./Sprites/mcrodrigofaro.jpg")).getImage();
        i2 = new ImageIcon(getClass().getResource("./Sprites/thomasshelby_chika.png")).getImage();
    }

    public Dimension getMaximumSize() { return getPreferredSize(); }
    public Dimension getMinimumSize() { return getPreferredSize(); }
    public Dimension getPreferredSize() { return new Dimension(tamanho, tamanho); }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        if(estado != Estado.VAZIO) {
            if(estado == Estado.BRANCO) g2d.drawImage(i1, 0, 0, 70, 90, null);
            else if(estado == Estado.PRETO) g2d.drawImage(i2, 0, 0, 70, 80, null);
        }
        g2d.setColor(Color.GRAY);
    }

    public void setEstado(Estado e) { estado = e; }
}
