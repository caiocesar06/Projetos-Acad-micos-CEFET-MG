import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import java.io.File;
import java.io.PrintWriter;

import java.util.ArrayList;

public class DatabaseManager {
    
    public ArrayList<Funcionario> listaFuncionarios;

    public DatabaseManager() {
        listaFuncionarios = this.converSql2Csv();
    }

    private ArrayList<Funcionario> converSql2Csv() {
        String nomeJDBC = "jdbc:mysql://localhost/recursoshumanos";
        String opcao = "?userTimezone=true&serverTimezone=UTC";
        String usuario = "root";
        String senha = "";

        ArrayList<Funcionario> lista = new ArrayList<Funcionario>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(nomeJDBC + opcao, usuario, senha);

            Statement st = con.createStatement();
            st.executeUpdate("USE "+ "recursoshumanos");

            String order = "SELECT * FROM `pessoal`;";
            ResultSet rs = st.executeQuery(order);

            ResultSetMetaData rsmd = rs.getMetaData();

            int columsNumber = rsmd.getColumnCount();

            String linha = "";
            while(rs.next()) {
                for(int col = 1; col <= columsNumber; col++) {
                    linha += rs.getString(col) + ";";
                }
                lista.add(this.inserirFuncionarios(linha));
                linha = "";
            }
            
            st.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    private Funcionario inserirFuncionarios(String linha) {
        String[] dados = linha.split(";");
        if(dados.length == 5) {
            return new Funcionario(dados[0], Integer.parseInt(dados[1]), dados[2], dados[3], dados[4]);
        } else if(dados.length == 6) {
            return new FuncionarioTurma(dados[0], Integer.parseInt(dados[1]), dados[2], dados[3], dados[4], dados[5]);
        } else {
            return new FuncionarioSetor(dados[0], Integer.parseInt(dados[1]), dados[2], dados[3], dados[4], dados[6]);
        }
    }

    public void writeToCsv() {
        try (PrintWriter pw = new PrintWriter(new File("./src/tabela.csv"))) {
            pw.println("cargo;matrícula;nome;email;senha;turma;setor");
            for(Funcionario f : listaFuncionarios) {
                pw.println(f);
            }
        } catch (Exception e) {
            System.err.println("Error writing to CSV: " + e.getMessage());
        }
    }
}
