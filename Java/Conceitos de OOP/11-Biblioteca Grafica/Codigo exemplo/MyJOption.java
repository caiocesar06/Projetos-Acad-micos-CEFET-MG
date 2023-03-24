
import javax.swing.JOptionPane;

public class MyJOption {

	public static void main(String[] args) {
		
		String nome = JOptionPane.showInputDialog(null, "Qual seu nome?",
				"Teste de Caixas de Diálogo", JOptionPane.INFORMATION_MESSAGE);

		JOptionPane.showMessageDialog(null, "Olá " + nome,
				"Título da Mensagem", JOptionPane.INFORMATION_MESSAGE);

	}

}
