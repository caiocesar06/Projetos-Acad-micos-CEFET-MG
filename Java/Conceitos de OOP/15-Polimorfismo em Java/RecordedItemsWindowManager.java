import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RecordedItemsWindowManager extends JFrame implements ActionListener {
    // Variáveis da Classe LibraryItem
    private JLabel jLabelCatalogueNumber;
    private JLabel jLabelNumberOfCopies;
    private JTextField jTextFieldCatalogueNumber;
    private JTextField jTextFieldNumberOfCopies;

    // Variáveis da Classe RecordedItem
    private JLabel jLabelRecordItemType;
    private JLabel jLabelTitle;
    private JLabel jLabelMedium;
    private JComboBox<String> jComboRecordItemType;
    private JTextField jtextFieldTitle;
    private JTextField jtextFieldMedium;

    // Variáveis da Classe Film
    private JLabel jLabelDirector;
    private JLabel jLabelDateOfRelease;
    private JLabel jLabelDistribuitor;
    private JTextField jTextFieldDirector;
    private JTextField jTextFieldDateOfRealease;
    private JTextField jTextFieldDistribuitor;

    // Variáveis da Classe ComputerProgram
    private JLabel jLabelVersion;
    private JLabel jLabelPlataform;
    private JTextField jTextFieldVersion;
    private JTextField jTextFieldPlataform;

    // Butões
    private JButton jbuttonPrintArrayList;
    private JButton jbuttonClear;
    private JButton jbuttonAdd;

    // Painéis
    private JPanel jPanelRecordedItems;
    private JPanel jPanelFilm;
    private JPanel jPanelComputerProgram;
    private JPanel jPanelButtons;

    private ArrayList<RecordedItem> records;

    public RecordedItemsWindowManager() {
        super("Recorded Items Manager");

        records = new ArrayList<RecordedItem>();

        loadAllPanels();
        loadAllLabels();
        loadAllTextFields();
        loadAllButtons();
        loadComboBox();
        addActionListenerInAllButtons(RecordedItemsWindowManager.this);
        addAllPanels();
    }

    public void loadAllPanels() {
        setLayout(new GridLayout(4, 1, 30, 15));
        jPanelRecordedItems = new JPanel(new GridLayout(5, 2, 5, 5));
        jPanelFilm = new JPanel(new GridLayout(3, 2, 5, 5));
        jPanelComputerProgram = new JPanel(new GridLayout(2, 2, 5, 15));
        jPanelButtons = new JPanel(new GridLayout(1, 3, 5, 5));

        jPanelFilm.setVisible(true);
        jPanelComputerProgram.setVisible(false);
    }

    public void loadAllLabels() {
        // Labels da Classe LibraryItem
        jLabelCatalogueNumber = new JLabel("Catalogue Number");
        jLabelNumberOfCopies = new JLabel("Number of Copies");

        // Labels da Classe RecordedItem
        jLabelRecordItemType = new JLabel("Item Type");
        jLabelTitle = new JLabel("Title");
        jLabelMedium = new JLabel("Medium");

        // Labels da Classe Film
        jLabelDirector = new JLabel("Director");
        jLabelDateOfRelease = new JLabel("Date of Release");
        jLabelDistribuitor = new JLabel("Distribuitor");

        // Labels da Classe ComputerProgram
        jLabelVersion = new JLabel("Version");
        jLabelPlataform = new JLabel("Plataform");
    }

    public void loadAllTextFields() {
        // TextFields da Classe LibraryItem
        jTextFieldCatalogueNumber = new JTextField(64);
        jTextFieldNumberOfCopies = new JTextField(64);

        // TextFields da Classe RecordedItem
        jtextFieldTitle = new JTextField(64);
        jtextFieldMedium = new JTextField(64);

        // TextFields da Classe Film
        jTextFieldDirector = new JTextField(64);
        jTextFieldDateOfRealease = new JTextField(64);
        jTextFieldDistribuitor = new JTextField(64);

        // TextFields da Classe ComputerProgram
        jTextFieldVersion = new JTextField(64);
        jTextFieldPlataform = new JTextField(64);
    }

    public void loadAllButtons() {
        jbuttonPrintArrayList = new JButton("Print ArrayList");
        jbuttonClear = new JButton("Clear");
        jbuttonAdd = new JButton("Add");
    }

    public void loadComboBox() {
        jComboRecordItemType = new JComboBox<String>(new String[] { "Film", "Computer Program" });
        jComboRecordItemType.setSelectedIndex(0);
        jComboRecordItemType.addActionListener(RecordedItemsWindowManager.this);
    }

    public void addActionListenerInAllButtons(ActionListener l) {
        jbuttonPrintArrayList.addActionListener(l);
        jbuttonClear.addActionListener(l);
        jbuttonAdd.addActionListener(l);
    }

    public void addAllPanels() {
        // Adicionando no Painel da Classe RecordedItem
        jPanelRecordedItems.add(jLabelCatalogueNumber);
        jPanelRecordedItems.add(jTextFieldCatalogueNumber);

        jPanelRecordedItems.add(jLabelNumberOfCopies);
        jPanelRecordedItems.add(jTextFieldNumberOfCopies);

        jPanelRecordedItems.add(jLabelRecordItemType);
        jPanelRecordedItems.add(jComboRecordItemType);

        jPanelRecordedItems.add(jLabelTitle);
        jPanelRecordedItems.add(jtextFieldTitle);

        jPanelRecordedItems.add(jLabelMedium);
        jPanelRecordedItems.add(jtextFieldMedium);

        // Adicionando no Painel da Classe Film
        jPanelFilm.add(jLabelDirector);
        jPanelFilm.add(jTextFieldDirector);

        jPanelFilm.add(jLabelDateOfRelease);
        jPanelFilm.add(jTextFieldDateOfRealease);

        jPanelFilm.add(jLabelDistribuitor);
        jPanelFilm.add(jTextFieldDistribuitor);

        // Adicionando no Painel da Classe ComputerProgram
        jPanelComputerProgram.add(jLabelVersion);
        jPanelComputerProgram.add(jTextFieldVersion);

        jPanelComputerProgram.add(jLabelPlataform);
        jPanelComputerProgram.add(jTextFieldPlataform);

        // Adicionando no Painel dos Botões
        jPanelButtons.add(jbuttonPrintArrayList);
        jPanelButtons.add(jbuttonClear);
        jPanelButtons.add(jbuttonAdd);

        // Adicionando os Paineis na Janela
        this.add(jPanelRecordedItems);
        this.add(jPanelFilm);
        this.add(jPanelComputerProgram);
        this.add(jPanelButtons);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Evento que ocorre quando o usuário seleciona um item do ComboBox
        if (e.getSource() == jComboRecordItemType) {
            if (jComboRecordItemType.getSelectedIndex() == 0) {
                jPanelFilm.setVisible(true);
                jPanelComputerProgram.setVisible(false);
                jTextFieldVersion.setText("");
                jTextFieldPlataform.setText("");
            } else {
                jPanelFilm.setVisible(false);
                jPanelComputerProgram.setVisible(true);
                jTextFieldDirector.setText("");
                jTextFieldDateOfRealease.setText("");
                jTextFieldDistribuitor.setText("");
            }
        }

        // Evento que ocorre quando o usuário clica no botão "Print ArrayList"
        if (e.getSource() == jbuttonPrintArrayList) {
            for (RecordedItem r : records) {
                System.out.println(r);
                System.out.println("---------------------------------");
            }
        }

        // Evento que ocorre quando o usuário clica no botão "Add"
        if (e.getSource() == jbuttonAdd) {
            if (jTextFieldCatalogueNumber.getText().isEmpty() || jTextFieldNumberOfCopies.getText().isEmpty()
                    || jtextFieldTitle.getText().isEmpty() || jtextFieldMedium.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill all the fields", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            } else {
                if (jComboRecordItemType.getSelectedIndex() == 0) {
                    if (jTextFieldDirector.getText().isEmpty() || jTextFieldDateOfRealease.getText().isEmpty()
                            || jTextFieldDistribuitor.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Please fill all the fields", "Error",
                                JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                } else {
                    if (jTextFieldVersion.getText().isEmpty() || jTextFieldPlataform.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Please fill all the fields", "Error",
                                JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }
            }

            if (jComboRecordItemType.getSelectedIndex() == 0) {
                records.add(new Film(Integer.parseInt(jTextFieldCatalogueNumber.getText()),
                        Integer.parseInt(jTextFieldNumberOfCopies.getText()),
                        jtextFieldTitle.getText(),
                        jtextFieldMedium.getText(),
                        jTextFieldDirector.getText(),
                        jTextFieldDateOfRealease.getText(),
                        jTextFieldDistribuitor.getText()));
            } else {
                records.add(new ComputerProgram(Integer.parseInt(jTextFieldCatalogueNumber.getText()),
                        Integer.parseInt(jTextFieldNumberOfCopies.getText()),
                        jtextFieldTitle.getText(),
                        jtextFieldMedium.getText(),
                        Float.parseFloat(jTextFieldVersion.getText()),
                        jTextFieldPlataform.getText()));
            }

            JOptionPane.showMessageDialog(null, "Recorded Item added with success", "Success",
                    JOptionPane.INFORMATION_MESSAGE);
        }

        // Evento que ocorre quando o usuário clica no botão "Clear"
        if (e.getSource() == jbuttonClear) {
            jTextFieldCatalogueNumber.setText("");
            jTextFieldNumberOfCopies.setText("");
            jtextFieldTitle.setText("");
            jtextFieldMedium.setText("");
            jTextFieldDirector.setText("");
            jTextFieldDateOfRealease.setText("");
            jTextFieldDistribuitor.setText("");
            jTextFieldVersion.setText("");
            jTextFieldPlataform.setText("");
        }
    }
}
