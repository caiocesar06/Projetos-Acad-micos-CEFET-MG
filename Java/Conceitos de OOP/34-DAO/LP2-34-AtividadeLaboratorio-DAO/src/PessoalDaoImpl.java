import java.util.ArrayList;

public class PessoalDaoImpl implements PessoalDao {

    private ArrayList<Pessoal> pessoal;

    public PessoalDaoImpl() {
        ConexaoDao con = new ConexaoDao();
        con.abreConexao();
        pessoal = con.addPessoall();
        con.fechaConexao();

        for (Pessoal p : pessoal) {
            System.out.println(p);
        }
    }

    @Override
    public ArrayList<Pessoal> getAllPessoal() {
        return pessoal;
    }

    @Override
    public Pessoal getPessoa(int matricula) {
        return pessoal.get(matricula);        
    }

    @Override
    public void updatePessoal(Pessoal pessoa) {
        pessoal.get(pessoa.getMatricula()).setNome(pessoa.getNome());
        pessoal.get(pessoa.getMatricula()).setEmail(pessoa.getEmail());
        pessoal.get(pessoa.getMatricula()).setSenha(pessoa.getSenha());
        pessoal.get(pessoa.getMatricula()).setCargo(pessoa.getCargo());
        pessoal.get(pessoa.getMatricula()).setTurma(pessoa.getTurma());
        pessoal.get(pessoa.getMatricula()).setSetor(pessoa.getSetor());
        System.out.println("Pessoa: Matricula " + pessoa.getMatricula() + ", updated");
    }

    @Override
    public void deletePessoal(Pessoal pessoa) {
        pessoal.remove(pessoa.getMatricula());
        System.out.println("Pessoa: Matricula " + pessoa.getMatricula() + ", deleted");    
    }

    @Override
    public void addPessoa(Pessoal pessoa) {
        pessoal.add(pessoa);
        System.out.println("Pessoa: Matricula " + pessoa.getMatricula() + ", added");        
    }
}