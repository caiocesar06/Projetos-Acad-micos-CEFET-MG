package br.com.alissonrs.polimorfismo;

import java.util.ArrayList;

public class Zoologico {

	public static void main(String[] args) {
		
		ArrayList<Mamifero> animais;

		animais = new ArrayList<Mamifero>();

		animais.add(new Cachorro("Snoopy"));
		animais.add(new Vaca());
		animais.add(new Gato());

		for (Mamifero animal : animais) {
			animal.emitirSom();
			animal.mamar();
			System.out.println("");
		}
	}
}