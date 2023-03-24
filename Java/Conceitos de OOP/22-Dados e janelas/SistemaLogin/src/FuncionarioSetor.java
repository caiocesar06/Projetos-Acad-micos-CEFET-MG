public class FuncionarioSetor extends Funcionario {
    
    protected String setor;

    public FuncionarioSetor(String cargo, int matricula, String nome, String email, String senha, String setor) {
        super(cargo, matricula, nome, email, senha);
        this.setor = setor;
    }

    @Override
    public String toString() {
        return "FuncionarioSetor [cargo=" + cargo + ", email=" + email + ", matricula=" + matricula + ", nome=" + nome
                + ", senha=" + senha + ", setor=" + setor + "]";
    }
}
