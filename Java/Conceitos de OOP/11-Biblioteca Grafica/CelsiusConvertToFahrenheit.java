import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CelsiusConvertToFahrenheit extends JFrame implements ActionListener {
    
    private JLabel jLabelCelsius;
    private JLabel jLabelFahrenheit;
	protected JTextField jtext;
	private JButton jbutton;
    
    public CelsiusConvertToFahrenheit() {
        super("Celsius Converter");
        setSize(200, 100); 
        setLayout(new GridLayout(2, 2, 20, 10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jLabelCelsius = new JLabel("Celsius");
        jLabelFahrenheit = new JLabel("32.0 Fahrenheit");
        jtext = new JTextField("0");
        jbutton = new JButton("Converter");

        add(jtext);
        add(jLabelCelsius);
        add(jbutton);
        add(jLabelFahrenheit);
               
        jtext.addActionListener(this);
        jbutton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        jLabelFahrenheit.setText(String.valueOf(32 + (Double.parseDouble(jtext.getText()) * 9 / 5)) + " Fahrenheit");
    }

    public static void main(String[] args) {
        CelsiusConvertToFahrenheit celsiusConverter = new CelsiusConvertToFahrenheit();
        celsiusConverter.setVisible(true);
    }
}