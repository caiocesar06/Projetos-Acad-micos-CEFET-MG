package reversi;

import java.awt.*;
import java.awt.geom.Point2D;

import javax.swing.JButton;

public class PecaMelhor extends JButton {
    
    private static int tamanho = 64;
    private Estado estado;

    public PecaMelhor() {
        super();
        setBackground(new Color(40, 200, 0));
        estado = Estado.VAZIO;
    }

    public void setEstado(Estado e) { estado = e; }

    public Dimension getMaximumSize() { return getPreferredSize(); }
    public Dimension getMinimumSize() { return getPreferredSize(); }
    public Dimension getPreferredSize() { return new Dimension(tamanho, tamanho); }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        if(estado != Estado.VAZIO) {
            Color[] cores = new Color[2];
            if(estado == Estado.BRANCO) {
                cores[0] = Color.WHITE;
                cores[1] = new Color(220, 220, 220);
            } else if(estado == Estado.PRETO) { 
                cores[0] = new Color(100, 100, 100);
                cores[1] = Color.BLACK;
            }
            RadialGradientPaint paint = new RadialGradientPaint(new Point2D.Double(tamanho / 3, tamanho / 3), 2 * tamanho / 3, new float[]{0f, 1f}, cores);
            g2d.setPaint(paint);
            g2d.fillOval(6, 6, getWidth() - 12, getHeight() - 12);
        }
        g2d.setColor(new Color(20, 150, 0));
        g2d.setStroke(new BasicStroke(3f));
        g2d.drawOval(6, 6, getWidth() - 12, getHeight() - 12);
    }
}
