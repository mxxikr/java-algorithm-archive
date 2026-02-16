import java.io.*;
import java.util.*;

/**
 * ==== 의사 코드 ====
 * N K(입력 값 받기)
 * int[] arr[N] 선언
 *  for (int i = 0부터 N까지 ){
 *      arr[i] = st.token
 *  }
 *
 *  int sum = 0
 *  for (int i=0부터 K까지) {
 *      sum += arr[i]
 *  }
 *
 *  int max = sum
 *
 *  for (int K부터 N까지) {
 *      sum += arr[i]
 *      sum -= arr[i - K]
 *      if (sum > max) {
 *          max = sum
 *      }
 *  }
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr =  new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        for (int i = 0; i < K; i++) {
            sum += arr[i];
        }

        int max = sum;

        for (int i = K; i < N; i++) {
            sum += arr[i];
            sum -= arr[i - K];
            if (sum > max) {
                max = sum;
            }
        }

        System.out.println(max);
    }
}