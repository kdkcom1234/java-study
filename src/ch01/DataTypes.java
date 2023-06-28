package ch01;

public class DataTypes {
    public static void main(String[] args) {
        // 1. 정수형 자료형
        // 대부분의 쓰는 자료형
        int age = 25;           // int   -21억 ~ 21억
        long myLong = 1234123123L;    // long -9,223,372,036,854,775,808부터 9,223,372,036,854,775,807
        // 잘 안씀
        short no = 10;      // short    -3만2천 ~ 3만2천
        byte myByte = 10;   // byte     -128 ~ 127
        // 바이트(bytes)
        // 1 bit (0 or 1, 이두개)
        // 0 : 1비트, 1 : 1비트 (2진수 개념에서, 전기가 통한다 안통한다)
        // 1 bit x 8 개 ; 01001011: 1 바이트(byte)
        // int: 4바이트를 저장할 수 있음. 01001011 01001011 01001011 01001011
        // 0      1       0        0        1        0      1      1
        // 2^7   2^6     2^5      2^4      2^3      2^2    2^1     1
        // 64 + 8 + 2 + 1 = 75
        // long: 8바이트 저장할 수 있음.

        // 2. 실수형 자료형(소숫점이 있는 숫자, 10.0: 실수, 10: 정수)
        // 실수: Floating-Point
        float myFloat = 3.14f;  // 4바이트
        // 거이 이것만 쓴다.
        double pi = 3.14159;    // 8바이트

        // 3. 문자형 자료형(Character)
        // 글자 1개 저장 가능, A, a, 1, #
        // 자바에서 잘 안 씀
        // 근데 실제로는 글자로 저장하는게 아니라 숫자로 변환해서 저장함
        // 아스키(ASCII)코드 개념, 유니코드(Unicode)
        // 2바이트 공간크기,
        char myChar = 'A';

        // 4. 논리형 자료형(Boolean Type)
        // 참 또는 거짓(true/false) 값을 저장가능한 자료형
        // is변수명
        boolean isTrue = true;
        boolean isKorean = false; // 한국사람이 아닙니다. 이것을 저장하고 싶음 때

        // 변수명 = 값, 값을 변수 공간에 저장한다, 대입한다, 할당한다.
    }
}
