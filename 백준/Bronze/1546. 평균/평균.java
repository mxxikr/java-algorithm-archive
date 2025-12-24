import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * 변환 점수의 평균을 구하는식 = 총합 * 100 / 최고 점수 / 과목 수
 * (a / M * 100 + b / M * 100 + c / M * 100  + ...) / n = (a + b + c + ...) * 100 / M / N
 *
 * ==== 의사 코드 ====
 * 변수 N에 과목 수 입력 받기
 * 길이가 N인 1차원 배열 A[] 선언하기(총합)
 * for(A[] 길이 만큼 반복하기) {
 *     A[i]에 각 점수 저장하기
 * }
 *
 * for(A[] 길이만 큼 반복하기) {
 *     최고점은 변수 max에, 총점은 변수 sum에 저장하기
 * }
 *
 * sum  * 100 / max / N 출력
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        long sum = 0;
        long max = 0;
        for (int i = 0; i < N; i++) {
            if (A[i] > max) max = A[i];
            sum += A[i];
        }

        System.out.println(sum * 100.0 / max / N);
    }
}