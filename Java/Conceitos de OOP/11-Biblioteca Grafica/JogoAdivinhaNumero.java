import java.util.Random;

import javax.swing.JOptionPane;

public class JogoAdivinhaNumero {

    public JogoAdivinhaNumero() {
        int palpite = 0,
            sorteado,
            tentativas = 0;
        
        Random geradorDeAleatorios = new Random();
        sorteado = geradorDeAleatorios.nextInt(1000) + 1;

        JOptionPane.showMessageDialog(null, "Número entre 1 e 1000 sorteado!", "Números sorteados", JOptionPane.INFORMATION_MESSAGE);

        do {
            JOptionPane.showMessageDialog(null, "Número de tentativas: " + tentativas, "Tentativas", JOptionPane.INFORMATION_MESSAGE);

            palpite = Integer.parseInt(JOptionPane.showInputDialog("Qual seu palpite: "));

            tentativas++;

            dica(palpite, sorteado, tentativas);
        } while (palpite != sorteado);
    }

    public void dica(int palpite, int numero, int tentativas) {
        if (palpite > numero) {
            JOptionPane.showMessageDialog(null, "Seu palpite é maior que o numero sorteado.", "Dica", JOptionPane.INFORMATION_MESSAGE);
        } else {
            if (palpite < numero) {
                JOptionPane.showMessageDialog(null, "Seu palpite é menor que o numero sorteado.", "Dica", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Parabéns, você acertou! O número era " + numero, "Dica", JOptionPane.INFORMATION_MESSAGE);
                JOptionPane.showMessageDialog(null, "Você tentou " + tentativas + " vezes antes de acertar!", "Dica", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        JogoAdivinhaNumero jogo = new JogoAdivinhaNumero();
    }
}