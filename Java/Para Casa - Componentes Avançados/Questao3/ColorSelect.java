package Questao3;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ColorSelect extends JFrame implements ItemListener {
    private JComboBox<Color> cbxColors;
    private JRadioButton rdbBackground;
    private JRadioButton rdbForeground;
    private JButton btnOk;

    public static void main(String[] args) {
        new ColorSelect();
    }

    public ColorSelect() {
        super("Color Select");
        this.setSize(320, 240);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        cbxColors = new JComboBox<Color>();

        cbxColors.addItem(Color.RED);
        cbxColors.addItem(Color.GREEN);
        cbxColors.addItem(Color.BLUE);
        cbxColors.addItem(Color.YELLOW);
        cbxColors.addItem(Color.ORANGE);
        cbxColors.addItem(Color.PINK);
        cbxColors.addItem(Color.CYAN);
        cbxColors.addItem(Color.BLACK);
        cbxColors.addItem(Color.WHITE);

        // cbxColors.addItem("Red");
        // cbxColors.addItem("Green");
        // cbxColors.addItem("Blue");
        // cbxColors.addItem("Yellow");
        // cbxColors.addItem("Black");
        // cbxColors.addItem("White");
        rdbBackground = new JRadioButton("Background");
        rdbForeground = new JRadioButton("Foreground");
        btnOk = new JButton("Ok");

        cbxColors.addItemListener(this);
        rdbBackground.addItemListener(this);
        rdbForeground.addItemListener(this);
        btnOk.addItemListener(this);

        this.add(cbxColors, BorderLayout.NORTH);
        this.add(rdbBackground, BorderLayout.WEST);
        this.add(rdbForeground, BorderLayout.EAST);
        this.add(btnOk, BorderLayout.SOUTH);

        this.pack();
        this.setVisible(true);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getSource() == cbxColors) {
            if(rdbBackground.isSelected()) {
                this.getContentPane().setBackground((Color)cbxColors.getSelectedItem());
            } else if(rdbForeground.isSelected()) {
                this.getContentPane().setForeground((Color)cbxColors.getSelectedItem());
            }
        }
    }
}
