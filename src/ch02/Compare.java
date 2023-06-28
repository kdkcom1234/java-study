package ch02;

public class Compare {
    public static void main(String[] args) {
        // 동등 비교 연산자
        // 똑같은지 비교
        int a = 5;
        int b = 3;
        boolean result = (a == b);  // false
//        System.out.println(result);

       // 문자열 비교에는 ==, !-를 쓰지 않음
//        String str1 = "abc";
//        String str2 = "abc";
//        boolean resultStr = (str1 == str2);
//        boolean resultStrNot = (str1 != str2);
//        System.out.println(resultStr);
//        System.out.println(resultStrNot);

        String str3 = new String("abc");
        String str4 = new String("abc");
        boolean resultStr1 = (str3 == str4);
        boolean resultStrNot2 = (str3 != str4);
        System.out.println(resultStr1);
        System.out.println(resultStrNot2);
        System.out.println("--------------");

        // 자바에서 문자열 비교는 문자열변수명.equals(변수/값)
        boolean resultStr3 = (str3.equals(str4));
        // 논리적으로 반대의 연산을 하고 싶을때, !(Not 연산)
        // 정확히는 결과값이 반대로 반환됨
        boolean resultStrNot3 = (!str3.equals(str4));
        System.out.println(resultStr3);
        System.out.println(resultStrNot3);

        // 부등 비교 연산자
        // not equal == 서로 다른가
        // !: not
        boolean resultNot = (a != b);   // true
//        System.out.println(resultNot);
    }
}
