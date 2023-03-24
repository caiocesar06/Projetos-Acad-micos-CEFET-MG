package Questão1;

public class NaoParException extends Exception {

    public NaoParException(int valor) {
        super("O valor " + valor + " não é par!");
    }
}
