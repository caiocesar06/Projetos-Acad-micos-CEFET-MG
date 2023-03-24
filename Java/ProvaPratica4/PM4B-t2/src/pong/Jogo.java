package pong;

import javax.swing.JFrame;

public class Jogo {
	// Tamanho da janela
	public static final int LARGURA = 640;
	public static final int ALTURA = 480;

	public static void main(String args[]) {
		JogoPainel jogoPainel = new JogoPainel();
		JFrame jogo = new JFrame("Tutorial");
		jogo.add(jogoPainel);
		jogo.pack();
		jogo.setSize(LARGURA, ALTURA);
		jogo.setResizable(false);
		jogo.setVisible(true);
		jogo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
