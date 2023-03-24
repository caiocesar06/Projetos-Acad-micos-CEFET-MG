package br.com.alissonrs.polimorfismo;

public class Cachorro extends Mamifero {
	
	private static int contar = 0;

	private int numeroRegistro = 0;

	public Cachorro() {
	}

	public Cachorro(String novoNome) {
		nome = novoNome;
		numeroRegistro = contar++;
	}

	@Override
	public void emitirSom() {
		System.out.println("Au! AU! AU! UUUUUUUUUUUUUUUUU!");
	}

	public void setNumeroRegistro(int numeroRegistro) {
		this.numeroRegistro = numeroRegistro;
	}

	public int getNumeroRegistro() {
		return numeroRegistro;
	}

	@Override
	public void mamar() {
		System.out.println("Chuc");
	}
}
