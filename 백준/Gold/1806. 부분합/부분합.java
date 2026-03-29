import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0, end = 0, sum = 0;
        int minCount = Integer.MAX_VALUE;

        while (end <= N) {
            if (sum >= S) {
                minCount = Math.min(minCount, end - start);
                sum -= arr[start];
                start++;

            } else if (end == N) {
                break;
            } else {
                sum += arr[end];
                end++;
            }
        }

        System.out.println(minCount == Integer.MAX_VALUE ? 0 : minCount);
    }
}