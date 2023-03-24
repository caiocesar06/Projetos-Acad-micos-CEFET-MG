public class FuncionarioTurma extends Funcionario {
    private String turma;

    public FuncionarioTurma(int id, String nome, String email, String senha, String cargo, String turma) {
        super(id, nome, email, senha, cargo);
        this.turma = turma;
    }

    public String getTurma() {
        return this.turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }
    
    @Override
    public String toString() {
        return String.format("Id: %d  -  Nome: %s  -  Email: %s  -  Senha: %s  -  Cargo: %s  -  Turma: %s", getId(), getNome(), getEmail(), imprimirSenha(), getCargo(), getTurma());
    }
}