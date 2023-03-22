package Laborator3;

public class TestLindt {
    public static void main(String[] args){

        CandyBox Lindt1 = new Lindt();
        Lindt1.flavor = "abc";
        Lindt1.origin = "cde";
        System.out.println(Lindt1);
        System.out.println(Lindt1.getVolume());
        System.out.println(Lindt1.flavor);
        System.out.println(Lindt1.origin);

        CandyBox Lindt2 = new Lindt("fff", "ggg", 4, 3, 2);
        System.out.println(Lindt2);
        System.out.println(Lindt2.flavor);
        System.out.println(Lindt2.origin);
        System.out.println(Lindt2.getVolume());
    }
}
