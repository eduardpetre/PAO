package Laborator2;

import java.util.Arrays;

public class ex4 {
    public static void main(String[] args){
        char[] chars = {'j', 'a', 'v', 'a'};

        for(char c: chars){
            System.out.println(c);
        }
        System.out.println("Arrays.toString()");
        System.out.println(Arrays.toString(chars));
    }
}
