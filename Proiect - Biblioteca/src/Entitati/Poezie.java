package entitati;

public class Poezie extends Carte{
    private int nrVolum;

    public Poezie() {
    }

    public Poezie(int id, String titlu, String autor, String editura, int nrVolum) {
        super(id, titlu, autor, editura);
        this.nrVolum = nrVolum;
    }

    public int getNrVolum() {
        return nrVolum;
    }

    public void setNrVolum(int nrVolum) {
        this.nrVolum = nrVolum;
    }

    @Override
    public String toString() {
        return "Poezie{" +
                super.toString() +
                ", nrVolum=" + nrVolum +
                '}';
    }
}
