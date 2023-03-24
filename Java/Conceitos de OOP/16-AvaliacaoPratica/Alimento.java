public abstract class Alimento {
    private String dataDeValidade;
    protected String tipo;

    public Alimento(String dataDeValidade, String tipo) {
        this.dataDeValidade = dataDeValidade;
        this.tipo = tipo;
    }

    public String toString() { 
        return "Alimento [dataDeValidade=" + this.dataDeValidade + ", tipo=" + this.tipo + "] ";
    }
}
