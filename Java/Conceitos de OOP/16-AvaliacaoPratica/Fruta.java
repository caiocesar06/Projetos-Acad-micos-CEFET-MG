public class Fruta extends Alimento{
    private double preco;

    public Fruta(String dataDeValidade, String tipo, double preco) {
        super(dataDeValidade, tipo);
        this.preco = preco;
    }

    @Override
    public String toString() { 
        return super.toString() + getClass().getName() + " [preco=" + this.preco + "] ";
    }
}
