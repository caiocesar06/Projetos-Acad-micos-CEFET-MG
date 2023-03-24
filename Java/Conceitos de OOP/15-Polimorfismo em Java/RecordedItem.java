public class RecordedItem extends LibraryItem{
    protected String title;
    protected String medium;

    public RecordedItem(int catalogueNumber, int numberOfCopies, String title, String medium) {
        super(catalogueNumber, numberOfCopies);
        this.title = title;
        this.medium = medium;
    }

    @Override
    public String toString() {
        return String.format("%s\nTítulo: %s\nMídia: %s", super.toString(), title, medium);
    }
}
