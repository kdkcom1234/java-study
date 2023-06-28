package ch02;

public class ArithmeticEx {
    public static void main(String[] args) {
        // 7번, 자릿수 버리기 문제
        int number = 230492039;
        // 100으로 나누면 100 미만 숫자들을 날아감, 뒤에 2자리(일~십의자리)
        // 2304920
        // 뒤에 두자리 추가 * 100
        int result = number / 100 * 100;
        System.out.println(result);

        // 6번, 나머지 연산을 잘 쓰면,
        int price = 187000;
        int oman = price / 50000;
        int ilman = price % 50000 / 10000; // 37000
//        int ochun = price % 50000 % 10000 / 5000; // 7000
        int ochun = price % 10000 / 5000; // 7000
        int ilchun = price % 5000 / 1000;

        // 지폐의 개수가 최소가 되려면, 큰 금액의 지폐를 먼저 지불
        // 5만원은 다내자 -> 남은 거를 1만원으 다내자 -> 남은거를 5000원으로 다내자 -> 남은거를 1000원으로 내자

        int ochun1 = price % 50000 % 10000;
        int ochun2 = price % 10000; // 천단위 금액만 남음

//        System.out.println(ochun1 + " " + ochun2);
        System.out.println(oman + " " + ilman + " " + ochun + " " + ilchun);
    }
}
