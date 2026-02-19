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

        long total = A[N - 1]; // 가장 높은 점수 첫번째로
        K = K - 1; // 기회 한번 씀

        int start = 0, end = N - 2;

        while (K >= 2) { // 기회가 2번 이상일 때만 짝지음
            total += A[end] - A[start]; // 가장 맛없는 것과 가장 맛있는 것 묶음
            start++;
            end--;
            K -= 2;

        }
        System.out.println(total);
    }
}