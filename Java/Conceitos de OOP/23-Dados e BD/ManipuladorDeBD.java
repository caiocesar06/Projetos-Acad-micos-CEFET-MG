import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.List;

public class ManipuladorDeBD {

    public ManipuladorDeBD(List<Pessoal> lista) {
        String nomeJDBC = "jdbc:mysql://localhost/recursoshumanos";
        String opcao = "?userTimezone=true&serverTimezone=UTC";
        String usuario = "root";
        String senha = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(nomeJDBC+opcao, usuario, senha);

            Statement st = con.createStatement();
            st.executeQuery("USE recursoshumanos");
            insertDatas(lista, st);
            closeBD(con, st);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertDatas(List<Pessoal> lista, Statement st) {
        try {
            for(Pessoal p : lista) {
                if(p instanceof Administrativo) {
                    st.executeUpdate("INSERT INTO pessoal (cargo, matricula, nome, email, senha, setor) VALUES ('" + p.cargo + "', '" + p.matricula + "', '" + p.nome + "', '" + p.email + "', '" + p.senha + "', '" + ((Administrativo)p).setor + "')");
                } else if(p instanceof Aluno) {
                    st.executeUpdate("INSERT INTO pessoal (cargo, matricula, nome, email, senha, turma) VALUES ('" + p.cargo + "', '" + p.matricula + "', '" + p.nome + "', '" + p.email + "', '" + p.senha + "', '" + ((Aluno)p).turma + "')");
                } else {
                    st.executeUpdate("INSERT INTO pessoal (cargo, matricula, nome, email, senha) VALUES ('" + p.cargo + "', '" + p.matricula + "', '" + p.nome + "', '" + p.email + "', '" + p.senha + "')");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeBD(Connection con, Statement st) {
        try{
            st.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
