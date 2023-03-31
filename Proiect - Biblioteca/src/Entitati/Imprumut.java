package Entitati;

public class Imprumut {
    private static int cnt = 1;
    private int id;
    private Carte carte;
    private Cititor cititor;

    public Imprumut() {
        this.id = cnt++;
    }

    public Imprumut(Carte carte, Cititor cititor) {
        this.id = cnt++;
        this.carte = carte;
        this.cititor = cititor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Carte getCarte() {
        return carte;
    }

    public void setCarte(Carte carte) {
        this.carte = carte;
    }

    public Cititor getCititor() {
        return cititor;
    }

    public void setCititor(Cititor cititor) {
        this.cititor = cititor;
    }

    @Override
    public String toString() {
        return "Imprumut{" +
                "id=" + id +
                ", carte=" + carte +
                ", cititor=" + cititor +
                '}';
    }
}
