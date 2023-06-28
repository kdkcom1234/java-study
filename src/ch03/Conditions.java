package ch03;

public class Conditions {
    public static void main(String[] args) {
        // 조건문(condition)
        // 코드를 실행할지 말지를 결정하는데 사용한다.
        // 프로그램의 로직(logic)을 제어하는 핵심적인 부분

        // if문
        /*
        * if ( 조건식 ) {
        *   식이 true일 때 실행할 구문
        * }
        * */
        // 조건식: true / false를 반환하는 식

        int age = 50;

//        if(age >= 18) {
//            System.out.println("성인입니다.");
//        }
//        System.out.println("프로그램이 종료되었습니다");

        // if-else 문
        // if문의 조건식이 true이면, if 블록({}) 안의 코드가 실행
        // if문의 조건식이 false이면, else 블록({}) 안의 코드가 실행
//        if(age >= 18) {
//            System.out.println("성인입니다.");
//        } else {
//            System.out.println("미성년자입니다.");
//        }

        // if-else + else if
        // 조건이 만족되는 가장의 위의 블록만 실행
        if(age >= 60) {
            System.out.println("노인입니다.");
        } else if(age >= 40) {
            System.out.println("장년입니다.");
        } else if(age >= 18) {
            System.out.println("성인입니다.");
        } else {
            System.out.println("미성년자입니다.");
        }
        // else - if를 if-else만으로 변경
        // 코드 깊이가 깊게 가지 않도록 하는 것이 좋다.
//        if(age >= 18) {
//            if(age >= 60) {
//                System.out.println("노인입니다.");
//            } else {
//                System.out.println("성인입니다.");
//            }
//        } else {
//            System.out.println("미성년자입니다.");
//        }

    }
}
