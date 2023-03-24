import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

// Classe com escutador externo
public class Cadastro extends JFrame {
	//Define componentes da janela.
	private JLabel jLabelNumero;
	private JLabel jLabelNome;
	private JLabel jLabelGrupo;

	protected JTextField jtextNumero;
	protected JTextField jtextNome;
	protected JTextField jtextGrupo;

	private JButton jbuttonBuscar;
	
	private ArrayList<Aluno> alunos = new ArrayList<Aluno>();
	
	public Cadastro(String titulo) {
		super(titulo);

		setLayout(new FlowLayout(FlowLayout.RIGHT));

		//Inicializa componentes da janela.
		jLabelNumero = new JLabel("Buscar");		
		jLabelNome = new JLabel("Nome");		
		jLabelGrupo = new JLabel("Grupo");
		
		jtextNumero = new JTextField("0", 10);
		jtextNome = new JTextField(10);
		jtextGrupo = new JTextField(10);

        jtextNome.setEditable(false);
        jtextGrupo.setEditable(false);

		jbuttonBuscar = new JButton("Buscar");
		jbuttonBuscar.setPreferredSize(new Dimension(180,18));
		
		//Adiciona componentes na janela.
		this.add(jLabelNumero);		
		this.add(jtextNumero);
		this.add(jbuttonBuscar);

		this.add(jLabelNome);		
		this.add(jtextNome);

		this.add(jLabelGrupo);
		this.add(jtextGrupo);
		
		//Cria o escutador
		Escutador handler = new Escutador();

		//Adiciona o escutador a cada botão.
		jbuttonBuscar.addActionListener(handler);
		
		//Logica de inicialização aqui.
		//...
        cadastrarAlunosCSV();
	}

	private class Escutador implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {			
			//Ações ao pressionarem os botões.
			if (event.getSource() == jbuttonBuscar) {
                pesquisar();
            }
		}
	}

    public void pesquisar() {
        int numero = Integer.parseInt(jtextNumero.getText());
        int indice = numero - 1;

        if(indice >= 0 && indice < alunos.size()) {
            jtextNome.setText(alunos.get(indice).getNome());
            jtextGrupo.setText(alunos.get(indice).getGrupo() + "");
        } else {
            JOptionPane.showMessageDialog(null, "Aluno não encontrado");
        }
    }

    public void cadastrarAlunosCSV() {
		try (BufferedReader br = new BufferedReader(new FileReader("dados.csv"))) {
			String linha = br.readLine();
			linha = br.readLine();
			while (linha != null) {
				String[] dados = linha.split(",", -1);
				Aluno aluno = new Aluno(Integer.parseInt(dados[0]), dados[1], Integer.parseInt(dados[2]));
				alunos.add(aluno);

				linha = br.readLine();
			}
		} catch (IOException e) {
			System.err.println("Erro: Arquivo não encontrado" + e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		Cadastro cadastro = new Cadastro("Cadastro");
		cadastro.pack();
		cadastro.setSize(210,150);
		cadastro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cadastro.setVisible(true);
	}
}

class Aluno {
	private int numero;
	private String nome;
	private int grupo;

	public Aluno(int numero, String nome, int grupo) {
		this.numero = numero;
		this.nome = nome;
		this.grupo = grupo;
	}

    public int getNumero() {
        return this.numero;
    }

    public String getNome() {
        return this.nome;
    }

    public int getGrupo() {
        return this.grupo;
    }
}