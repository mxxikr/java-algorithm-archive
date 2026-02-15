import java.io.*;
import java.util.*;

/**
 * ==== 의사 코드 ====
 * N(입력 값 받기)
 * int[] a[N] 선언
 * for (i = 0부터 N까지) {
 *     a[i] = st.token
 * }
 * x 입력 받기
 *
 * a배열 오름차순 정렬
 *
 * left는 맨왼쪽 right는 맨오른쪽에서 시작
 *
 * while (left < right) {
 *     left + right가 x보다 크면 right를 앞으로 당기고 또 계산
 *     left + right가 x면 count 증가 시키고 left를 앞으로 밀기
 *     left + right가 x 보다 작으면 left를 앞으로 밀고 계산
 * }
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int X = Integer.parseInt(br.readLine());

        int left = 0, right = N - 1, count = 0;

        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == X) {
                count++;
                left++;
            } else if (sum < X) {
                left++;
            } else if (sum > X) {
                right--;
            }
        }

        System.out.println(count);
    }
}