
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
/***
 * Classe com escutador na própria classe
 */
public class MyJFrame extends JFrame implements ActionListener{

	private JLabel jlabel;
	protected JTextField jtext;
	private JButton jbutton;

	public MyJFrame(String titulo) {
		super(titulo);
		setLayout(new FlowLayout());

		jlabel = new JLabel("Insira seu nome:");
		jtext = new JTextField("Anônimo");
		jbutton = new JButton("OK");

		add(jlabel);
		add(jtext);
		add(jbutton);

		jtext.addActionListener(this);
		jbutton.addActionListener(this);

	}


	@Override
	public void actionPerformed(ActionEvent event) {
		
		if (event.getSource()==jtext) {
			JOptionPane.showMessageDialog(this,
					"Caixa de texto: " + event.getActionCommand());	
		} else {
			
			JOptionPane.showMessageDialog(this,
					"Botão: " +this.jtext.getText());
		}		
	}

		
	public static void main(String[] args) {
		MyJFrame my = new MyJFrame("Teste de Janela");
		my.setSize(300,130);
		my.setVisible(true);
	}
}
