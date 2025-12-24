import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * 합 배열 공식 - S[i] = S[i - 1] + A[i]
 * 구간 합 공식 - S[j] - S[i-0]
 *
 * ==== 의사 코드 ====
 * suNo(숫자 개수), quizNo(질의 개수) 저장하기
 * for (숫자 개수만큼 반복하기) {
 *     합 배열 생성하기(S[i] = S[i - 1] + A[i])
 * }
 *
 * for (질의 개수 만큼 반복하기) {
 *     질의 범위 받기(i ~ j)
 *     구간 합 출력하기(S[j] - S[i-1])
 * }
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int suNo = Integer.parseInt(tokenizer.nextToken());
        int quizNo = Integer.parseInt(tokenizer.nextToken());

        long[] S = new long[suNo + 1]; // 합배열

        StringTokenizer tokenizer2 = new StringTokenizer(reader.readLine());

        // 합 배열 생성
        for (int i = 1; i <= suNo; i++) { // 1부터 시작해야함
            S[i] = S[i - 1] + Integer.parseInt(tokenizer2.nextToken());
        }

        // 구간 합
        for (int q = 0; q < quizNo; q++) {
            StringTokenizer tokenizer3 = new StringTokenizer(reader.readLine());
            int i = Integer.parseInt(tokenizer3.nextToken());
            int j = Integer.parseInt(tokenizer3.nextToken());
            System.out.println(S[j] - S[i - 1]);
        }
    }
}