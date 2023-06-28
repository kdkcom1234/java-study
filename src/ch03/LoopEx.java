package ch03;

public class LoopEx {
    public static void main(String[] args) {
        // 도트그래픽 2D(x, y축)
        // 행(가로, y) 이게 더 상위개념, 열(세로, x) 이게 하위 개념

        // 반복문을 돌리려면, 가장 바깥 반복문이 행을 제어하는 반복문
        // 1번째행 -> 1번째열, 2번째열....., 밑으로 내려감
        // 2번째행 -> 1번째열, 2번째열....., 밑으로 내려감

        // 행 개수
        int n = 10;

        for(int i = 1; i <= n; i++) {
            // i = 1, 첫번째행을 출력
            // i = 2, 두번째행을 출력

            // 빈 공간 출력
            // 5 - i(행번호) 만큼 출력
            for(int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }

            // 별 출력
            // 2*i(행번호) - 1 만큼 출력
            for(int k = 1; k <= 2*i - 1; k++) {
                System.out.print("*");
            }

            // 밑줄로 내림
            System.out.println();
        }
    }
}
