import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class GerenciadorDeJanelas {

    private ArrayList<Funcionario> funcionarios;
    private int indice;

    private JLabel lblCargo;
    private JLabel lblMatricula;
    private JLabel lblNome;
    private JLabel lblEmail;
    private JLabel lblSenha;
    private JLabel lblTurma;
    private JLabel lblSetor;

    private JTextField txtCargo;
    private JTextField txtMatricula;
    private JTextField txtNome;
    private JTextField txtEmail;
    private JTextField txtSenha;
    private JTextField txtTurma;
    private JTextField txtSetor;

    public static void main(String[] args) throws Exception {
        new GerenciadorDeJanelas();
    }

    public GerenciadorDeJanelas() {
        funcionarios = initArrayList("./src/tabela.csv");
        TelaLogin();
    }

    public void TelaLogin() {
        String email = JOptionPane.showInputDialog("Email: ");
        String senha = JOptionPane.showInputDialog("Senha: ");
        for (Funcionario funcionario : funcionarios) {
            if (
                (funcionario.email.equals(email) && funcionario.senha.equals(senha))||
                (email.equals("admin") && senha.equals("admin"))
               ) {
                JOptionPane.showMessageDialog(null, "Login realizado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                indice = funcionarios.indexOf(funcionario);
                TelaPrincipal();
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Login ou senha incorretos!", "Erro", JOptionPane.ERROR_MESSAGE);
                TelaLogin();
            }
        }
    }

    public void TelaPrincipal() {
        JFrame frame = new JFrame("Tela Principal");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        lblCargo = new JLabel("Cargo: ");
        frame.add(lblCargo, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        txtCargo = new JTextField(funcionarios.get(indice).cargo);
        txtCargo.setEditable(false);
        frame.add(txtCargo, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        lblMatricula = new JLabel("Matricula: ");
        frame.add(lblMatricula, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        txtMatricula = new JTextField(funcionarios.get(indice).matricula);
        txtMatricula.setEditable(false);
        frame.add(txtMatricula, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        lblNome = new JLabel("Nome: ");
        frame.add(lblNome, gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        txtNome = new JTextField(funcionarios.get(indice).nome);
        txtNome.setEditable(false);
        frame.add(txtNome, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        lblEmail = new JLabel("Email: ");
        frame.add(lblEmail, gbc);
        gbc.gridx = 1;
        gbc.gridy = 3;
        txtEmail = new JTextField(funcionarios.get(indice).email);
        txtEmail.setEditable(false);
        frame.add(txtEmail, gbc);
        gbc.gridx = 0;
        gbc.gridy = 4;
        lblSenha = new JLabel("Senha: ");
        frame.add(lblSenha, gbc);
        gbc.gridx = 1;
        gbc.gridy = 4;
        txtSenha = new JTextField(funcionarios.get(indice).senha);
        txtSenha.setEditable(false);
        frame.add(txtSenha, gbc);
        gbc.gridx = 0;
        gbc.gridy = 5;
        if(funcionarios.get(indice) instanceof FuncionarioTurma) {
            lblTurma = new JLabel("Turma: ");
            frame.add(lblTurma, gbc);
            gbc.gridx = 1;
            gbc.gridy = 5;
            txtTurma = new JTextField(((FuncionarioTurma) funcionarios.get(indice)).turma);
            txtTurma.setEditable(false);
            frame.add(txtTurma, gbc);
        } else if(funcionarios.get(indice) instanceof FuncionarioSetor) {
            lblSetor = new JLabel("Setor: ");
            frame.add(lblSetor, gbc);
            gbc.gridx = 1;
            gbc.gridy = 5;
            txtSetor = new JTextField(((FuncionarioSetor) funcionarios.get(indice)).setor);
            txtSetor.setEditable(false);
            frame.add(txtSetor, gbc);
        }
        gbc.gridx = 0;
        gbc.gridy = 6;
        JButton btnEditar = new JButton("Editar");
        btnEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnEditar.setEnabled(false);
                txtCargo.setEditable(true);
                txtMatricula.setEditable(true);
                txtNome.setEditable(true);
                txtEmail.setEditable(true);
                txtSenha.setEditable(true);
                if(funcionarios.get(indice) instanceof FuncionarioTurma) {
                    txtTurma.setEditable(true);
                } else if(funcionarios.get(indice) instanceof FuncionarioSetor) {
                    txtSetor.setEditable(true);
                }
            }
        });
        frame.add(btnEditar, gbc);
        gbc.gridx = 1;
        gbc.gridy = 6;
        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnEditar.setEnabled(true);
                funcionarios.get(indice).cargo = txtCargo.getText();
                funcionarios.get(indice).matricula = Integer.parseInt(txtMatricula.getText());
                funcionarios.get(indice).nome = txtNome.getText();
                funcionarios.get(indice).email = txtEmail.getText();
                funcionarios.get(indice).senha = txtSenha.getText();
                if(funcionarios.get(indice) instanceof FuncionarioTurma) {
                    ((FuncionarioTurma) funcionarios.get(indice)).turma = txtTurma.getText();
                } else if(funcionarios.get(indice) instanceof FuncionarioSetor) {
                    ((FuncionarioSetor) funcionarios.get(indice)).setor = txtSetor.getText();
                }
                JOptionPane.showMessageDialog(null, "Dados salvos com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        frame.add(btnSalvar, gbc);
        frame.setVisible(true);
    }

    public ArrayList<Funcionario> initArrayList(String nomeArquivo) {
        ArrayList<Funcionario> lista = new ArrayList<Funcionario>();
        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha = br.readLine();
            linha = br.readLine();
            while (linha != null) {
                String[] dados = linha.split(";");

                if (dados.length == 7) {
                    lista.add(new FuncionarioSetor(dados[0], Integer.parseInt(dados[1]), dados[2], dados[3], dados[4], dados[6]));

                } else if (dados.length == 6) {
                    lista.add(new FuncionarioTurma(dados[0], Integer.parseInt(dados[1]), dados[2], dados[3], dados[4], dados[5]));

                } else if (dados.length == 5) {
                    lista.add(new Funcionario(dados[0], Integer.parseInt(dados[1]), dados[2], dados[3], dados[4]));
                }
                linha = br.readLine();
            }
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
        }
        return lista;
    }
}