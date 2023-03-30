package Entitati;

public class Cititor extends Utilizator{
    private int cartiImprumutate;

    public Cititor() {
    }

    public Cititor(int id, String nume, String email, String telefon, int cartiImprumutate) {
        super(id, nume, email, telefon);
        this.cartiImprumutate = cartiImprumutate;
    }

    public int getCartiImprumutate() {
        return cartiImprumutate;
    }

    public void setCartiImprumutate(int cartiImprumutate) {
        this.cartiImprumutate = cartiImprumutate;
    }
}
