public class Film extends RecordedItem {
    protected String director;
    protected String dateOfRelease;
    protected String distributor;

    public Film(int catalogueNumber, int numberOfCopies, String title, String medium, String director,
            String dateOfRelease, String distributor) {
        super(catalogueNumber, numberOfCopies, title, medium);
        this.director = director;
        this.dateOfRelease = dateOfRelease;
        this.distributor = distributor;
    }

    @Override
    public String toString() {
        return String.format("%s\nDiretor: %s\nData de lançamento: %s\nDistribuidora: %s", super.toString(), director, dateOfRelease, distributor);
    }
}
