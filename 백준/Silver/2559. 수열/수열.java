import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
       
        int firstSum = 0; // 초기 값 세팅
        for (int i = 0; i < M; i++) {
            firstSum += arr[i];
        }

        int max = firstSum; // 최댓값 세팅

        for (int i = M; i < N; i++) {
            firstSum += arr[i];
            firstSum -= arr[i - M];
            max = Math.max(firstSum, max);
        }
        System.out.println(max);
    }
}