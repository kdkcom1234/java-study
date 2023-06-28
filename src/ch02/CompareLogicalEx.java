package ch02;

public class CompareLogicalEx {
    public static void main(String[] args) {
        int a = 5;
        int b = 10;
        int c = 15;

        boolean result = (a < b) && (c > b) && (a + b == c);
        System.out.println(result);
    }
}
