import Operações.Operation;
import TADs.Lista.Lista;
import TADs.Fila.Fila;

//classe com testes para as operações de conjuntos e TADs implementadas

public class test {

    public test(){
        /* Testes das operações */

            // Object[] args1 = {1, 2, 3};
            // Object[] args2 = {2, 3, 4, 5, 6, "Bom dia", 4.56};
            // System.out.println("Intersection: "); // Interseção
            // for(Object obj: Operation.intersection(args1, args2)){
            //     System.out.println(obj);
            // }
            // System.out.println("Union: ");  // União
            // for(Object obj: Operation.union(args1, args2)){
            //     System.out.println(obj);
            // }
            // System.out.println("Is 1 on args1? " + Operation.isOn(1, args1)); // Pertencimento
            // System.out.println("Is 1 on args2? " + Operation.isOn(1, args2));
            // System.out.println("Is 'Bom dia' on args2? " + Operation.isOn("Bom dia", args2));

        /* Testes iniciais */

        Lista<Object> l1 = new Lista<Object>();
        l1.add(1);
        l1.add(2);
        l1.add(3);
        l1.add(3.14);
        l1.add("Olá mundo!");
        
        Lista<Object> l2 = new Lista<Object>();
        l2.add(4);
        l2.add(2);
        l2.add("Olá mundo!");
        l2.add(6);
        l2.add(7);
        l2.add("Só mais um teste");
        l2.add(3.14);

        Fila<Object> f1 = new Fila<Object>();
        f1.insert(1);
        f1.insert(2);
        f1.insert(3);
        f1.insert(3.14);
        f1.insert("Olá mundo!");

        Fila<Object> f2 = new Fila<Object>();
        f2.insert(4);
        f2.insert(2);
        f2.insert("Olá mundo!");
        f2.insert(6);
        f2.insert(7);
        f2.insert("Só mais um teste");
        f2.insert(3.14);

        System.out.println("\n");
        System.out.println("Lista 1: " + l1);
        System.out.println("Lista 2: " + l2);
        System.out.println("Fila 1: " + f1);
        System.out.println("Fila 2: " + f2);
        System.out.println("");
        System.out.println("União l1 e l2 (Utilizando Object):");
            for(Object obj: Operation.union(l1.toArray(), l2.toArray())){
                System.out.print(obj + " | ");
            }
        System.out.println("\nUnião l1 e l2 (Utilizando Lista):");
            for(Object obj: Operation.union(l1, l2)){
                System.out.print(obj + " | ");
            }
        System.out.println("\n");
        System.out.println("União f1 e f2 (Utilizando Object):");
            for(Object obj: Operation.union(f1.toArray(), f2.toArray())){
                System.out.print(obj + " | ");
            }
        System.out.println("\nUnião f1 e f2 (Utilizando Lista):");
            for(Object obj: Operation.union(f1, f2)){
                System.out.print(obj + " | ");
            }
        System.out.println("\n");
        System.out.println("Intersecção l1 e l2 (Utilizando Object):");
            for(Object obj: Operation.intersection(l1.toArray(), l2.toArray())){
                System.out.print(obj + " | ");
            }
        System.out.println("\nIntersecção l1 e l2 (Utilizando Fila):");
            for(Object obj: Operation.intersection(l1, l2)){
                System.out.print(obj + " | ");
            }
        System.out.println("\n");
        System.out.println("Intersecção f1 e f2 (Utilizando Object):");
            for(Object obj: Operation.intersection(f1.toArray(), f2.toArray())){
                System.out.print(obj + " | ");
            }
        System.out.println("\nIntersecção f1 e f2 (Utilizando Fila):");
            for(Object obj: Operation.intersection(f1, f2)){
                System.out.print(obj + " | ");
            }
        System.out.println("\n\nOperação com Object");
        System.out.println("1 está em l1? " + Operation.isOn(1, l1.toArray()));
        System.out.println("1 está em l2? " + Operation.isOn(1, l2.toArray()));
        System.out.println("'Só mais um teste' está em l2? " + Operation.isOn("Só mais um teste", l2.toArray()));
        System.out.println("\nOperação com Lista");
        System.out.println("1 está em l1? " + Operation.isOn(1, l1));
        System.out.println("1 está em l2? " + Operation.isOn(1, l2));
        System.out.println("'Só mais um teste' está em l2? " + Operation.isOn("Só mais um teste", l2));
        System.out.println("\nOperação com Fila");
        System.out.println("1 está em f1? " + Operation.isOn(1, f1.toArray()));
        System.out.println("1 está em f2? " + Operation.isOn(1, f2.toArray()));
        System.out.println("'Só mais um teste' está em f2? " + Operation.isOn("Só mais um teste", f2.toArray()));

        System.out.println("");
        l1.sort();
        System.out.println("Lista 1 ordenada: " + l1);
        l2.sort();
        System.out.println("Lista 2 ordenada: " + l2);
        //Filas não possuem sort, pois são FIFO
    }

    public static void main(String[] args) {
        new test();
    }
}
