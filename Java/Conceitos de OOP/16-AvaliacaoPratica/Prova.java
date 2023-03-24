import java.util.ArrayList;

class Prova {

    public static void main(String[] args) {
        new Prova();
    }

    public Prova() {

        System.out.println("Controle de Alimentos");
        ArrayList<Alimento> lista = new ArrayList<Alimento>();

        lista.add(new Grao("25/12/2025", "Feijão", 500));
        lista.add(new Pao("20/07/2022", "Sovado", true));
        lista.add(new Fruta("25/07/2022", "Maça", 3.55));
        lista.add(new Fruta("25/07/2022", "Cenoura", 5.45));
        lista.add(new Leite("18/07/2022", "Sem lactose", "Itambé"));
        lista.add(new Leite("15/07/2022", "Desnatado", "Molico"));

        if (lista.size() >= 2) {
            if (lista.get(1) instanceof Pao) {
                Pao aux = (Pao) lista.get(1);
                String resultado = aux.contemGlutem ? " contem Gluten" :
                 " não contem Gluten";
                System.out.println("O pão " + aux.tipo + resultado);

            }
        }

        System.out.println("Lista de alimentos:");
        for (int i = 0; i < lista.size(); i++) {
            imprimeAliment(lista.get(i));
        }
    }

    private void imprimeAliment(Alimento alimento) {
        System.out.println(alimento);
    }

}
