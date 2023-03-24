public class Grao extends Alimento {
    private float peso;

    public Grao(String dataDeValidade, String tipo, float peso) {
        super(dataDeValidade, tipo);
        this.peso = peso;
    }

    @Override
    public String toString() { 
        return super.toString() + getClass().getName() + " [peso=" + this.peso + "] ";
    }
}
