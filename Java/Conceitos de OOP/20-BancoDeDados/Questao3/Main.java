package Questao3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Main {

    public static void main(String[] args) {
        new Main();
    }

    public Main () {
        String nameJDBC = "jdbc:mysql://localhost";
        String option = "?userTimezone=true&serverTimezone=UTC";
        String nameUser = "root";
        String password = "";

        try (PrintWriter pw = new PrintWriter(new File("Questao3/Musics.txt"))) {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(nameJDBC+option, nameUser, password);

            Statement st = con.createStatement();
            st.executeUpdate("USE "+ "discdb");

            String order = "SELECT musica.Titulo, artista.Nome FROM artista JOIN disco ON disco.CodArt = artista.CodArt JOIN faixa ON faixa.CodDisco = disco.CodDisco JOIN musica ON musica.CodMus = faixa.CodMus;";
            ResultSet rs = st.executeQuery(order);

            ResultSetMetaData rsmd = rs.getMetaData();

            int columsNumber = rsmd.getColumnCount();

            while(rs.next()) {
                for(int col = 1; col <= columsNumber; col++) {
                    pw.print(rsmd.getColumnLabel(col) + ": ");
                    pw.println(rs.getString(col));
                }
            }
            st.close();
            con.close();
        } catch (ClassNotFoundException | SQLException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}