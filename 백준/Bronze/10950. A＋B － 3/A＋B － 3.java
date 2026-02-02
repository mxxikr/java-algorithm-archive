import java.io.*;
import java.util.StringTokenizer;

/**
 * ==== 의사 코드 ====
 * N(입력 받기)
 * for(i = 1; i <= N; i++) {
 *     n(입력 받기)
 *     m(입력 받기)
 *     n + m 출력
 * }
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i ++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            System.out.println(n + m);
        }
    }

}