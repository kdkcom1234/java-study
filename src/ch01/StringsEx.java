package ch01;

public class StringsEx {
    public static void main(String[] args) {
     // 문자열 연습
        // 문자열 초기화 방법 2가지 "", new String("");
        // 문자열 결합
        // 제어문자(\n, \t, \", \\)

        String name = "고대근";
        String address = "동대문구 장안동";
        String age = new String("41세");
        String career = "개발경력은 11년입니다. 주요분야는 클라우드, 블록체인, 프론트엔드 입니다.";

        String info = name + " " + age + "\t주소는 " + address + " 입니다."
                        + "\n" + "\"" + career + "\""
                        + "\n 이상 저의 정보입니다";
        System.out.println(info);
    }
}
