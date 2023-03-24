public class Esportivo extends Movel{
    private int cilindradas;
    private int numPassageiros;
    
    public Esportivo(int numeroRodas, String fabricante, int anoFabricacao,int velocidade, int cilindradas, int numPassageiros) {
        super(numeroRodas, fabricante, anoFabricacao, velocidade);
        setCilindradas(cilindradas);
        setNumPassageiros(numPassageiros);
    }

    public int getCilindradas() {
        return this.cilindradas;
    }

    public int getNumPassageiros() {
        return this.numPassageiros;
    }

    public void setCilindradas(int cilindradas) {
        if(cilindradas > 0) {
            this.cilindradas = cilindradas;
        } else {
            System.out.println("\nErro: Valor invalido!\n");
        }
    }

    public void setNumPassageiros(int numPassageiros) {
        if(numPassageiros == 1 ||
           numPassageiros == 2 ||
           numPassageiros == 3 ||
           numPassageiros == 4) {
               this.numPassageiros = numPassageiros;
           } else {
               System.out.println("\nErro: Numero de passageiros invalido!\n");
           }
    }

    @Override
    public String toString() {
        return String.format("%s\nCilindradas: %d\nNumero de passageiros: %d", super.toString(), getCilindradas(), getNumPassageiros());
    }
}