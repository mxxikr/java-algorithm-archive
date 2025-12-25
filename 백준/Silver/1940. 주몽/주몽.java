import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * ==== 의사 코드 ====
 * N(재료의 개수), M(갑옷이 되는 번호) 저장
 *
 * for (N만큼 반복) {
 *     재료 배열 저장하기
 * }
 *
 * 재료 배열 정렬하기
 *
 * while (i < j) { // 둘이 만날 때까지
 *     if(재료 합 < M) 작은 번호 재료를 한 칸 위로 변경
 *     else if (재료 합 > M) 큰 번호 재료를 한 칸 아래로 변경
 *     else 경우의 수 증가, 양쪽 index 각각 변경
 * }
 * count 출력
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] A = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A); // 오름차순 정렬하기

        int count = 0;
        int i = 0, j = N - 1;

        while (i < j) {
            if (A[i] + A[j] < M) {
                i++;
            } else if (A[i] + A[j] > M) {
                j--;
            }
            else {
                count++;
                i++;
                j--;
            }
        }

        System.out.println(count);
        br.close();
    }
}