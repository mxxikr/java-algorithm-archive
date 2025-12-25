import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * ==== 의사 코드 ====
 * N 입력 받기 (수열의 개수)
 * M 입력 받기 (나누어 떨어져야 하는 수)
 * 합 배열 S 선언하기
 * C 선언 하기(같은 나머지 인덱스를 카운트하는 배열)
 *
 * for ( i -> 1 ~ N) {
 *     S[i] = S[i - 1] + A[i] // 합 배열 저장
 * }
 *
 * for ( i -> 0 ~ N) {
 *      remainder = S[i] % M // 합 배열을 M으로 나눈 나머지 값 저
 *      if (remainder == 0) {
 *          정답을 1 증가 시키기
 *      }
 *      C[remainder] 값 1 증가 시키기
 * }
 *
 * for ( i -> 0 ~ M) {
 *      C[i](i가 나머지인 인덱스 개수)에서 2가지를 뽑는 경우의 수를 정답에 더하기
 *      // C[i] 중 2개를 뽑는 경우의 수 계산 공식 C[i] * (C[i] - 1) / 2
 * }
 *
 * 결과 값 출력
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long[] S = new long[N];
        long[] C = new long[M];
        long answer = 0;

        st = new StringTokenizer(br.readLine());
        S[0] = Long.parseLong(st.nextToken());

        // 합 배열 저장하기
        for (int i = 1; i < N; i++) {
            S[i] = S[i - 1] + Long.parseLong(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            int remainder = (int) (S[i] % M);
            if (remainder == 0) {
                answer++;
            }
            C[remainder]++;
        }

        for (int i = 0; i < M; i++) {
            if (C[i] > 1) {
                answer += (C[i] * (C[i] - 1) / 2);
            }
        }
        System.out.println(answer);
    }
}