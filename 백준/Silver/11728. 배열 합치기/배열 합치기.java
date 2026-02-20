import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        int[] B = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }
        StringBuilder sb = new StringBuilder();

        int p1 = 0, p2 = 0;
        while (p1 < N && p2 < M) { // 숫자가 남아있을 때까지만
            if (A[p1] <= B[p2]) { // p1이 더 작거나 같다면 배열에 p1 추가
                sb.append(A[p1] + " ");
                p1++;
            } else { // p2가 더 작으면 배열에 p2 추가
                sb.append(B[p2] + " ");
                p2++;
            }

        }

        // 남아있는 것 추가
        while (p1 < N) { 
            sb.append(A[p1] + " ");
            p1++;
        }

        while (p2 < M) {
            sb.append(B[p2] + " ");
            p2++;
        }

        System.out.println(sb);
    }
}