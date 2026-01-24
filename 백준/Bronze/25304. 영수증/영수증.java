import java.io.*;
import java.util.StringTokenizer;

/**
 * ==== 의사 코드 ====
 * X(총합 입력 받기)
 * M(개수 입력 받기)
 * count(총합 저장할 변수)
 *
 * for (i = 0; i < M; i++) {
 *     n(물건 가격 입력 받기)
 *     m(물건 갯수 입력 받기)
 *     count += n * m
 * }
 *
 * if (count == X) {
 *     return "YES"
 * } else {
 *     "NO"
 * }
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int X = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int count = 0;

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            count += a * b;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        if (X == count) {
            bw.write("Yes");
        } else {
            bw.write("No");
        }

        bw.flush();
        bw.close();
    }

}