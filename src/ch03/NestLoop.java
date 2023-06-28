package ch03;

public class NestLoop {
    public static void main(String[] args) {
        // 구구단 구하기 중첩 반복문
        // 중첩(Nested)
        for (int i = 2; i <= 9; i++) {
            // 2 * 1, 2 * 2, 2 * 3 ... 2 * 9
            // 3 * 1, 2 * 2
            // ...
            // 9 * 1,
            for (int j = 1; j <= 9; j++) {
                System.out.println(i * j);
            }
            System.out.println("--" + i + "단");
        }
    }
}
