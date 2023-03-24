package Questão2;

public class MyClass {
    public static void main(String[] args) {
        try{
            Conta minhaConta = new Conta();
            minhaConta.deposita(100);
            minhaConta.setLimite(100);
            minhaConta.saca(1000); 
        } catch (ContaExcecao e) {
            e.printStackTrace();
        }
    }
}
