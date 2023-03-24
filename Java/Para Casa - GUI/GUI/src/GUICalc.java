import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUICalc extends JPanel implements ActionListener {

    private JTextField  jTextField;

    private JButton plus;
    private JButton minus;
    private JButton times;
    private JButton divide;

    private JButton dot;
    private JButton equal;

    private JButton button0;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;

    private JFrame frame;

    public GUICalc() {
        frame = new JFrame("Calculadora");
        frame.setLayout(new GridBagLayout());
        frame.setSize(800, 800);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 4;
        gbc.gridx = 0;
        gbc.gridy = 0;
        jTextField = new JTextField(64);
        frame.add(jTextField, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        button7 = new JButton("7");
        frame.add(button7, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        button8 = new JButton("8");
        frame.add(button8, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        button9 = new JButton("9");
        frame.add(button9, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        divide = new JButton("/");
        frame.add(divide, gbc);

        gbc.gridx = 2;
        gbc.gridy = 0;
        button4 = new JButton("4");
        frame.add(button4, gbc);

        gbc.gridx = 2;
        gbc.gridy = 1;
        button5 = new JButton("5");
        frame.add(button5, gbc);

        gbc.gridx = 2;
        gbc.gridy = 2;
        button6 = new JButton("6");
        frame.add(button6, gbc);

        gbc.gridx = 2;
        gbc.gridy = 3;
        times = new JButton("*");
        frame.add(times, gbc);

        gbc.gridx = 3;
        gbc.gridy = 0;
        button1 = new JButton("1");
        frame.add(button1, gbc);

        gbc.gridx = 3;
        gbc.gridy = 1;
        button2 = new JButton("2");
        frame.add(button2, gbc);

        gbc.gridx = 3;
        gbc.gridy = 2;
        button3 = new JButton("3");
        frame.add(button3, gbc);

        gbc.gridx = 3;
        gbc.gridy = 3;
        minus = new JButton("-");
        frame.add(minus, gbc);

        gbc.gridx = 4;
        gbc.gridy = 0;
        button0 = new JButton("0");
        frame.add(button0, gbc);

        gbc.gridx = 4;
        gbc.gridy = 1;
        dot = new JButton(".");
        frame.add(dot, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        equal = new JButton("=");
        frame.add(equal, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        plus = new JButton("+");
        frame.add(plus, gbc);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }
}
