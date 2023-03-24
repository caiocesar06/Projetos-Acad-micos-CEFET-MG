public class Movel {
    protected int numeroRodas;
    protected String fabricante;
    protected int anoFabricacao;
    private int velocidade;

    public Movel(int numeroRodas, String fabricante, int anoFabricacao, int velocidade) {
        if(numeroRodas > 0 &&
           !fabricante.equals("") && !fabricante.equals(null) &&
           anoFabricacao > 0) {
            this.numeroRodas = numeroRodas;
            this.fabricante = fabricante;
            this.anoFabricacao = anoFabricacao;
            setVelocidade(velocidade);
        }
    }

    public int getVelocidade() {
        return this.velocidade;
    }

    public void setVelocidade(int velocidade) {
        if(velocidade > 0) {
            this.velocidade = velocidade;
        } else {
            System.out.println("\nErro: Valor da velocidade invalido!\n");
        }
    }

    @Override
    public String toString() {
        return String.format("Numero de rodas: %d\nFabricante: %s\nAno de fabricacao: %d\nVelocidade: %d", this.numeroRodas, this.fabricante, this.anoFabricacao, getVelocidade());
    }
}