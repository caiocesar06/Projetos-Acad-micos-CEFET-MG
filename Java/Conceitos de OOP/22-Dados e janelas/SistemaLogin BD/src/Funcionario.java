public class Funcionario {
    
    protected String cargo;
    protected int matricula;
    protected String nome;
    protected String email;
    protected String senha;

    public Funcionario(String cargo, int matricula, String nome, String email, String senha) {
        this.cargo = cargo;
        this.matricula = matricula;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Funcionario [cargo=" + cargo + ", email=" + email + ", matricula=" + matricula + ", nome=" + nome
                + ", senha=" + senha + "]";
    }
}
