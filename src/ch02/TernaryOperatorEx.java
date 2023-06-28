package ch02;

public class TernaryOperatorEx {
    public static void main(String[] args) {
        int x = 10;
        int y = 5;

        int result = (x > y) ? (x + y) : (x - y);
        System.out.println(result);

    }
}
