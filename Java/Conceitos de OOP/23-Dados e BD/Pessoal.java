
public abstract class Pessoal {
    String cargo;
    int matricula;
    String nome, email, senha;

    public Pessoal(String cargo, int matricula, String nome, String email, String senha) {
        this.cargo = cargo;
        this.matricula = matricula;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    @Override
    public String toString() {
        return  cargo + ";" + matricula + ";" + nome+ ";" +  email + ";"+ senha +";";
    }
}

class Aluno extends Pessoal {
    String turma;

    public Aluno(String cargo, int matricula, String nome, String email, String senha, String turma) {
        super(cargo, matricula, nome, email, senha);
        this.turma = turma;
    }

    @Override
    public String toString() {
        return super.toString() + turma + ";"; // ; pois imprime o campo setor da tabela como nullo.
    }
}

class Administrativo extends Pessoal {
    String setor;

    public Administrativo(String cargo, int matricula, String nome, String email, String senha, String setor) {
        super(cargo, matricula, nome, email, senha);
        this.setor = setor;
    }

    @Override
    public String toString() {
        return super.toString() + ";" + setor ; // ; para deixar o campo turma vazio.
    }
}

class Professor extends Pessoal {

    public Professor(String cargo, int matricula, String nome, String email, String senha) {
        super(cargo, matricula, nome, email, senha);        
    }

    @Override
    public String toString() {
        return super.toString() + ";" ; // ; para deixar o campo turma e setor vazios.
    }
}
