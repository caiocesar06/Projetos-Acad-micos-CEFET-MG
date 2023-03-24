public class FuncionarioTurma extends Funcionario {
    
    protected String turma;

    public FuncionarioTurma(String cargo, int matricula, String nome, String email, String senha, String turma) {
        super(cargo, matricula, nome, email, senha);
        this.turma = turma;
    }

    @Override
    public String toString() {
        return "FuncionarioTurma [cargo=" + cargo + ", email=" + email + ", matricula=" + matricula + ", nome=" + nome
                + ", senha=" + senha + ", turma=" + turma + "]";
    }
}

