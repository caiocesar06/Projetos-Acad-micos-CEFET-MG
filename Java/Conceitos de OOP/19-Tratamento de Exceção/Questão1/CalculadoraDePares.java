package Questão1;

public class CalculadoraDePares extends Throwable {
    
    public int somar(int x, int y) throws NaoParException {
        if(x % 2 != 0) throw new NaoParException(x);
        if(y % 2 != 0) throw new NaoParException(y);
        return x + y;
    }

    public int subtrair(int x, int y) throws NaoParException {
        if(x % 2 != 0) throw new NaoParException(x);
        if(y % 2 != 0) throw new NaoParException(y);
        return x - y;
    }

    public int multiplicar(int x, int y) throws NaoParException {
        if(x % 2 != 0) throw new NaoParException(x);
        if(y % 2 != 0) throw new NaoParException(y);
        return x * y;
    }

    public int dividir(int x, int y) throws NaoParException {
        if(x % 2 != 0) throw new NaoParException(x);
        if(y % 2 != 0) throw new NaoParException(y);
        return x / y;
    }
}