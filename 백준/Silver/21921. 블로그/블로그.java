import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X =  Integer.parseInt(st.nextToken());
        int[] A = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        long sum = 0;
        for (int i = 0; i < X; i++) {
            sum += A[i]; // 첫번 째 창문
        }

        long maxSum = sum;
        int count = 1;

        for (int i = X; i < N; i++) {
            sum += A[i]; // 창문 오른쪽으로 이동
            sum -= A[i - X];

            if (sum > maxSum) {
                maxSum = sum;
                count = 1; // 최대 방문 수 초기화
            } else if (sum == maxSum) {
                count++; // 최대 방문수 나온 횟수 증가
            }
        }

        if (maxSum == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(maxSum);
            System.out.println(count);
        }
    }
}