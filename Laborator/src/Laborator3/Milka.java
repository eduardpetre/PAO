package Laborator3;

public class Milka extends CandyBox {
    private float raza;
    private float inaltime;

    public Milka(){
    }

    public Milka(String flavor, String origin, float raza, float inaltime){
        super(flavor, origin);
        this.raza = raza;
        this.inaltime = inaltime;
    }

    @Override
    public float getVolume() {
        return 3.14f * raza * raza * inaltime;
    }

    @Override
    public String toString() {
//        return "The" + origin + " " + flavor + " has volume " + getVolume();
        return super.toString() + " has volume: " + getVolume();
    }
}
