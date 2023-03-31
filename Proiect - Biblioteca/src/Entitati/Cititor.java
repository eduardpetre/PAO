package Entitati;

public class Cititor extends Utilizator{
    private boolean elev;

    public Cititor() {
    }

    public Cititor(int id, String nume, String email, String telefon, boolean elev) {
        super(id, nume, email, telefon);
        this.elev = elev;
    }

    public boolean isElev() {
        return elev;
    }

    public void setElev(boolean elev) {
        this.elev = elev;
    }

    @Override
    public String toString() {
        return "Cititor{" +
                "id='"+ getId() + '\'' +
                ", nume='" + getNume() + '\'' +
                ", elev=" + elev +
                '}';
    }
}
