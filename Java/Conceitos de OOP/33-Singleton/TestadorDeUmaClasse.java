class UmaClasse {
    private static UmaClasse umaClasse;
    private static int contador = 0;

    private UmaClasse() {
        contador++;
    }

    public static UmaClasse instancia() {
        if (umaClasse == null) {
            umaClasse = new UmaClasse();
        }
        return umaClasse;
    }

    public static int getContador() {
        return contador;
    }
}

public class TestadorDeUmaClasse {
    public static void main(String[] args) {
        for(int i = 0; i < 10; i++) {
            UmaClasse.instancia();
        }

        System.out.println("Total de instâncias criadas = " + UmaClasse.getContador());
    }
}