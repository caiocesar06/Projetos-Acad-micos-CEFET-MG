public class Leite extends Alimento {
    private String fabricante;

    public Leite(String dataDeValidade, String tipo, String fabricante) {
        super(dataDeValidade, tipo);
        this.fabricante = fabricante;
    }

    @Override
    public String toString() { 
        return super.toString() + getClass().getName() + " [fabricante=" + this.fabricante + "] ";
    }
}
