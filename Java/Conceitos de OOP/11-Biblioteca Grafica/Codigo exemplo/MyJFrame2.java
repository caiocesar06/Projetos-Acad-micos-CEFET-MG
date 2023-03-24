
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
/***
 * Classe com escutador externo
 */
public class MyJFrame2 extends JFrame {

	private JLabel jlabel;
	protected JTextField jtext;
	private JButton jbutton;

	public MyJFrame2(String titulo) {
		super(titulo);
		setLayout(new FlowLayout());

		jlabel = new JLabel("Insira seu nome:");
		jtext = new JTextField("Anônimo");
		jbutton = new JButton("OK");

		add(jlabel);
		add(jtext);
		add(jbutton);

		TextFieldHandler handler = new TextFieldHandler();

		jtext.addActionListener(handler);
		jbutton.addActionListener(handler);

	}

	private class TextFieldHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {			
			
			if (event.getSource()==jtext) {
				JOptionPane.showMessageDialog(MyJFrame2.this,
						"Caixa de texto: " + event.getActionCommand());	
			} else {
				
				JOptionPane.showMessageDialog(MyJFrame2.this,
						"Botão: " +MyJFrame2.this.jtext.getText());
			}
			
		}

	}
	
	public static void main(String[] args) {
		MyJFrame2 my = new MyJFrame2("Teste de Janela");
		my.setSize(300,130);
		my.setVisible(true);
	}

}
