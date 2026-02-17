import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 재료의 개수
        int M = Integer.parseInt(br.readLine()); // 갑옷을 만드는데 필요한 수
        int[] A =  new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A); // 정렬

        int start = 0, end = N - 1, count = 0;

        while (start < end) {
            int sum = A[start] + A[end];

            if (sum < M) {
                start++; // 큰 수로 이동
            } else if (sum > M) {
                end--; // 작은 수로 이동
            } else if (sum == M) {
                count++; // 갑옷 개수 증가
                start++; // 다음 작은 값으로 이동
                end--; // 다음 큰 값으로 이동
            }
        }
        System.out.println(count);
    }
}