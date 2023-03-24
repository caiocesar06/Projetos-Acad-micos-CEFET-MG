public class Main {
    public static void main(String[] args) throws Exception {
        new Main();
    }

    public Main() {
        DatabaseManager dm = new DatabaseManager();
        dm.writeToCsv();

        FileManager fm = new FileManager();
        for(Funcionario f : fm.listaFuncionarios) {
            System.out.println(f);
        }
    }
}