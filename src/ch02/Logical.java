package ch02;

public class Logical {
    public static void main(String[] args) {
        boolean a = true;
        boolean b = false;

        // AND(논리곱) 연산자 &&(ampersand)
        // &&: 둘다 true면 true, 하나라도 false면 false;
        boolean result = a && b;
        // short-circuit evaluation(단락 평가)
        // 왼쪽 값에 의해서 연산 결과를 도출할 수 있으면, 오른쪽 값은 판단하지 않음
        boolean result1 = b && a;
        System.out.println(result);
        System.out.println(result1);

        // OR(논리합) 연산자 ||(pipe)
        // OR 연산은 둘중에 하나라도 true면 true, 둘 다 false면 false
        boolean result2 = a || b;
        System.out.println(result2);
    }
}
