public abstract class LibraryItem {
    protected int catalogueNumber;
    protected int numberOfCopies;

    public LibraryItem(int catalogueNumber, int numberOfCopies) {
        this.catalogueNumber = catalogueNumber;
        this.numberOfCopies = numberOfCopies;
    }

    public void acquire() {

    }

    public void _return() {

    }

    @Override
    public String toString() {
        return String.format("Número de catálogo: %d\nNúmero de cópias: %d", catalogueNumber, numberOfCopies);
    }
}