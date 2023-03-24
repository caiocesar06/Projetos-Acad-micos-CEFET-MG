
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ConexaoDao {

	private Connection con;
	private String nomeJDBC;
	private String nomeUser;
	private String password;

	public ConexaoDao() {
		nomeJDBC = "jdbc:mysql://localhost/bd_pessoal";
		nomeUser = "root";
		password = "";
	}

	public ArrayList<Pessoal> addPessoall() {
		ArrayList<Pessoal> lista = new ArrayList<Pessoal>();
		try {
			Connection con = DriverManager.getConnection(nomeJDBC, nomeUser, password);
			Statement st = con.createStatement();
			st.executeUpdate("USE " + "bd_pessoal");
			ResultSet rs = st.executeQuery("Select * From pessoal;");
			while(rs.next()) {
				Pessoal pessoa = new Pessoal(rs.getInt("matricula"), rs.getString("nome"), rs.getString("email"), rs.getString("senha"), rs.getString("cargo"), rs.getString("turma"), rs.getString("setor"));
				lista.add(pessoa);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

	public boolean abreConexao() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(nomeJDBC, nomeUser, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public void fechaConexao() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
