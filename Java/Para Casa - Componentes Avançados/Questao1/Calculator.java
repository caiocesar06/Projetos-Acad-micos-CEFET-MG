package Questao1;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class Calculator {
    
    private JTextField txtDisplay;

    private JButton btn0;
    private JButton btn1;
    private JButton btn2;
    private JButton btn3;
    private JButton btn4;
    private JButton btn5;
    private JButton btn6;
    private JButton btn7;
    private JButton btn8;
    private JButton btn9;

    private JButton btnSum;
    private JButton btnSub;
    private JButton btnMult;
    private JButton btnDiv;
    private JButton btnEqual;

    private JButton btnDot;

    public static void main(String[] args) {
        new Calculator();
    }

    public Calculator() {
        txtDisplay = new JTextField();

        btn0 = new JButton("0");
        btn1 = new JButton("1");
        btn2 = new JButton("2");
        btn3 = new JButton("3");
        btn4 = new JButton("4");
        btn5 = new JButton("5");
        btn6 = new JButton("6");
        btn7 = new JButton("7");
        btn8 = new JButton("8");
        btn9 = new JButton("9");

        btnSum = new JButton("+");
        btnSub = new JButton("-");
        btnMult = new JButton("*");
        btnDiv = new JButton("/");
        btnEqual = new JButton("=");

        btnDot = new JButton(".");

        JFrame frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200, 200);
        frame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 4;
        gbc.gridx = 0;
        gbc.gridy = 0;
        frame.add(txtDisplay, gbc);
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 1;
        frame.add(btn7, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        frame.add(btn8, gbc);
        gbc.gridx = 2;
        gbc.gridy = 1;
        frame.add(btn9, gbc);
        gbc.gridx = 3;
        gbc.gridy = 1;
        frame.add(btnDiv, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        frame.add(btn4, gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        frame.add(btn5, gbc);
        gbc.gridx = 2;
        gbc.gridy = 2;
        frame.add(btn6, gbc);
        gbc.gridx = 3;
        gbc.gridy = 2;
        frame.add(btnMult, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        frame.add(btn1, gbc);
        gbc.gridx = 1;
        gbc.gridy = 3;
        frame.add(btn2, gbc);
        gbc.gridx = 2;
        gbc.gridy = 3;
        frame.add(btn3, gbc);
        gbc.gridx = 3;
        gbc.gridy = 3;
        frame.add(btnSub, gbc);
        gbc.gridx = 0;
        gbc.gridy = 4;
        frame.add(btn0, gbc);
        gbc.gridx = 1;
        gbc.gridy = 4;
        frame.add(btnDot, gbc);
        gbc.gridx = 2;
        gbc.gridy = 4;
        frame.add(btnEqual, gbc);
        gbc.gridx = 3;
        gbc.gridy = 4;
        frame.add(btnSum, gbc);
        frame.setVisible(true);
    }
}