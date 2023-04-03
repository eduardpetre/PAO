package Entitati;

public class Roman extends Carte{
    private int nrCapitole;

    public Roman() {
    }

    public Roman(int id, String titlu, String autor, String editura, int nrCapitole) {
        super(id, titlu, autor, editura);
        this.nrCapitole = nrCapitole;
    }

    public int getNrCapitole() {
        return nrCapitole;
    }

    public void setNrCapitole(int nrCapitole) {
        this.nrCapitole = nrCapitole;
    }

    @Override
    public String toString() {
        return "Roman{" +
                super.toString() +
                ", nrCapitole=" + nrCapitole +
                '}';
    }
}
