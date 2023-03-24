import java.util.ArrayList;

public interface PessoalDao {
    
    public ArrayList<Pessoal> getAllPessoal();
    public Pessoal getPessoa(int matricula);
    public void updatePessoal(Pessoal pessoa);
    public void deletePessoal(Pessoal pessoa);
    public void addPessoa(Pessoal pessoa);

}
