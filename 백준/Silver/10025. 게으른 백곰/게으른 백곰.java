import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K =  Integer.parseInt(st.nextToken());

        int[] A = new int[1000001];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int ice =  Integer.parseInt(st.nextToken());
            int position =  Integer.parseInt(st.nextToken());

            A[position] = ice;
        }

        int windowSize = 2 * K + 1; // K + K + 1
        int sum = 0, maxSum = 0;

        for (int i = 0; i < 1000000; i++) {
            sum += A[i];

            if (i >= windowSize) {
                sum -= A[i - windowSize]; // 사이즈 넘어가면 맨 앞 하나 뺌
            }

            if (sum > maxSum) { // 합 체크
                maxSum = sum;
            }
        }

        System.out.println(maxSum);
    }
}