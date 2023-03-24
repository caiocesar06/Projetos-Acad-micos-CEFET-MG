public class ComputerProgram extends RecordedItem{
    protected float version;
    protected String plataform;

    public ComputerProgram(int catalogueNumber, int numberOfCopies, String title, String medium, float version, String plataform) {
        super(catalogueNumber, numberOfCopies, title, medium);
        this.version = version;
        this.plataform = plataform;
    }

    @Override
    public String toString() {
        return String.format("%s\nVersão: %f\nPlataforma: %s", super.toString(), version, plataform);
    }
}
