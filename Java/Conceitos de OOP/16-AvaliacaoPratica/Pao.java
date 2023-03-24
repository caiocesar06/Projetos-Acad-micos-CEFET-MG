public class Pao extends Alimento {
    protected boolean contemGlutem;

    public Pao(String dataDeValidade, String tipo, boolean contemGlutem) {
        super(dataDeValidade, tipo);
        this.contemGlutem = contemGlutem;
    }

    @Override
    public String toString() { 
        return super.toString() + getClass().getName() + " [contemGlutem=" + this.contemGlutem + "] ";
    }
}
