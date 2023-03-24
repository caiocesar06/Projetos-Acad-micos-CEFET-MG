package Questão2;

public class ContaExcecao extends Exception {

    public ContaExcecao(int valor, int limite) {
        super("O valor a sacar R$" + valor + ",00 não pode exceder o limite de R$" + limite + ",00.");
    }
}