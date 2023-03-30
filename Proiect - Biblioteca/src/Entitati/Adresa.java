package Entitati;

public class Adresa {
    private int id;
    private String tara;
    private String oras;
    private String strada;
    private String nr;

    public Adresa() {
    }

    public Adresa(int id, String tara, String oras, String strada, String nr) {
        this.id = id;
        this.tara = tara;
        this.oras = oras;
        this.strada = strada;
        this.nr = nr;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTara() {
        return tara;
    }

    public void setTara(String tara) {
        this.tara = tara;
    }

    public String getOras() {
        return oras;
    }

    public void setOras(String oras) {
        this.oras = oras;
    }

    public String getStrada() {
        return strada;
    }

    public void setStrada(String strada) {
        this.strada = strada;
    }

    public String getNr() {
        return nr;
    }

    public void setNr(String nr) {
        this.nr = nr;
    }

    @Override
    public String toString() {
        return "Adresa{" +
                "id=" + id +
                ", tara='" + tara + '\'' +
                ", oras='" + oras + '\'' +
                ", strada='" + strada + '\'' +
                ", nr='" + nr + '\'' +
                '}';
    }
}
