public class FuncionarioSetor extends Funcionario {
    
    protected String setor;

    public FuncionarioSetor(String cargo, int matricula, String nome, String email, String senha, String setor) {
        super(cargo, matricula, nome, email, senha);
        this.setor = setor;
    }

    @Override
    public String toString() {
        return cargo + ";" + matricula + ";" + nome + ";" + email + ";" + senha + ";;" + setor;
    }
}
