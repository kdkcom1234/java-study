package ch01;

public class Strings {
    public static void main(String[] args) {
        // string(문자열)
        // 문자를 여러개로 연결(문자의 배열)
        String greeting = "Hello, World!";

        // 자바에서 문자열(String)은 기본 자료형이 아니다.
        // char(문자타입) 여러개를 연결한 것과 같다.
        // Ctrl + /, 선택 영역만큼 주석이 생성
        // /* ... */ 여러줄을 주석으로 표시
        /*
        String str = "abc";
        is equivalent to:
        char data[] = {'a', 'b', 'c'};
        */

        // 문자열 초기화 방법
        // 문자열 값을 코드에 직접 입력한 것을 리터럴(literal)
        String firstName = new String("John");
        String lastName = "Doe";

        // 문자열 결합(concat)
        // 변수를 참조해서 사용할 때는 이름은 대소문자를 가립니다(case-sensitve)
        String fullName = firstName + " " + lastName;
        System.out.println(fullName);

        // 제어문자(escape characters, escape sequence)
        // 문자열 처리에 특수문자, 줄바꿈, 쌍따옴표, 탭,
        // String message = ""이렇게 하고 싶은데"";
        // "메시지입니다."
        // 메시지입니다.
        String message = "Hello\nWorld";
        System.out.println(message);

        String tabMessage = "Hello\tWorld";
        System.out.println(tabMessage);

        String doubleQuote = "\"Hello, World\"";
        System.out.println(doubleQuote);

        String back = "Hello\\World";
        System.out.println(back);
    }
}
