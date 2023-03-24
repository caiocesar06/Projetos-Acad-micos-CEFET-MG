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
/***
 * Classe com escutador externo
 */
public class Cadastro extends JFrame {
	//Define componentes da janela.
	private JLabel jLabelNumero;
	private JLabel jLabelNome;
	private JLabel jLabelGrupo;

	protected JTextField jtextNumero;
	protected JTextField jtextNome;
	protected JTextField jtextGrupo;

	private JButton jbuttonAnterior;
	private JButton jbuttonProximo;

	private ArrayList<Aluno> alunos = new ArrayList<Aluno>();
	private int indice;
	
	public Cadastro(String titulo) {
		super(titulo);

		setLayout(new FlowLayout(FlowLayout.RIGHT));

		//Inicializa componentes da janela.
		jLabelNumero = new JLabel("Número" );
		jLabelNome = new JLabel("Nome" );
		jLabelGrupo = new JLabel("Grupo");
		
		jtextNumero = new JTextField(10);
		jtextNumero.setEditable(false);

		jtextNome = new JTextField(10);
		jtextNome.setEditable(false);

		jtextGrupo = new JTextField(10);
		jtextGrupo.setEditable(false);

		jbuttonAnterior = new JButton("Anterior");
		jbuttonProximo= new JButton("Próximo");

		indice = 0;

		//Adiciona componentes na janela.
		this.add(jLabelNumero);
		this.add(jtextNumero);

		this.add(jLabelNome);		
		this.add(jtextNome);

		this.add(jLabelGrupo);
		this.add(jtextGrupo);
				
		this.add(jbuttonAnterior);
		this.add(jbuttonProximo);

		//Cria o escutador
		Escutador handler = new Escutador();

		//Adiciona o escutador a cada botão.
		jbuttonAnterior.addActionListener(handler);
		
		jbuttonProximo.addActionListener(handler);

		//Logica de inicialização aqui.
		// ...
		cadastrarAlunosCSV();
		setTextFields();
	}

	private class Escutador implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {			

			//Ações ao pressionarem os botões.
			if (event.getSource()==jbuttonAnterior) {
				indice--;
			}else if (event.getSource()==jbuttonProximo) {
				indice++;
			}

			indice = indice < 0 ? getAlunos().size() - 1 : indice;
			indice = indice > getAlunos().size() - 1 ? 0 : indice;

			setTextFields();
		}
	}

	public ArrayList<Aluno> getAlunos() {
		return this.alunos;
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
	
	public void setTextFields() {
		jtextNumero.setText(getAlunos().get(indice).getNumero() + "");
		jtextNome.setText(getAlunos().get(indice).getNome());
		jtextGrupo.setText(getAlunos().get(indice).getGrupo() + "");
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