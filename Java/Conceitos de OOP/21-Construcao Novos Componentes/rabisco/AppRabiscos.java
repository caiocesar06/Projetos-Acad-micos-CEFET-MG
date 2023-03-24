package rabisco;

import java.awt.Color;
import java.awt.Container;
import javax.swing.JFrame;

public class AppRabiscos extends JFrame {
    
    public AppRabiscos() {
        ComponenteParaRabiscos c = new ComponenteParaRabiscos(new Color(50, 120, 250));
        Container cp = getContentPane();
        cp.add(c);
        setSize(400, 400);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new AppRabiscos();
    }
}
