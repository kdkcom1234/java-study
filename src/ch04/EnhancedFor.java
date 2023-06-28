package ch04;

public class EnhancedFor {
    public static void main(String[] args) {
        // 향상된 for문
        // 배열/컬렉션같이 여러개 의 값을 저장할 수 있는 자료구조를 순차적 탐색
        // 처음부터 끝까지 반복문을 돈다.
        // int i=0; i<배열크기; i++ -> 너무 자꾸써야되서 힘들다.

         int[] numbers = {1, 2, 3, 4, 5};
         // 향상된 for문을 이용하여 배열 순회
        for(int number : numbers) {
            System.out.println(number);
        }
    }
}
