package Questao2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {
        new Main();
    }

    public Main () {
        String nameJDBC = "jdbc:mysql://localhost";
        String option = "?userTimezone=true&serverTimezone=UTC";
        String nameUser = "root";
        String password = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(nameJDBC+option, nameUser, password);

            Statement st = con.createStatement();
            st.executeUpdate("USE "+ "discdb");

            String order = "SELECT musica.Titulo, artista.Nome FROM artista JOIN disco ON disco.CodArt = artista.CodArt JOIN faixa ON faixa.CodDisco = disco.CodDisco JOIN musica ON musica.CodMus = faixa.CodMus;";
            ResultSet rs = st.executeQuery(order);

            ResultSetMetaData rsmd = rs.getMetaData();

            int columsNumber = rsmd.getColumnCount();
            int rowsNumber = 1;

            while(rs.next()) {
                System.out.println("REGISTRO: " + rowsNumber);

                for(int col = 1; col <= columsNumber; col++) {
                    System.out.print(rsmd.getColumnLabel(col) + ": ");
                    System.out.println(rs.getString(col));
                }
                rowsNumber++;
            }
            st.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}