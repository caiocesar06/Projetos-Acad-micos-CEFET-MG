public class Carga extends Movel {
    private int volumeMaximo;
    private int pesoMaximo;
    
    public Carga(int numeroRodas, String fabricante, int anoFabricacao, int velocidade, int volumeMaximo, int pesoMaximo) {
        super(numeroRodas, fabricante, anoFabricacao, velocidade);
        setVolumeMax(volumeMaximo);
        setPesoMax(pesoMaximo);
        
    }

    public int getVolumeMax() {
        return this.volumeMaximo;
    }

    public int getPesoMax() {
        return this.pesoMaximo;
    }

    public void setVolumeMax(int volumeMaximo) {
        if(volumeMaximo > 0) {
            this.volumeMaximo = volumeMaximo;
        } else {
            System.out.println("\nErro: Valor do volume maximo invalido!\n");
        }
    }

    public void setPesoMax(int pesoMaximo) {
        if(pesoMaximo > 0) {
               this.pesoMaximo = pesoMaximo;
           } else {
               System.out.println("\nErro: Numero do peso maximo invalido!\n");
           }
    }

    @Override
    public String toString() {
        return String.format("%s\nVolume maximo: %d\nPeso maximo: %d", super.toString(), getVolumeMax(), getPesoMax());
    }
}
