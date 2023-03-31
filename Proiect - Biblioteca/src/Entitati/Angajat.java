package Entitati;

public class Angajat extends Utilizator{
    private String dataAngajarii;
    private String pozitie;

    public Angajat() {
    }

    public Angajat(int id, String nume, String email, String telefon, String dataAngajarii, String pozitie) {
        super(id, nume, email, telefon);
        this.dataAngajarii = dataAngajarii;
        this.pozitie = pozitie;
    }

    public String getDataAngajarii() {
        return dataAngajarii;
    }

    public void setDataAngajarii(String dataAngajarii) {
        this.dataAngajarii = dataAngajarii;
    }

    public String getPozitie() {
        return pozitie;
    }

    public void setPozitie(String pozitie) {
        this.pozitie = pozitie;
    }

    @Override
    public String toString() {
        return "Angajat{" +
                "id='"+ getId() + '\'' +
                ", dataAngajarii='" + dataAngajarii + '\'' +
                ", pozitie='" + pozitie + '\'' +
                '}';
    }
}
