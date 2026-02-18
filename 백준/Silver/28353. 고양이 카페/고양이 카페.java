import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);
        int start = 0, end = N - 1, count = 0;

        while (start < end) {
            int sum = A[start] + A[end]; // 가장 가벼운 고양이와 무거운 고양이 무게 더함
            if (sum <= K) { // 가벼우면
                count++; // 행복해지는 수 증가
                start++; // 그 다음 가벼운 고양이와
                end--; // 그 다음 무거운 고양이 계산

            } else if (sum > K) { // 무거우면
                end--; // 더 가벼운 고양이로 옮김
            }
        }

        System.out.println(count);
    }
}