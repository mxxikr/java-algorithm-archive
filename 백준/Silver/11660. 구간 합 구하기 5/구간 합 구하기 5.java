import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * 합 배열 생성 공식
 * D[i][j] =  D[i][j - 1] + D[i - 1][j] - D[i - 1][j - 1] + A[i][j]
 *
 * 질의 x1, y1, x2, y2에 대한 답을 구간 합으로 구하는 식
 * D[x2][y2] - D[x1 - 1][y2] - D[x2][y1 - 1] + D[x1 - 1][y1 - 1]
 *
 * ==== 의사 코드 ====
 * N(배열 크기) M(질의 수) 저장하기
 *
 * for(N만큼 반복하기) {
 *      for(N만큼 반복하기) {
 *          원본 배열 저장하기
 *      }
 *
 * for(N만큼 반복하기) {
 *      for(N만큼 반복하기) {
 *          합 배열 저장하기
 *          D[i][j] =  D[i][j - 1] + D[i - 1][j] - D[i - 1][j - 1] + A[i][j]
 *      }
 *
 * for(N만큼 반복하기) {
 *      질의 계산 및 출력하기
 *      결과 = D[x2][y2] - D[x1 - 1][y2] - D[x2][y1 - 1] + D[x1 - 1][y1 - 1]
 * }
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int n = Integer.parseInt(tokenizer.nextToken()); // 배열 크기
        int m = Integer.parseInt(tokenizer.nextToken()); // 질의 수

        int A[][] = new int[n + 1][n+ 1];

        // 원본 배열 채우기
        for (int i = 1; i <= n; i++) {
            StringTokenizer tokenizer2 = new StringTokenizer(reader.readLine()); // 한줄 통채로 읽은 후

            for (int j = 1; j <= n; j++) {
                A[i][j] = Integer.parseInt(tokenizer2.nextToken()); // 각 숫자 분리
            }
        }

        int D[][] = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                // 구간 합 구하기
                D[i][j] =  D[i][j - 1] + D[i - 1][j] - D[i - 1][j - 1] + A[i][j];
            }
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer tokenizer3 = new StringTokenizer(reader.readLine());
            int x1 = Integer.parseInt(tokenizer3.nextToken());
            int y1 = Integer.parseInt(tokenizer3.nextToken());
            int x2 = Integer.parseInt(tokenizer3.nextToken());
            int y2 = Integer.parseInt(tokenizer3.nextToken());

            // 구간 합 배열로 질의 답변
            int result = D[x2][y2] - D[x1 - 1][y2] - D[x2][y1 - 1] + D[x1 - 1][y1 - 1];

            System.out.println(result);
        }
    }
}