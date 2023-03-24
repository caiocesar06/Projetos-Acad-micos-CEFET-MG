package Questao2;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TemperatureConverter implements ActionListener {

    private JLabel lblCelsius;
    private JTextField txtFahrenheit;
    private JButton btnConverter;

    public static void main(String[] args) {
        new TemperatureConverter();
    }

    public TemperatureConverter() {
        
        txtFahrenheit = new JTextField(10);
        
        lblCelsius = new JLabel("Celsius: 0.0°C");

        btnConverter = new JButton("Converter");
        btnConverter.addActionListener(this);

        JFrame frame = new JFrame("Temperature Converter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new FlowLayout());
        frame.setVisible(true);

        frame.add(txtFahrenheit);
        frame.add(lblCelsius);
        frame.add(btnConverter);
    }

    public float FahrenheitToCelsius(float fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        float fahrenheit = Float.parseFloat(txtFahrenheit.getText());
        float celsius = FahrenheitToCelsius(fahrenheit);
        lblCelsius.setText("Celsius: " + celsius + "°C");
    }
}
