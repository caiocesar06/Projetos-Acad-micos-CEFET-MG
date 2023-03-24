public class FuncionarioSetor extends Funcionario {
    private String setor;

    public FuncionarioSetor(int id, String nome, String email, String senha, String cargo, String setor) {
        super(id, nome, email, senha, cargo);
        this.setor = setor;
    }

    public String getSetor() {
        return this.setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }
    
    @Override
    public String toString() {
        return String.format("Id: %d  -  Nome: %s  -  Email: %s   - Senha: %s  -  Cargo: %s  -  Setor: %s", getId(), getNome(), getEmail(), imprimirSenha(), getCargo(), getSetor());
    }
}
