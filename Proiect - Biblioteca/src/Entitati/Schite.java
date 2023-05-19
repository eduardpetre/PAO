package entitati;

public class Schite extends Carte{
    private int nrActe;

    public Schite() {
    }

    public Schite(int id, String titlu, String autor, String editura, int nrActe) {
        super(id, titlu, autor, editura);
        this.nrActe = nrActe;
    }

    public int getNrActe() {
        return nrActe;
    }

    public void setNrActe(int nrActe) {
        this.nrActe = nrActe;
    }

    @Override
    public String toString() {
        return "Schite{" +
                super.toString() +
                ", nrActe=" + nrActe +
                '}';
    }
}
