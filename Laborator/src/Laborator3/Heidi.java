package Laborator3;

public class Heidi extends CandyBox {
    private float latura;

    public Heidi(){
    }

    public Heidi(String flavor, String origin, float latura){
        super(flavor, origin);
        this.latura = latura;
    }

    @Override
    public float getVolume() {
        return latura * latura * latura;
    }

    @Override
    public String toString() {
//        return "The" + origin + " " + flavor + " has volume " + getVolume();
        return super.toString() + " has volume: " + getVolume();
    }
}
