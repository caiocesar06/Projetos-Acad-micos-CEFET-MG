import javax.swing.JFrame;

public class Main {

    public Main() {
        RecordedItem li = new Film(06, 777, "A volta dos que não foram", "DVD/Blu-Ray", "CESAR, Caio", "07/07/2020",
                "ErbertRichard");
        System.out.println(" > Questão 1:");
        itemInfo(li);
        System.out.println("\n\n > Questão 2:");
        RecordedItemsWindowManager recordedItemsWindowManager = new RecordedItemsWindowManager();
        recordedItemsWindowManager.setVisible(true);
        recordedItemsWindowManager.setSize(400, 600);
        recordedItemsWindowManager.setResizable(false);
        recordedItemsWindowManager.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void itemInfo(LibraryItem libraryItem) {
        System.out.println(libraryItem);
    }

    public static void main(String[] args) {
        Main main = new Main();
    }
}
