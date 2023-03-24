package pong;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

public class JogoPainel extends JPanel implements Runnable {
	// Tamanho da janela - tamanho das bordas (640-18 = 625)
	public static final int LARGURA = Jogo.LARGURA - 18;
	// Tamanho da janela - tamanho das bordas (480-38 = 445)
	public static final int ALTURA = Jogo.ALTURA - 38;
	private Thread animacao;

	private int tempoEspera = 10;
	private boolean jogando = false;

	// Define informa��es da janela.
	public JogoPainel() {
		// cor de fundo.
		setBackground(Color.BLACK);
		setFocusable(true);

		Movel.getInstance().setParametros(new Dimension(30, 30), 100, 300, 1, -1, Color.RED);

	}

	// Controle de in�cio do jogo.
	public void addNotify() {
		super.addNotify();
		iniciarJogo();
	}

	// Fun��o que da start nas fun��es de in�cio do jogo
	private void iniciarJogo() {
		if (animacao == null || !jogando) {
			animacao = new Thread(this);
			animacao.start();
		}
	}

	@Override
	public void run() {
		jogando = true;
		/*
		 * Loop do jogo. Aqui as coisas acontecem.
		 */
		while (jogando) {
			/*
			 * Coloque aqui todas as a��es que queira que sejam executadas a cada loop do
			 * jogo
			 */
			Movel.getInstance().mover();

			repaint();
			/* fim a��es para testes */
			try {
				Thread.sleep(tempoEspera);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.exit(0);
	}

	/* Fun��o que desenha o fundo do painel . */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Movel.getInstance().paintComponent(g);
	}
}

class Movel {

	private static Movel movel;

	Dimension dimension;
	private int x, y, velX, velY;
	private Color cor;

	private Movel() {
	}

	public static Movel getInstance() {
		if (movel == null)
			movel = new Movel();
		return movel;
	}

	public boolean colidiu(Movel bola2) {

		double dist = Math.sqrt((x - bola2.x) * (x - bola2.x) + (y - bola2.y) * (y - bola2.y));

		if (dist < bola2.dimension.height) {
			return true;
		}
		return false;
	}

	public void mover() {
		// Bora quebra um pouco a cabe�a.

		if (x <= 0) {
			velX *= -1;
		} else if (x >= JogoPainel.LARGURA - dimension.width / 2) {
			velX *= -1;
		}

		if (y <= 0) {
			velY *= -1;
		} else if (y >= JogoPainel.ALTURA - dimension.height / 2) {
			velY *= -1;
		}

		x += velX;
		y -= velY;

	}

	/**
	 * Método set para devinir todos os valores do móvel.
	 * 
	 * @param dimension
	 *                  - dimensões largura e altura do móvel. null gera valor
	 *                  aleatorio
	 * @param x
	 *                  - Posição x do móvel. null gera valor aleatorio
	 * @param y
	 *                  - Posição y do móvel. null gera valor aleatorio
	 * @param velX
	 *                  - Velocidade x do móvel. null gera valor aleatorio
	 * @param velY
	 *                  - Velocidade y do móvel. null gera valor aleatorio
	 * @param cor
	 *                  - Cor do móvel. null gera valor aleatorio
	 */
	public void setParametros(Dimension dimension, Integer x, Integer y, Integer velX, Integer velY, Color cor) {
		Random rand = new Random();
		this.dimension = (dimension != null ? dimension
				: new Dimension(rand.nextInt(JogoPainel.LARGURA / 10), rand.nextInt(JogoPainel.ALTURA / 10)));
		this.x = (x != null ? x : rand.nextInt(JogoPainel.LARGURA));
		this.y = (y != null ? y : rand.nextInt(JogoPainel.ALTURA));
		this.velX = (velX != null ? velX : rand.nextInt(10));
		this.velY = (velY != null ? velY : rand.nextInt(10));
		this.cor = (cor != null ? cor : new Color(rand.nextFloat(), rand.nextFloat(), rand.nextFloat()));
	}

	public void paintComponent(Graphics g) {
		// Define a cor
		g.setColor(cor);
		// Pinta o circulo.
		g.fillOval(x, y, dimension.width, dimension.height);
		g.setColor(Color.WHITE);
		g.drawOval(x, y, dimension.width, dimension.height);

	}

	@Override
	public String toString() {
		return "Volores do móvel " + x + " - " + y;
	}

}
