import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * ==== 의사 코드 ====
 * N(자릿수)
 * DFS 실행 // 숫자 2, 3, 5, 7로 탐색 시작, 일의 자리 시작이므로 자릿수는 1
 * DFS(2, 1);
 * DFS(3, 1);
 * DFS(5, 1);
 * DFS(7, 1);
 *
 * // DFS 구현하기
 * DFS(숫자, 자릿수) {
 *     if (자릿수 == N) {
 *         if (소수) 수 출력하기
 *         탐색 종료
 *     }
 *
 *     for(1~9 반복하기) {
 *         if(뒤에 붙는 수가 홀수이면서 소수일 때)
 *         DFS(현재 수 * 10 + i, 자릿수 + 1) // 자릿수를 1씩 늘리면서 DFS 실행
 *     }
 * }
 *
 * // 소수 구하기 함수
 * for ('2~현재수/2' 반복하기) {
 *     if(나머지가 0이면) 소수가 아님
 * }
 * return 소수임
 */

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        DFS(2, 1);
        DFS(3, 1);
        DFS(5, 1);
        DFS(7, 1);
    }

    static void DFS(int number, int jarisu) {
        if (jarisu == N) {
            if (isPrime(number)) {
                System.out.println(number);
            }
            return;
        }

        for (int i = 1; i < 10; i++) {
            if (i % 2 == 0) { // 짝수라면 더 이상 탐색할 필요가 없음
                continue;
            }

            if (isPrime(number * 10 + i)) { // 소수라면 재귀 함수로 자릿수를 늘림
                DFS(number * 10 + i, jarisu + 1);
            }
        }
    }

    static boolean isPrime(int num) {
        for (int i = 2; i < num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}