public class No<T> {
    private T dado;
    private No<T> proximo;
    private No<T> anterior;

    public No(T dado) {
        this.dado = dado;
        this.proximo = null;
        this.anterior = null;
    }

    public No(T dado, No<T> proximo, No<T> anterior) {
        this.dado = dado;
        this.proximo = proximo;
        this.anterior = anterior;
    }

    public T getDado() {
        return dado;
    }

    public void setDado(T elemento) {
        this.dado = elemento;
    }

    public No<T> getProximo() {
        return proximo;
    }

    public void setProximo(No<T> proximo) {
        this.proximo = proximo;
    }

    public No<T> getAnterior() {
        return anterior;
    }

    public void setAnterior(No<T> anterior) {
        this.anterior = anterior;
    }

    @Override
    public String toString() {
        return "No [dado=" + dado + "]";
    }
}
