package TADs.Fila;

import java.util.Iterator;

import TADs.Common.IteratorTAD;
import TADs.Common.No;

public class Fila<T> implements Iterable<T>{
    No<T> primeiro;
    No<T> ultimo;
    private int tamanho;

    public Fila(){
        this.primeiro = null;
        this.ultimo = null;
        tamanho = 0;
    }

    public int size(){
        return tamanho;
    }

    public void insert(T valor){
        No<T> novo = new No<T>(valor);
        //novo.setDado(valor);
        if(this.primeiro == null){
            this.primeiro = novo;
            this.ultimo = novo;
            novo.setProximo(null);
        }else{
            ultimo.setProximo(novo);
            novo.setProximo(null);
            this.ultimo = novo;
        }
        this.tamanho++;
    }

    public void check(){
        No<T> aux = this.primeiro;
        while(aux != null){
            System.out.println("Dados: " + aux.getDado());
            aux = aux.getProximo();
        }
    }

    public T remove(){
        No<T> aux = this.primeiro;
        if(this.primeiro == ultimo && this.primeiro != null){
            this.primeiro = null;
            ultimo = null;
        }else{
            this.primeiro = primeiro.getProximo();
        }
        this.tamanho--;
        return aux.getDado();
    }

    // Implementações extras pedidas =============================================

    // Iterator
    @Override
    public Iterator<T> iterator() {
        return new IteratorTAD<T>(this.primeiro);
    }

    // toString para imprimir a fila
    @Override
    public String toString() {
        String str = "";
        No<T> aux = this.primeiro;
        while(aux != null){
            str += aux.getDado() + " | ";
            aux = aux.getProximo();
        }
        return str;
    }

    //solução para utilizar como Object[]
    public Object[] toArray(){
        Object[] array = new Object[this.tamanho];
        No<T> aux = this.primeiro;
        int i = 0;
        while(aux != null){
            array[i] = aux.getDado();
            aux = aux.getProximo();
            i++;
        }
        return array;
    }

    //copiar conteúdo de um array para essa fila
    public void copy(T[] array){
        for (int i = 0; i < array.length; i++) {
            this.insert(array[i]);
        }
    }

    //copiar conteúdo dessa fila para um array
    public Object[] copy(){
        Object[] array = new Object[this.tamanho];
        No<T> aux = this.primeiro;
        int i = 0;
        while(aux != null){
            array[i] = aux.getDado();
            aux = aux.getProximo();
            i++;
        }
        return array;
    }

    //retorna uma cópia dessa fila
    @Override
    public Fila<T> clone(){
        Fila<T> clone = new Fila<T>();
        No<T> aux = this.primeiro;
        while(aux != null){
            clone.insert(aux.getDado());
            aux = aux.getProximo();
        }
        return clone;
    }

    //equals
    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(obj == this) return true;
        if(obj.getClass() != this.getClass()) return false;        
        @SuppressWarnings("unchecked")
        Fila<T> fila = (Fila<T>) obj;
        if(this.tamanho != fila.size()) return false;
        No<T> aux1 = this.primeiro;
        No<T> aux2 = fila.primeiro;
        while(aux1 != null){
            if(!aux1.getDado().equals(aux2.getDado())) return false;
            aux1 = aux1.getProximo();
            aux2 = aux2.getProximo();
        }
        return true;
    }

}