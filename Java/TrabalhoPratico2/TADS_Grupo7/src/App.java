import Operações.Operation;
import TADs.Lista.Lista;
import TADs.Fila.Fila;

//Implementação das TADs de forma prática

public class App {
    public static void main(String[] args) throws Exception {
        new App();
    }

    public App(){
        // Problema 1: Simulação de uma fila de banco

        System.out.println("==========================================");
        System.out.println("Problema 1: Simulação de uma fila de banco");

        // Criação da fila
        Fila<Object> fila = new Fila<>();
        System.out.println("Fila criada");

        // Adição de elementos
        fila.insert("João");
        fila.insert("Maria");
        fila.insert("José");
        fila.insert("Pedro");
        fila.insert("Ana");
        fila.insert("Paulo");
        fila.insert("Carlos");
        fila.insert("Marcos");
        System.out.println("==========================================");
        System.out.println("Elementos adicionados");
        System.out.println("");

        // Impressão da fila
        System.out.println(fila);
        System.out.println("==========================================");

        // Remoção de elementos
        fila.remove(); //João foi atendido
        fila.remove(); //Maria foi atendida
        
        System.out.println("João e Maria foram atendidos.");
        System.out.println("");

        // Impressão da fila
        System.out.println(fila);

        System.out.println("==========================================");
        System.out.println("Testes Extras:");

        //Teste copiando para um array
        Object[] array = fila.copy();
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

        //Teste de cópia de fila
        Fila<Object> fila2 = fila.clone();
        System.out.println(fila2);

        //teste equals
        System.out.println(fila.equals(fila2));

        System.out.println("==========================================");
        System.out.println("");

        // Problema 2: Simulação de uma lista de compras

        System.out.println("==========================================");

        System.out.println("Problema 2: Simulação de uma lista de compras");

        // Criação da lista
        Lista<Object> lista = new Lista<>();
        System.out.println("Lista criada");

        // Adição de elementos
        lista.add("Arroz");
        lista.add("Feijão");
        lista.add("Macarrão");
        lista.add("Carne");
        lista.add("Frango");
        lista.add("Batata");
        lista.add("Cenoura");
        lista.add("Alface");
        lista.add("Tomate");
        lista.add("Cebola");
        lista.add("Pimentão");

        System.out.println("==========================================");
        System.out.println("Elementos adicionados");
        System.out.println(lista);
        System.out.println("==========================================");
        lista.remove("Alface");
        System.out.println("Alface foi removida");
        lista.remove("Cebola");
        System.out.println("Cebola foi removida");
        System.out.println("");
        System.out.println(lista);
        System.out.println("==========================================");
        System.out.println("Ordenando a lista de compras");
        System.out.println("");
        lista.sort();
        System.out.println(lista);
        System.out.println("==========================================");
        System.out.println("Testes Extras:");

        //Teste copiando para um array
        Object[] array2 = lista.copy();
        for (int i = 0; i < array2.length; i++) {
            System.out.println(array2[i]);
        }

        //Teste de cópia de lista
        Lista<Object> lista2 = lista.clone();
        System.out.println(lista2);

        //teste equals
        System.out.println(lista.equals(lista2));

        System.out.println("==========================================");
        System.out.println("Testes de operações com conjuntos");
        System.out.println("União fila1 e lista2 (Utilizando Object):");
            for(Object obj: Operation.union(fila.toArray(), lista2.toArray())){
                System.out.print(obj + " | ");
            }
        System.out.println("");
        System.out.println("Interseção fila1 e lista2 (Utilizando Object):");
            for(Object obj: Operation.intersection(fila.toArray(), lista2.toArray())){
                System.out.print(obj + " | ");
            }
        System.out.println("");
        System.out.println("Verificar se Arroz está em fila1 ou lista2 (Utilizando Object):");
        System.out.print("Arroz está em fila1? ");
            System.out.println(Operation.isOn("Arroz", fila.toArray()));
        System.out.print("Arroz está em lista2? ");
            System.out.println(Operation.isOn("Arroz", lista2.toArray()));
            
    // Nessa parte, caso não houvesse uma opção já implementada de utilizar as 2 classes
    // poderíamos utilizar a função toArray() para converter a fila e a lista em arrays
    // Exemplo:
            
        //  System.out.println("União fila1 e lista2:");
        //  for(Object obj: Operation.union(fila, lista2)){
        //      System.out.print(obj + " | ");
        //  }
        //  System.out.println("");
        //  System.out.println("Interseção fila1 e lista2:");
        //  for(Object obj: Operation.intersection(fila, lista2)){
        //      System.out.print(obj + " | ");
        //  }
        //  System.out.println("");
        //  System.out.println("Verificar se Arroz está em fila1 ou lista2:");
        //  System.out.print("Arroz está em fila1? ");
        //  System.out.println(Operation.isOn("Arroz", fila));
        //  System.out.print("Arroz está em lista2? ");
        //  System.out.println(Operation.isOn("Arroz", lista2));
    }
}
