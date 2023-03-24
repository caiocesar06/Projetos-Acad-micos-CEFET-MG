import java.util.Iterator;

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
    
    @Override
    public Iterator<T> iterator() {
        return new IteratorLista<T>(this.primeiro);
    }

    @Override
    public String toString() {
        String saida = "";
        No<T> atual = this.primeiro;
        while (atual != null) {
            saida += atual.getDado() + "  |-->  ";
            atual = atual.getProximo();
        }
        return saida;
    }
}
