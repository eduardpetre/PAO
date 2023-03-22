package Laborator3;

public class TestCandyBox {
    public static void main(String[] args){

        CandyBox cb1 = new CandyBox();
        System.out.println(cb1.toString());

        CandyBox cb2 = new CandyBox("strawberry", "swiss");
        System.out.println(cb2.toString());

        CandyBox cb3 = cb2;
        CandyBox cb4 = new CandyBox("strawberry", "swiss");

        System.out.println("equals: " + cb1.equals(cb2));
        System.out.println("equals: " + cb2.equals(cb4));
        System.out.println("equals: " + cb3.equals(cb4));
    }
}
