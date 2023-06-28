package ch05;

public class Utils {
    // 05.클래스-연습문제-02.메서드 5개를 작성
    // 문제1
    // 문제 1: 두 개의 정수를 매개변수로 받아서, 그 합을 반환하는 sum이라는 이름의 메서드를 작성하세요.
    public int sum(int num1, int num2) {
        // value(값, 가치)
        int value = num1 + num2;
        System.out.println("결과는 " + value + "입니다.");
        return value;
    }

    // 문제3
    // 문제 3: 정수 배열을 매개변수로 받아서 배열의 모든 요소를 더한 값을 반환하는 메서드를 작성하세요.
    public int sumArr(int[] arr) {
        int sum = 0;

        for(int val : arr) {
            // 누산(accumulation)
            // sum += val;
            sum = sum + val;
        }

        return sum;
    }
}
