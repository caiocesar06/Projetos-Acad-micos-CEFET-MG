package Questão2;

public class Conta extends Throwable {
    int saldo;
    int limite;

    public void deposita(int valor) {
        saldo += valor;
    }

    public void setLimite(int limite) {
        this.limite = limite;
    }

    public void saca(int valor) throws ContaExcecao {
        if(valor > limite) throw new ContaExcecao(valor, limite);
        saldo -= valor;
    }
}