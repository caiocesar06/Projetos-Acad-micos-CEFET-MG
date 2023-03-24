package TADs.Lista;

import java.util.Iterator;

import TADs.Common.IteratorTAD;
import TADs.Common.No;

public class Lista<T> implements Iterable<T> {
    private No<T> primeiro;
    private No<T> ultimo;
    private int tamanho;

    public Lista() {
        this.primeiro = null;
        this.ultimo = null;
        this.tamanho = 0;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void add(T dado) {
        No<T> novoNo = new No<T>(dado);
        if (this.primeiro == null) {
            this.primeiro = this.ultimo = novoNo;
        } else {
            this.ultimo.setProximo(novoNo);
            novoNo.setAnterior(this.ultimo);
            this.ultimo = novoNo;
        }
        this.tamanho++;
    }

    public void add(T dado, int indice) {
        No<T> novoNo = new No<T>(dado);
        if (indice == 0) {
            novoNo.setProximo(this.primeiro);
            this.primeiro.setAnterior(novoNo);
            this.primeiro = novoNo;
        } else if (indice == this.tamanho) {
            this.ultimo.setProximo(novoNo);
            novoNo.setAnterior(this.ultimo);
            this.ultimo = novoNo;
        } else {
            No<T> noAtual = this.primeiro;
            for (int i = 0; i < indice; i++) {
                noAtual = noAtual.getProximo();
            }

            novoNo.setProximo(noAtual);
            novoNo.setAnterior(noAtual.getAnterior());
            noAtual.getAnterior().setProximo(novoNo);
            noAtual.setAnterior(novoNo);
        }
        this.tamanho++;
    }

    public void remove(int indice) {
        if (indice == 0) {
            this.primeiro = this.primeiro.getProximo();
            this.primeiro.setAnterior(null);
        } else if (indice == this.tamanho - 1) {
            this.ultimo = this.ultimo.getAnterior();
            this.ultimo.setProximo(null);
        } else {
            No<T> noAtual = this.primeiro;
            for (int i = 0; i < indice; i++) {
                noAtual = noAtual.getProximo();
            }
            noAtual.getAnterior().setProximo(noAtual.getProximo());
            noAtual.getProximo().setAnterior(noAtual.getAnterior());
        }
        this.tamanho--;
    }

    public void remove(T dado) {
        No<T> noAtual = this.primeiro;
        for (int i = 0; i < this.tamanho; i++) {
            if (noAtual.getDado().equals(dado)) {
                this.remove(i);
                break;
            }
            noAtual = noAtual.getProximo();
        }
    }

    public T get(int indice) {
        No<T> noAtual = this.primeiro;
        for (int i = 0; i < indice; i++) {
            noAtual = noAtual.getProximo();
        }
        return noAtual.getDado();
    }

    public void sort() {
        No<T> atual = this.primeiro;
        No<T> proximo = atual.getProximo();
        for (int i = 0; i < this.tamanho; i++) {
            for (int j = 0; j < this.tamanho - 1; j++) {
                if (atual.getDado().toString().compareTo(proximo.getDado().toString()) > 0) {
                    T aux = atual.getDado();
                    atual.setDado(proximo.getDado());
                    proximo.setDado(aux);
                }
                atual = atual.getProximo();
                proximo = proximo.getProximo();
            }
            atual = this.primeiro;
            proximo = atual.getProximo();
        }
    }

    // Implementações extras pedidas =============================================
    
    // Iterator
    @Override
    public Iterator<T> iterator() {
        return new IteratorTAD<T>(this.primeiro);
    }

    // toString para imprimir lista
    @Override
    public String toString() {
        String saida = "";
        No<T> atual = this.primeiro;
        while (atual != null) {
            saida += atual.getDado() + " | ";
            atual = atual.getProximo();
        }
        return saida;
    }


    //solução para utilizar como Object[]
    public Object[] toArray(){
        Object[] args = new Object[this.tamanho];
        No<T> atual = this.primeiro;
        for (int i = 0; i < this.tamanho; i++) {
            args[i] = atual.getDado();
            atual = atual.getProximo();
        }
        return args;
    }

    //copiar conteúdo de um array pra essa lista
    public void copy(T[] array){
        for (int i = 0; i < array.length; i++) {
            this.add(array[i]);
        }
    }

    //copiar conteúdo dessa lista para um array
    public Object[] copy(){
        Object[] array = new Object[this.tamanho];
        No<T> atual = this.primeiro;
        for (int i = 0; i < this.tamanho; i++) {
            array[i] = atual.getDado();
            atual = atual.getProximo();
        }
        return array;
    }

    //retorna uma cópia dessa lista
    @Override
    public Lista<T> clone(){
        Lista<T> clone = new Lista<T>();
        No<T> atual = this.primeiro;
        for (int i = 0; i < this.tamanho; i++) {
            clone.add(atual.getDado());
            atual = atual.getProximo();
        }
        return clone;
    }

    //equals
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
                                                
        @SuppressWarnings("unchecked")
        final Lista<T> other = (Lista<T>) obj;
        if (this.tamanho != other.tamanho) {
            return false;
        }
        No<T> atual = this.primeiro;
        No<T> atualOther = other.primeiro;
        for (int i = 0; i < this.tamanho; i++) {
            if (!atual.getDado().equals(atualOther.getDado())) {
                return false;
            }
            atual = atual.getProximo();
            atualOther = atualOther.getProximo();
        }
        return true;
    }
}
