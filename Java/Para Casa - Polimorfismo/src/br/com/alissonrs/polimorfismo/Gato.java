package br.com.alissonrs.polimorfismo;

public class Gato extends Mamifero {
    
    @Override
    public void mamar() {
        System.out.println("MIAU! Chuc, chuc");
    }

    @Override
    public void emitirSom() {
        System.out.println("MIAAAAAAAAAU!");
    }
}
