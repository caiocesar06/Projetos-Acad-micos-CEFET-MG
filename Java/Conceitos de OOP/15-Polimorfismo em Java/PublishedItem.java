public class PublishedItem extends LibraryItem{

    protected String title;
    protected String publisher;

    public PublishedItem(int catalogueNumber, int numberOfCopies, String title, String publisher) {
        super(catalogueNumber, numberOfCopies);
        this.title = title;
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return String.format("%s\nTítulo: %s\nPublicadora: %s", super.toString(), title, publisher);
    }
}